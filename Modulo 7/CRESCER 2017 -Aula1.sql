SELECT idproduto, nome FROM produto WHERE idproduto not in(
SELECT t1.idproduto
FROM produto t1 JOIN pedidoitem t2
ON t1.idproduto = t2.idproduto
where t2.idpedido  in (
select idpedido from pedido where datapedido
BETWEEN trunc(sysdate) -120 AND trunc(sysdate)))
GROUP BY idproduto, nome;