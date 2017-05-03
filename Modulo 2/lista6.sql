-- Primeiro nome

select top 1 substring(nome, 1 , CHARINDEX( ' ', nome)) as Primeiro_nome ,
count(*) as total 
from cliente 
group by substring(nome, 1 , CHARINDEX( ' ', nome))
order by total  desc

--Total do Mês

select count(*) as total  ,sum(valorPedido) 
from pedido 
where datepart (month, datapedido) = 4
and datepart (year, datapedido) = 2017

-- Estados x Clientes
select *from (select top 1 ci.uf as [UF] , count(cl.idcliente) as [Total clientes]
from cidade ci
inner join cliente cl on cl.idcidade = ci.idcidade 
group by ci.uf
order by [Total clientes] asc) a
union 
select*from  (select top 1 ci.uf as [UF] , count(cl.idcliente) as [Total clientes]
from cidade ci
inner join cliente cl on cl.idcidade = ci.idcidade 
group by ci.uf
order by [Total clientes]  desc) b 


--- Novo Produto

select*from produto 
insert into Produto (nome, precocusto , precovenda, situacao) 
  values  ('Galocha Maragato', 35.67, 77.95, 'A') 

  --Produtos não comprados

select pro.nome, pro.idproduto  from produto pro 
where pro.idproduto not in  (select idproduto from pedidoitem) and datepart(year, DataCadastro) = 2017


-- Principais Produtos

-- falta fazer 