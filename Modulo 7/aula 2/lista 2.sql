-------------Exercício 1
DECLARE
vcidade Cidade.Nome%type;
vid Cidade.idcidade%type;
CURSOR C_ListaCidade IS
    select nome, uf , count(1)  as contador from cidade group by nome, uf HAVING 
COUNT(1) > 1;

CURSOR C_Cliente IS
    select nome, idcidade from cliente;
    
CURSOR C_Cidades IS
    select nome, idcidade from Cidade;
BEGIN
   FOR i IN C_ListaCidade LOOP
        vcidade :=  i.nome;
        FOR a IN C_Cidades LOOP
            if (vcidade = a.nome)then
                   vid := a.idcidade;
                for cli in C_Cliente loop
                    if (cli.idcidade = a.idcidade)then
                       DBMS_OUTPUT.PUT_LINE(cli.nome);
                       exit;
                      end if;
                end loop;  
             end if;   
        end loop;
   END LOOP;
END;

--------------Exercício 2
DECLARE
valorTotal Pedido.valorPedido%type;
varId Pedido.idpedido%type;
CURSOR c_pedidoItem IS
    SELECT idpedido,quantidade, precounitario  
    FROM pedidoItem 
    WHERE idpedido =: varId;
BEGIN
        FOR a IN c_pedidoItem LOOP 
           valorTotal := valorTotal+ (a.quantidade*a.precoUnitario);
        END LOOP;
        UPDATE pedido
        SET valorpedido = valortotal
        WHERE idpedido =varid;
END;

-------------Exercício 3       
 


DECLARE 

CURSOR C_Cliente IS
SELECT idcliente from (
SELECT*FROM pedido MINUS (SELECT*FROM pedido 
WHERE datapedido >add_months(trunc(sysdate), -6)));
BEGIN 
    FOR i IN C_Cliente LOOP
       UPDATE cliente set situacao = 'I' where idcliente =  i.idcliente;
    END LOOP;
END;

----------Exercício 4

DECLARE 
CURSOR C_MaterialID IS
SELECT*FROM produtomaterial where idproduto=:IdProdutoQuery ;

soma pedidoitem.quantidade%type;

CURSOR C_Material IS
SELECT*FROM material;
BEGIN
select sum( quantidade) INTO soma from pedidoitem where idpedido in (select idpedido from pedidoitem where idproduto =: IdProdutoQuery and idpedido in (
select idpedido from (select*from pedido where EXTRACT (MONTH FROM datapedido)=:mes AND EXTRACT (YEAR FROM datapedido) =:ano)) );

FOR a  in C_MaterialID LOOP
    FOR c in C_Material LOOP
        IF  (a.idmaterial = c.idmaterial)then
            DBMS_OUTPUT.PUT_LINE( c.descricao);
            DBMS_OUTPUT.PUT_LINE(a.quantidade*soma);
        END IF;
     END LOOP;
END LOOP;
END;

