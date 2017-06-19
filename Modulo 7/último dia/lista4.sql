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



Create or replace Procedure Estados  is

cursor C_estados is
select uf, idcidade from cidade where idcidade in (select idcidade from aposta);

cursor cidades  (v_uf in cidade.uf%type) IS
       select idcidade from cidade where uf = v_uf;
       
Cursor valores  IS
       select idcidade, idconcurso, count (idcidade)
       as contadorDeCidades , sum(valor) as 
       ValorArrecadado from aposta group by idcidade, idconcurso;

BEGIN
FOR estado in c_estados LOOP