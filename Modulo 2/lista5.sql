
-- Múltiplos acessos

select e.nomeEmpregado as [nome do empregado],
		e.iddepartamento as [departamento],
        g.nomeEmpregado as [nome do gerente],
		g.iddepartamento as [departamento]
	    from    empregado e 
	    inner join empregado g on e.idgerente = g.idempregado
	 
--Maior Salário

 select top 1 e.iddepartamento , d.nomedepartamento as [nome do departamento]
 from departamento d
 right join empregado e on   d.iddepartamento = e.iddepartamento 
 order by e.salario desc
 
 -- Reajuste salarial 
select*into copiaempregado from empregado  
begin transaction 
update empregado
set salario = salario*1.173
where iddepartamento in (select iddepartamento from departamento where localizacao = 'SAO PAULO')
commit 
go  -- Cidades duplicadas
select Nome, UF from cidade where nome   in (  select nome from cidade   group by nome, uf  having count(*)>1 ) 