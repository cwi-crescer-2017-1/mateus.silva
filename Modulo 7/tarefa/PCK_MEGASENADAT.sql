create or replace package body pck_megasena is

  /* Busca valores percentuais conforme regra definida na tabela 'Regra_Rateio_Premio' */
  function buscaPercentual(pIdentificador in varchar2) return number as
        -- 
        v_percentual  regra_rateio_premio.percentual%type; -- herdará as propriedades do campo percentual
      begin
        
        -- busca percentual conforme parametro de entrada
        select percentual
        into   v_percentual   -- atribuí valor para a variavel
        from   regra_rateio_premio
        where  identificador = lower(pIdentificador);
        
        return v_percentual;
      exception
        when no_data_found then
          dbms_output.put_line('Erro: '||pIdentificador);
          raise_application_error(-20002, sqlerrm);
      end buscaPercentual;
  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Executa o rateio dos premios conforme definção das regras */
  procedure defineRateioPremio (pPremio in number) as
    begin
    
       gPremio_sena          := buscaPercentual('premio_sena') * pPremio;
       gPremio_quina         := buscaPercentual('premio_quina') * pPremio;
       gPremio_quadra        := buscaPercentual('premio_quadra') * pPremio;
       gAcumulado_proximo_05 := buscaPercentual('acumulado_05') * pPremio;
       gAcumulado_final_ano  := buscaPercentual('acumulado_final_ano') * pPremio;
  
    end defineRateioPremio;

  ---------------------------------------------------------------------------------------------------------------------------------------
  /* Salva o registro referente ao concurso */
  procedure salvaConcurso (pConcurso in integer,
                           pData     in date,
                           pPremio   in number) as
    begin

       defineRateioPremio(pPremio);
       
       --insereConcurso( pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano );
       
       Insert into Concurso 
           (Idconcurso, Data_Sorteio, Premio_Sena, Premio_Quina, Premio_Quadra, Acumulado_Proximo_05, Acumulado_Final_Ano)
       Values 
           (pConcurso, pData, gPremio_Sena, gPremio_Quina, gPremio_Quadra, gAcumulado_proximo_05, gAcumulado_final_ano);
    end salvaConcurso;
  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "A" - implementar rotina que irá inserir um novo concurso
    */
  
PROCEDURE geraProximoConcurso (primeiraDezena integer,
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
VALUES (varUltimoConcurso+1, trunc(sysdate),varValorBruto*35/100, varValorBruto*19/100, varValorBruto*19/100, varValorBruto*22/100,
varValorBruto*5/100, primeiraDezena, segundaDezena, terceiraDezena, quartaDezena, quintaDezena, sextaDezena);

END geraProximoConcurso;

  ---------------------------------------------------------------------------------------------------------------------------------------
    /*
     Questão "B" - implementar rotina que irá inserir todos os acertadores de um determinado concurso
    */
PROCEDURE atualizaAcertadores (pConcurso in integer) AS
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
CURSOR apostas  (pIdAposta in number) IS
           SELECT  numero 
            FROM numero_aposta
            WHERE IdAposta = pIdAposta;

CURSOR byaposta 
 (pConcurso in number) IS
            SELECT IdAposta
            FROM aposta
            WHERE IdConcurso = pConcurso; 
BEGIN
SELECT premio_quadra INTO varPremioQuadra FROM concurso  WHERE idconcurso =pConcurso;
SELECT premio_quina INTO varPremioQuina FROM concurso  WHERE idconcurso =pConcurso;
SELECT premio_sena INTO varPremioSena FROM concurso  WHERE idconcurso =pConcurso;
SELECT primeira_dezena INTO varPrimeiraDezena from concurso  WHERE idconcurso = pConcurso;
SELECT segunda_dezena INTO varSegundaDezena FROM concurso  WHERE idconcurso = pConcurso;
SELECT terceira_dezena INTO varTerceiraDezena FROM concurso  WHERE idconcurso = pConcurso;
SELECT quarta_dezena INTO varQuartaDezena FROM concurso  WHERE idconcurso = pConcurso;
SELECT quinta_dezena INTO varQuintaDezena FROM concurso  WHERE idconcurso = pConcurso;
SELECT sexta_dezena INTO varSextaDezena FROM concurso  WHERE idconcurso = pConcurso;
FOR aposta  IN byaposta (pConcurso)LOOP
 varacertos:=0;
    FOR apostador IN apostas (aposta.IdAposta )LOOP    
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
        INSERT INTO aposta_premiada (idaposta, acertos, valor) VALUES (aposta.idaposta, 4, 0);
      ELSIF (varacertos =5)THEN
        INSERT INTO aposta_premiada (idaposta, acertos, valor) VALUES (aposta.idaposta, 5, 0);
      ELSIF (varacertos =6)THEN
         INSERT INTO  aposta_premiada (idaposta, acertos, valor) VALUES (aposta.idaposta, 6, 0);
      END IF;
  END LOOP;
SELECT COUNT(acertos) INTO  varQtdAcertadores4Numero FROM  aposta_premiada WHERE acertos=4;
SELECT COUNT(acertos) INTO varQtdAcertadores5Numero FROM aposta_premiada  WHERE  acertos=5;
SELECT COUNT(acertos) INTO  varQtdAcertadores6Numero  FROM aposta_premiada  WHERE  acertos=6;
UPDATE aposta_premiada SET valor = varPremioQuadra/varQtdAcertadores4Numero  WHERE  acertos = 4;
UPDATE aposta_premiada SET valor = varPremioQuina/varQtdAcertadores5Numero  WHERE  acertos = 5;
UPDATE aposta_premiada SET valor = varPremioSena/varQtdAcertadores6Numero  WHERE  acertos = 6;
SELECT  COUNT(acertos)INTO varacumulou  FROM aposta_premiada WHERE acertos = 6;
    IF (varacumulou>0)THEN
        UPDATE concurso SET acumulou = 1  WHERE  idconcurso = pConcurso;
     ELSE
        UPDATE concurso SET acumulou = 0  WHERE  idconcurso = pConcurso;
     END IF;
 END atualizaAcertadores;
begin
  -- Initialization
  null; --<Statement>;
end pck_megasena;