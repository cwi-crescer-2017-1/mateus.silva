--1
---------------------------------------
--Auditoria para Aposta
Create table AuditoriaMegaAposta (
  IDLogAudiAposta   integer not null,
  Usuario        varchar2(30),
  Data           date default sysdate,  
  Operacao       char(14) not null,
  idapostaantigo integer,
  idapostanovo integer ,
  concursoAntigo integer ,
  concursoNovo integer,
  qtdNumerosAntigo integer,
  qtdNumerosNovo integer,
  valorAntigo number, 
  ValorNovo number,
    constraint PK_IDLogAudiAposta
       primary key (IDLogAudiAposta)
);

Create sequence sqAuditoriaMegaAposta;
-- Trigger para Aposta;
create or replace
trigger AUD_APOSTA
    after insert or update or delete on APOSTA
    for each row
Declare
  v_operacao char(14);
   vapostaAntiga integer;
  vapostaNova integer ;
  vconcursoAntigo integer ;
  vconcursoNovo integer;
  vqtdNumerosAntigo integer;
  vqtdNumerosNovo integer;
  vvalorAntigo number;
  vValorNovo number;
Begin

  if INSERTING then
     v_operacao := 'Insert';
     vapostaAntiga :=null;
     vapostaNova := :new.idaposta;
     vconcursoAntigo := null;
     vconcursoNovo  := :new.idconcurso;
     vqtdNumerosAntigo := null;
     vqtdNumerosNovo := :new.quantidade_numeros;
     vvalorAntigo := null;
     vValorNovo := :new.valor;
  elsif UPDATING then
     v_operacao := 'Update';    
     vapostaAntiga := :old.idaposta;
     vapostaNova := :new.idaposta;
     vconcursoAntigo := :old.idconcurso;
     vconcursoNovo  := :new.idconcurso;
     vqtdNumerosAntigo := :old.idconcurso;
     vqtdNumerosNovo := :new.quantidade_numeros;
     vvalorAntigo := :old.valor;
     vValorNovo := :new.valor;
  else
     v_operacao := 'Delete';
  end if;
  Insert into AuditoriaMegaAposta (IDLogAudiAposta, data, usuario, operacao,  idapostaantigo ,
  idapostanovo,
  concursoAntigo ,
  concursoNovo ,
  qtdNumerosAntigo,
  qtdNumerosNovo ,
  valorAntigo,
  ValorNovo)
      values (sqAuditoriaMegaAposta.nextval, sysdate, user, v_operacao,   vapostaAntiga,
  vapostaNova ,
  vconcursoAntigo ,
  vconcursoNovo ,
  vqtdNumerosAntigo,
  vqtdNumerosNovo,
  vvalorAntigo ,
  vValorNovo );

End AUD_APOSTA;

--Auditoria para Numero_Aposta
Create table AuditoriaMegaNumeroAposta (
  IDLogAudiNumeroAposta  integer not null,
  Usuario        varchar2(30),
  Data           date default sysdate,  
  Operacao       char(14) not null,
  idapostaNovo integer,
  idapostaAntigo integer,
  numeroNovo number,
  numeroAntigo number,
    constraint PK_IDLogAudiNumeroAposta
       primary key (IDLogAudiNumeroAposta)
);

Create sequence sqAuditoriaMegaNumeroAposta;
-- Trigger para Numero_Aposta;
create or replace
trigger AUD_NumeroAposta
    after insert or update or delete on Numero_Aposta
    for each row
Declare
  v_operacao char(14);
  vidapostaNovo integer;
  vidapostaAntigo integer;
  vnumeroNovo number;
  vnumeroAntigo number;
Begin

  if INSERTING then
     v_operacao := 'Insert';
     vidapostaNovo := :new.idaposta;
     vidapostaAntigo := null;
     vnumeroNovo := :new.numero;
     vnumeroAntigo:= null;
     
  elsif UPDATING then
     v_operacao := 'Update';    
     vidapostaNovo := :new.idaposta;
     vidapostaAntigo := :old.idaposta;
     vnumeroNovo := :new.numero;
     vnumeroAntigo:= :old.numero;
  else
     v_operacao := 'Delete';
  end if;
  Insert into  AuditoriaMegaNumeroAposta ( IDLogAudiNumeroAposta , data, usuario, operacao, idapostaNovo ,
     idapostaAntigo, numeroNovo,numeroAntigo)
      values (sqAuditoriaMegaNumeroAposta.nextval, sysdate, user, v_operacao,  vidapostaNovo ,  vidapostaAntigo,  vnumeroNovo,  vnumeroAntigo);

End AUD_NumeroAposta;
-------------------------------------------------------
-----2

DECLARE 

CURSOR estados IS
SELECT UF from cidade where idcidade in (select idcidade from aposta) group by uf;

cursor  concursos is 
select idconcurso from concurso;

cursor  apostas (v_uf in varchar, v_idconcurso in integer) is
select  sum(valor) as valor from aposta where idcidade in (select idcidade from cidade where uf  like v_uf ) and idconcurso = v_idconcurso;
v_valor aposta.valor%type;

cursor  acertos (v_uf in varchar, v_idconcurso in integer) is
select count (acertos) as qtd, sum (valor) as premio from aposta_premiada where idaposta in( select  idaposta from aposta where idcidade in
(select idcidade from cidade where uf  like v_uf ) and idconcurso = v_idconcurso);
v_valor aposta.valor%type;


BEGIN 
FOR estado in estados LOOP
   FOR concurso in concursos LOOP
     FOR aposta in apostas (estado.uf, concurso.idconcurso) LOOP
           For acerto in acertos( estado.uf, concurso.idconcurso)  LOOP
             DBMS_OUTPUT.PUT_LINE('ESTADO: ' || estado.uf || '; Total Arrecadado: ' || aposta.valor ||  
             '; Concurso: '  || concurso.idconcurso || '; Total de Acertadores: '|| acerto.qtd 
             || '; Valor da Premiação: ' ||acerto.premio);
            END LOOP;
        END LOOP;
                END LOOP;

        END LOOP;
END;

------------------------------------
--3---------------------------
create view PossiveisFraudes AS 
Select aposta.idaposta as IdAPosta_com_Possiveis_Fraudes 
from aposta, AuditoriaMegaNumeroAposta, AuditoriaMegaAposta
where aposta.idaposta in 
( select idaposta from aposta where data_hora< 
AuditoriaMegaAposta.data and idaposta = AuditoriaMegaAposta.idapostanovo or 
 data_hora <  AuditoriaMegaNumeroAposta.data and idaposta =
AuditoriaMegaNumeroAposta.idapostanovo)
group by idaposta;
 
 