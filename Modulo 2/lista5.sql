
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
 
