
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
varQtdAcertadores4Numero integer;
varQtdAcertadores5Numero integer;
varQtdAcertadores6Numero integer;
varacumulou integer;
varacertos integer;
varPrimeiraDezena integer;
varSegundaDezena integer;
varTerceiraDezena integer;
varQuartaDezena integer;
varQuintaDezena integer;
varSextaDezena integer;
 
CURSOR apostas IS 
  select*from numero_aposta where idaposta in (select idaposta   from aposta  where idconcurso =pconcurso);
 
Cursor byaposta IS 
 select idaposta from (select*from numero_aposta where idaposta in (select idaposta   from aposta  where idconcurso =pconcurso))
 group by idaposta;
 
begin

SELECT premio_quadra into varPremioQuadra FROM concurso where idconcurso = pConcurso;
SELECT premio_quina into varPremioQuina FROM concurso where idconcurso = pConcurso;
SELECT premio_sena into varPremioSena FROM concurso where idconcurso = pConcurso;

select primeira_dezena into varPrimeiraDezena from concurso where idconcurso = pConcurso;
select segunda_dezena into varSegundaDezena from concurso where idconcurso = pConcurso;
select terceira_dezena into varTerceiraDezena from concurso where idconcurso = pConcurso;
select quarta_dezena into varQuartaDezena from concurso where idconcurso = pConcurso;
select quinta_dezena into varQuintaDezena from concurso where idconcurso = pConcurso;
select sexta_dezena into varSextaDezena from concurso where idconcurso = pConcurso;


FOR a  in byaposta LOOP
    FOR b in apostas LOOP
    IF(a.idaposta = b.idaposta) THEN
         IF (b.numero = varPrimeiraDezena)THEN
             varacertos := varacertos+1;
         ELSIF (b.numero = varSegundaDezena)THEN
             varacertos := varacertos+1;
         ELSIF (b.numero = varTerceiraDezena)THEN
              varacertos := varacertos+1;
         ELSIF (b.numero = varQuartaDezena)THEN
              varacertos := varacertos+1;
          ELSIF (b.numero = varQuintaDezena)THEN
              varacertos := varacertos+1;
          ELSIF (b.numero = varSextaDezena)THEN
              varacertos := varacertos+1;
         END IF;
      END IF; 
    END LOOP;
      IF (varacertos =4)THEN
          update aposta_premiada set acertos =4 where idaposta = a.idaposta;
      ELSIF (varacertos =5)THEN
         update aposta_premiada set acertos =5 where idaposta = a.idaposta;
      ELSIF (varacertos =6)THEN
         update aposta_premiada set acertos =6 where idaposta = a.idaposta;
      END IF;
      varacertos:=0;
END LOOP;
select count(acertos) into varQtdAcertadores4Numero  from aposta_premiada where acertos=4;
select count(acertos) into varQtdAcertadores5Numero from aposta_premiada where acertos=5;
select count(acertos) into varQtdAcertadores6Numero  from aposta_premiada where acertos=6;

Update aposta_premiada set valor = varPremioQuadra/varQtdAcertadores4Numero where acertos = 4;
Update aposta_premiada set valor = varPremioQuina/varQtdAcertadores5Numero where acertos = 5;
Update aposta_premiada set valor = varPremioSena/varQtdAcertadores6Numero where acertos = 6;

select  count(acertos)into varacumulou  from aposta_premiada where acertos = 6;
    IF (varacumulou>0)THEN
        UPDATE concurso set acumulou = 'não' where idconcurso = pConcurso;
     ELSE 
        UPDATE concurso set acumulou = 'sim' where idconcurso = pConcurso;
     END IF;
 END atualizaAcertadores;