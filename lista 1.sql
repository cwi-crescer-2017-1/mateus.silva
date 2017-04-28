 


Select*into  CidadeAux from CopiaCidade;
truncate table CidadeAux 
insert into CidadeAux  select* from Cidade where UF = 'RS';
select*from CidadeAux
drop table produto 
create table Produto (
Codigo int identity not null,
NomeCurto varchar(14) not null,
NomeDescritivo varchar(20) not null,
DataCriacao varchar(10) not null,
LocalNoEstoque varchar(5) not null ,
Quantidade varchar(10) not null,
Preco decimal(9,2) not null ,
constraint PK_Produto primary key (codigo))

insert into Produto 
( Nomecurto, NomeDescritivo, dataCriacao, localNoEstoque, quantidade, preco)
values 
( 'salto', 'saltoAlto', '28-04-2017', 'B1', '4', ' 435.00') 
insert into Produto 
( Nomecurto, NomeDescritivo, dataCriacao, localNoEstoque, quantidade, preco)
values 
( 'salto', 'saltoBaixo', '28-04-2016', 'A2', '5', ' 44.00') 
select*from Produto;