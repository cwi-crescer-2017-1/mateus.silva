using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exercício3
{
    public class HorasCalculadas
    {
        public double QtdHoras { get; private set; }

        public double ValorTotalHoras { get; private set; }

        public HorasCalculadas(double qtdHoras, double valorTotalHoras)
        {
            QtdHoras = qtdHoras;
            ValorTotalHoras = Math.Truncate(valorTotalHoras* 100) / 100;
        }
    


    }
}