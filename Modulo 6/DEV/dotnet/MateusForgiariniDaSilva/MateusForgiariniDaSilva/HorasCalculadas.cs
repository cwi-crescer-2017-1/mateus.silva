using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MateusForgiariniDaSilva
{
	public class HorasCalculadas
	{
		public double QtdHoras { get; private set; }

		public double ValorTotalHoras { get; private set; }

		public HorasCalculadas(double qtdHoras, double valorTotalHoras)
		{
			QtdHoras = qtdHoras;
			ValorTotalHoras = valorTotalHoras;
		}
        public HorasCalculadas(double qtdHoras)
        {
            QtdHoras = qtdHoras;
        }



    }
}