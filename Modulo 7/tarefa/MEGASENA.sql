
create or replace PROCEDURE geraProximoConcurso (primeiraDezena integer,
                                segundaDezena integer, 
                                terceiraDezena integer,
                                quartaDezena integer, 
                                quintaDezena integer,
                                sextaDezena integer) IS
varUltimoConcurso concurso.idconcurso%type;
varValorBruto aposta.valor%type;

BEGIN 
SELECT MAX(idconcurso) INTO varUltimoConcurso  FROM concurso;
SELECT SUM(VALOR)*(45.3/100) INTO varValorBruto FROM aposta WHERE idconcurso = varUltimoConcurso;

INSERT INTO CONCURSO (idconcurso, data_sorteio, premio_sena, premio_quina, premio_quadra, acumulado_proximo_05, acumulado_final_ano
,primeira_dezena, segunda_Dezena, terceira_dezena, quarta_dezena, quinta_dezena, sexta_dezena)
values (varUltimoConcurso+1, trunc(sysdate),varValorBruto*35/100, varValorBruto*19/100, varValorBruto*19/100, varValorBruto*22/100,
varValorBruto*5/100,
primeiraDezena, segundaDezena, terceiraDezena, quartaDezena, quintaDezena, sextaDezena);

END geraProximoConcurso;

create or replace PROCEDURE atualizaAcertadores (pConcurso in integer) as
varPremioQuadra concurso.premio_quadra%type;
varPremioQuina concurso.premio_quadra%type;
varPremioSena concurso.premio_quadra%type;
varQtdAcertadores4Numero number;
varQtdAcertadores5Numero number;
varQtdAcertadores6Numero number;
varacumulou concurso.acumulou%type;
varacertos aposta_premiada.acertos%type;
varPrimeiraDezena concurso.primeira_dezena%type;
varSegundaDezena concurso.primeira_dezena%type;
varTerceiraDezena concurso.primeira_dezena%type;
varQuartaDezena concurso.primeira_dezena%type;
varQuintaDezena concurso.primeira_dezena%type;
varSextaDezena concurso.primeira_dezena%type;
CURSOR apostas  (pIdAposta in number) is
           select  numero 
            from numero_aposta
            where IdAposta = pIdAposta;

  Cursor byaposta 
 (pConcurso in number) is
            select IdAposta
            from aposta
            where IdConcurso = pConcurso; 
BEGIN
SELECT premio_quadra into varPremioQuadra FROM concurso where idconcurso =pConcurso;
SELECT premio_quina into varPremioQuina FROM concurso where idconcurso =pConcurso;
SELECT premio_sena into varPremioSena FROM concurso where idconcurso =pConcurso;
SELECT primeira_dezena into varPrimeiraDezena from concurso where idconcurso = pConcurso;
SELECT segunda_dezena into varSegundaDezena from concurso where idconcurso = pConcurso;
SELECT terceira_dezena into varTerceiraDezena from concurso where idconcurso = pConcurso;
SELECT quarta_dezena into varQuartaDezena from concurso where idconcurso = pConcurso;
SELECT quinta_dezena into varQuintaDezena from concurso where idconcurso = pConcurso;
SELECT sexta_dezena into varSextaDezena from concurso where idconcurso = pConcurso;
FOR aposta  in byaposta (pConcurso)LOOP
 varacertos:=0;
    FOR apostador in apostas (aposta.IdAposta )LOOP    
         IF (apostador.numero = varPrimeiraDezena)THEN
             varacertos := varacertos+1;
         ELSIF (apostador.numero = varSegundaDezena)THEN
             varacertos := varacertos+1;
         ELSIF (apostador.numero = varTerceiraDezena)THEN
              varacertos := varacertos+1;
         ELSIF (apostador.numero = varQuartaDezena)THEN
              varacertos := varacertos+1;
          ELSIF (apostador.numero = varQuintaDezena)THEN
              varacertos := varacertos+1;
          ELSIF (apostador.numero = varSextaDezena)THEN
              varacertos := varacertos+1;
         END IF;
    END LOOP;
      IF (varacertos =4)THEN
        Insert into aposta_premiada (idaposta, acertos, valor) values (aposta.idaposta, 4, 0);
      ELSIF (varacertos =5)THEN
         Insert into aposta_premiada (idaposta, acertos, valor) values (aposta.idaposta, 5, 0);
      ELSIF (varacertos =6)THEN
         Insert into aposta_premiada (idaposta, acertos, valor) values (aposta.idaposta, 6, 0);
      END IF;
  END LOOP;
select count(acertos) into varQtdAcertadores4Numero  from aposta_premiada where acertos=4;
select count(acertos) into varQtdAcertadores5Numero from aposta_premiada where acertos=5;
select count(acertos) into varQtdAcertadores6Numero  from aposta_premiada where acertos=6;
Update aposta_premiada set valor = varPremioQuadra/varQtdAcertadores4Numero where acertos = 4;
Update aposta_premiada set valor = varPremioQuina/varQtdAcertadores5Numero where acertos = 5;
Update aposta_premiada set valor = varPremioSena/varQtdAcertadores6Numero where acertos = 6;
select  count(acertos)into varacumulou  from aposta_premiada where acertos = 6;
    IF (varacumulou>0)THEN
        UPDATE concurso set acumulou = 1 where idconcurso = pConcurso;
     ELSE
        UPDATE concurso set acumulou = 0 where idconcurso = pConcurso;
     END IF;
 END atualizaAcertadores;