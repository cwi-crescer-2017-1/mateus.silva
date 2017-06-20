--Auditoria para Aposta
Create table AuditoriaMegaAposta (
  IDLogAudiAposta   integer not null,
  Usuario        varchar2(30),
  Data           date default sysdate,  
  Operacao       char(14) not null,
    constraint PK_IDLogAudiAposta
       primary key (IDLogAudiAposta)
);

Create sequence sqAuditoriaMegaAposta;
-- Trigger para Aposta;
create or replace
trigger AUD_APOSTA
    after insert or update or delete on APOSTA
Declare
  v_operacao char(14);
Begin

  if INSERTING then
     v_operacao := 'Insert';
  elsif UPDATING then
     v_operacao := 'Update';       
  else
     v_operacao := 'Delete';
  end if;
  Insert into AuditoriaMegaAposta (IDLogAudiAposta, data, usuario, operacao)
      values (sqAuditoriaMegaAposta.nextval, sysdate, user, v_operacao);

End AUD_APOSTA;


--Auditoria para Numero_Aposta
Create table AuditoriaMegaNumeroAposta (
  IDLogAudiNumeroAposta  integer not null,
  Usuario        varchar2(30),
  Data           date default sysdate,  
  Operacao       char(14) not null,
    constraint PK_IDLogAudiNumeroAposta
       primary key (IDLogAudiNumeroAposta)
);

Create sequence sqAuditoriaMegaNumeroAposta;
-- Trigger para Numero_Aposta;
create or replace
trigger AUD_NumeroAposta
    after insert or update or delete on Numero_Aposta
Declare
  v_operacao char(14);
Begin

  if INSERTING then
     v_operacao := 'Insert';
  elsif UPDATING then
     v_operacao := 'Update';       
  else
     v_operacao := 'Delete';
  end if;
  Insert into  AuditoriaMegaNumeroAposta ( IDLogAudiNumeroAposta , data, usuario, operacao)
      values (sqAuditoriaMegaNumeroAposta.nextval, sysdate, user, v_operacao);

End AUD_NumeroAposta;

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

-------3
