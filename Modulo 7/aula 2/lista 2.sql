--Exercício 1
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

