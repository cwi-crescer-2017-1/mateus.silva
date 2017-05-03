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

select uf, count(*) as totalClientes   from cidade
where idcidade in  (select  idcidade from cliente )--group by idcidade order by count(*) desc  ) 
group by uf
order by totalclientes  desc 

--- Novo Produto

select*from produto 
insert into Produto (nome, precocusto , precovenda, situacao) 
  values  ('Galocha Maragato', 35.67, 77.95, 'A') 

  --Produtos não comprados
