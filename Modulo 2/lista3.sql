    --Datas
select IDempregado as ID,
	 NomeEmpregado as Nome,
	 datediff(year,DataNascimento, dataAdmissao) - 
	 case 
	 when 
	 dateadd (year,datediff (year,DataNascimento, dataadmissao), dataNascimento) > getdate() then 1
	 else 0
	 end as [Idade no momento da admissão],
	 DataAdmissao as  [Admissão]
	 from empregado
	 where  year (DataAdmissao) = 1980

	--Ranking

	 
	 select top 1 cargo, count(1) as total 
	 from empregado
	 group by cargo
	 order by total desc
	
   