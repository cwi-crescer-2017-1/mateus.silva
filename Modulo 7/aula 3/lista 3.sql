create or replace package  pck_EliminarCidadesDuplicadas as

PROCEDURE Proc_CidadesDuplicadas;
end;

create or replace package body pck_EliminarCidadesDuplicadas as

 PROCEDURE Proc_CidadesDuplicadas IS

vcidade Cidade.Nome%type;
vid Cidade.idcidade%type;
vidMEnor Cidade.idcidade%type;
CURSOR C_ListaCidade IS
    select nome, uf ,  count(1)  as contador from cidade group by nome, uf HAVING 
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
                     select min(idcidade) into vidMEnor from cidade where nome like i.nome ;
                     update cliente set idcidade = vidmenor where idcidade=a.idcidade;
               end if; 
           end loop;
        end if;   
        end loop;
        FOR a IN C_Cidades LOOP
           if (vcidade = a.nome)then  
              select min(idcidade) into vidMEnor from cidade where nome like i.nome ;
              delete cidade where nome = i.nome and idcidade != vidmenor;           
            end if;   
        end loop;
   END LOOP;
END;
END Proc_CidadesDuplicadas;


end;


