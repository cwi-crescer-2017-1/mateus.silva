--Datas

select projeto as [Projeto],
datediff(month, data_inicio_prev, data_fim_prev) as [Tempo Previsto em Meses],
datediff (month, data_inicio_real, data_fim_real) as [Tempo Realizado em Meses]
from licitacao 
where data_inicio_real > data_inicio_prev


--Ranking 

select top 10 Empresa_Licitante as [Empresa],
sum(valor_realizado) as [Total Faturamento],
(sum(valor_realizado)/sum(profissionais))as [Valor M�dio por Profissional]
from licitacao
group by Empresa_Licitante
order by [Total Faturamento] desc

-- Top Cidades 

select top 10 municipio as [Cidade],
sum(Imposto_Federal + Imposto_Estadual + Imposto_Municipal)as [Total de Impostos Arrecadados]
from licitacao 
group by municipio 
order by  [Total de Impostos Arrecadados] desc 



--Finais de semana

select  projeto as [Projetos] 
from licitacao 
where datepart(WEEKDAY, data_inicio_real) = 1 
or datepart(WEEKDAY, data_inicio_real) =7


--Empresas com sorte

select Empresa_Licitante as [Empresa]
from licitacao 
group by  Empresa_Licitante
having sum(valor_previsto)  > sum(faturamento_1Ano_anterior)*1.50
or sum(valor_realizado)  > sum(faturamento_1Ano_anterior)*1.50


-- Custo real

 select projeto as [Projeto], 
 case 
 when 
 esfera = 'Federal' then valor_realizado - imposto_federal
 when 
 esfera = 'Estadual' then valor_realizado - imposto_estadual
 when 
 esfera = 'Municipal' then valor_realizado - imposto_municipal 
 end  as [Custo Real]
 from licitacao 
 
