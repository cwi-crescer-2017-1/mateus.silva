--1
SELECT idproduto, nome FROM produto WHERE idproduto not in(
SELECT t1.idproduto
FROM produto t1 JOIN pedidoitem t2
ON t1.idproduto = t2.idproduto
WHERE  t2.idpedido  in (
SELECT idpedido FROM pedido WHERE  datapedido
>(trunc(sysdate) -120)))
order by idproduto;

--2
UPDATE  produto SET situacao =  'I' WHERE  idproduto not in(
SELECT t1.idproduto
FROM produto t1 JOIN pedidoitem t2
ON t1.idproduto = t2.idproduto
WHERE  t2.idpedido  in (
SELECT idpedido FROM pedido WHERE  datapedido
>(trunc(sysdate) -120)));
commit;

--3
SELECT COUNT (t1.idpedidoitem) FROM pedidoItem t1 JOIN pedido t2
ON t1.idpedido= t2.idpedido
WHERE t1.idproduto =: idproduto  and t2.idpedido 
in (SELECT idpedido FROM pedido WHERE  datapedido
>('01-01-17'));
