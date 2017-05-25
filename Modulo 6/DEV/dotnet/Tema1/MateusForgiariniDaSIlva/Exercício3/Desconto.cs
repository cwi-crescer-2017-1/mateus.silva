using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercício3
{
    public class Desconto
    {
        public Desconto(double aliquota, double valor)
        {
            Valor = Math.Truncate(valor * 100) / 100;
            Aliquota = aliquota;
        }
        public double Aliquota { get; private set; }
        public double Valor { get; private set; }
    }
}
