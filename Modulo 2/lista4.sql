--Datas

select projeto as [Projeto],
datediff(month, data_inicio_prev, data_fim_prev) as [Tempo Previsto em Meses],
datediff (month, data_inicio_real, data_fim_real) as [Tempo Realizado em Meses]
from licitacao 
where data_inicio_real > data_inicio_prev


--Ranking 

select top 10 Empresa_Licitante as [Empresa],
sum(valor_realizado) as [Total Faturamento],
(sum(valor_realizado)/sum(profissionais))as [Valor Médio por Profissional]
from licitacao
group by Empresa_Licitante
order by [Total Faturamento] desc

