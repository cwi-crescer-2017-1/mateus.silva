--Exerc�cio 1
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

--Exerc�cio 2
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

--Exerc�cio 3       
--Crie uma rotina que atualize todos os clientes que n�o realizaram nenhum pedido 
--nos �ltimos 6 meses (considere apenas o m�s, dia 01 do 6� m�s anterior). Definir o atributo Situacao para I.   


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

