select IDempregado as ID,
	 NomeEmpregado as Nome,
	 datediff(year,DataNascimento, dataAdmissao) - 
	 case 
	 when 
	 dateadd (year,datediff (year,DataNascimento, dataadmissao), dataNascimento) > getdate() then 1
	 else 0
	 end as [Idade no momento da admiss�o],
	 DataAdmissao as  [Admiss�o]
	 from empregado
	 where  year (DataAdmissao) = 1980