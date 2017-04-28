



Select IDEmpregado as ID, 
nomeEmpregado as nome
from empregado
Order by dataadmissao asc


select*  
from empregado 
where comissao is null 
order by salario asc 

select IDempregado as [ID do Empregado],
nomeEmpregado as [Nome],
(salario*13) as [Salario Anual],
(isnull (comissao, 0)*12) as [Comissao Anual],
(salario*13 +  isnull (comissao, 0)*12) as [Renda Aual]
from empregado   


select IDempregado as [ID do Empregado],
nomeEmpregado as [Nome],
cargo as [Cargo],
salario as [Salario Mensal]
from empregado 
where (salario*13) < 18500

 



