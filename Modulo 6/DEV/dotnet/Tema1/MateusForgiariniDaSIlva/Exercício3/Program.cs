using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercício3
{
    class Program
    {
        static void Main(string[] args)
        {
            FolhaPagamento oi = new FolhaPagamento();
            var demonstrativo = oi.GerarDemonstrativo(200, 5000.334, 50, 10);
            Console.WriteLine(demonstrativo.SalarioBase);

            Desconto Desconto = new Desconto(0.275, 2133.00);
            Console.WriteLine(Desconto.Aliquota);
            Console.ReadKey();
        }
    }
}