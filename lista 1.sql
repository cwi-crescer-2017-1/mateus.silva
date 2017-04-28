 


Select*into  CidadeAux from CopiaCidade;
truncate table CidadeAux 
insert into CidadeAux  select* from Cidade where UF = 'RS';
select*from CidadeAux
drop table produto 
create table Produto (
Codigo          int identity   not null,
NomeCurto       varchar(14)    not null,
NomeDescritivo  varchar(20)    not null,
DataCriacao     varchar(20)    not null,
LocalNoEstoque  varchar(5)     not null,
Quantidade      varchar(10)    not null,
Preco           decimal(9,2)   not null,
constraint PK_Produto primary key (codigo))

insert into Produto 
( Nomecurto, NomeDescritivo, dataCriacao, localNoEstoque, quantidade, preco)
values 
( 'Salto', 'Salto Alto', GETDATE(), 'B1', '4', ' 435.00') 
insert into Produto 
( Nomecurto, NomeDescritivo, dataCriacao, localNoEstoque, quantidade, preco)
values 
( 'Salto', 'Salto Baixo', GETDATE(), 'A2', '5', ' 44.00') 
select*from Produto;