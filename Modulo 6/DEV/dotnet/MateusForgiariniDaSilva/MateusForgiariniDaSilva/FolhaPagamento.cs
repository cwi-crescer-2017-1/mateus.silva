using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MateusForgiariniDaSilva
{
    public class FolhaPagamento : IFolhaPagamento
    {

        public Demonstrativo GerarDemonstrativo(int horasCategoria, double salarioBase, double horasExtras, double horasDescontadas)

        {
            double parse = horasCategoria;
            var ValorHora = salarioBase / horasCategoria;
            var totalHorasExtras = horasExtras * ValorHora;
            var totalHotasDescontadas = horasDescontadas * ValorHora;
            var horaExtra = new HorasCalculadas(horasExtras, totalHorasExtras);
            var horaDescontada = new HorasCalculadas(horasDescontadas, totalHotasDescontadas);
            var totalProventos = salarioBase + totalHotasDescontadas + totalHorasExtras;
            var inss = new Desconto(aliquotaINSS(salarioBase), calcularINSS(salarioBase));
            var irrf = new Desconto(aliquotaIRRF(salarioBase), calcularIRRF(salarioBase, totalProventos));
            var totalDescontos = calcularIRRF(salarioBase, totalProventos) + calcularINSS(salarioBase);
            var totalLiquido = totalProventos - totalDescontos;
            var inns = new Desconto(11 / 100, totalProventos * 11 / 100);


            return   new Demonstrativo (salarioBase, parse,  horaExtra, horaDescontada, totalProventos, inss, irrf, totalDescontos,
                totalLiquido, inss);

        }

        public double calcularINSS(double salarioBase)
        {
            if (salarioBase < 1000)
            {
                return salarioBase * 8 / 100;
            }
            else if (salarioBase < 1500)
            {
                return salarioBase * 9 / 100;
            }
            else
            {
                return salarioBase * 10 / 100;
            }
        }
        public double aliquotaINSS(double salarioBase)
        {
            if (salarioBase < 1000)
            {
                return 8 / 100;
            }
            else if (salarioBase < 1500)
            {
                return 9 / 100;
            }
            else
            {
                return 10 / 100;
            }
        }

        public double calcularIRRF(double salarioBase, double totalProventos)
        {
            if (salarioBase < 1710.78)
            {
                return 0;
            }
            else if (salarioBase < 2563.91)
            {
                return totalProventos - calcularINSS(salarioBase) * 7.5 / 100;

            }
            else if (salarioBase < 4271.59)
            {
                return totalProventos - calcularINSS(salarioBase) * 22.5 / 100;

            }
            else
            {
                return totalProventos - calcularINSS(salarioBase) * 27.5 / 100;

            }

        }
        public double aliquotaIRRF(double salarioBase)
        {
            if (salarioBase < 1710.78)
            {
                return 0;
            }
            else if (salarioBase < 2563.91)
            {
                return 7.5 / 100;

            }
            else if (salarioBase < 4271.59)
            {
                return 22.5 / 100;

            }
            else
            {
                return 27.5 / 100;

            }

        }
    }
}