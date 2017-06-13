CREATE TABLE PESSOA (
IDPessoa    integer not null,
Nome varchar2(30) not null,
constraint PK_Pessoa primary Key (IDPessoa) );

Create sequence SQPessoa;

Insert into Pessoa (IDPessoa, Nome)
values (SQPessoa.nextval, 'Mateus');

commit;

select*from pessoa