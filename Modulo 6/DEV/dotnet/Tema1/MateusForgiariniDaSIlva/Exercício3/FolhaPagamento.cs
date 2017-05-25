using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercício3
{
    public class FolhaPagamento : IFolhaPagamento
    {

        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)

        {
            double parse = horasCategoria;
            var ValorHora = salarioBase / horasCategoria;
            var totalHorasExtras = horasExtras * ValorHora;
            var totalHorasDescontadas = horasDescontadas * ValorHora;
            var horaExtra = new HorasCalculadas(horasExtras, totalHorasExtras);
            var horaDescontada = new HorasCalculadas(horasDescontadas, totalHorasDescontadas);
            var totalProventos = salarioBase + totalHorasExtras -totalHorasDescontadas;
            var inss = new Desconto(aliquotaINSS(totalProventos, salarioBase), calcularINSS(totalProventos, salarioBase));
            var irrf = new Desconto(aliquotaIRRF(totalProventos, salarioBase), calcularIRRF(totalProventos, salarioBase));
            var totalDescontos = calcularIRRF(totalProventos, salarioBase) +  calcularINSS(totalProventos, salarioBase);
            var totalLiquido = (Math.Truncate(totalProventos*100) / 100 - Math.Truncate(totalDescontos * 100) / 100) * 100)
           

            return new Demonstrativo(salarioBase, parse, horaExtra, horaDescontada, totalProventos, inss, irrf, totalDescontos,
                totalLiquido, fgts);

        }

        public double calcularINSS(double totalProventos, double salarioBase)
        {
            if (salarioBase < 1001)
            {
                return totalProventos * 8 / 100;
            }
            else if (salarioBase <1501)
            {
                return totalProventos * 9 / 100;
            }
            else
            {
                return totalProventos * 10 / 100;
            }
        }
        public double aliquotaINSS(double totalProventos, double salarioBase)
        {
            if (salarioBase <1001)
            {
                return 0.08;
            }
            else if (salarioBase < 1501)
            {
                return 0.09;
            }
            else
            {
                return 0.10;
            }
        }

        public double calcularIRRF(double totalProventos, double salarioBase)
        {
            if (totalProventos - calcularINSS(totalProventos, salarioBase) < 1710.79)
            {
                return 0;
            }
            else if (totalProventos - calcularINSS(totalProventos, salarioBase) < 2563.92)
            {
                return (totalProventos - calcularINSS(totalProventos, salarioBase)) * 0.075;

            }
            else if (totalProventos - calcularINSS(totalProventos, salarioBase) < 4271.60) 
            {
                return (totalProventos - calcularINSS(totalProventos, salarioBase)) * 0.225;

            }
            else
            {
                return (totalProventos - calcularINSS(totalProventos, salarioBase)) * 0.275;

            }

        }
        public double aliquotaIRRF(double totalProventos, double salarioBase)
        {
            if (totalProventos - calcularINSS(totalProventos, salarioBase) < 1710.79)
            {
                return 0;
            }
            else if (totalProventos - calcularINSS(totalProventos, salarioBase) < 2563.92)
            {
                return 0.075;

            }
            else if (totalProventos - calcularINSS(totalProventos, salarioBase) < 4271.60)
            {
                return 0.225;

            }
            else
            {
                return 0.275;

            }

        }
    }
}