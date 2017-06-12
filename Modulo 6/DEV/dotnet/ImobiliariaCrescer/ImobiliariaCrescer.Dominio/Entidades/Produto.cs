using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Produto
    {
        public int  Id { get;  private set; }
        public string Nome { get; private  set; }
        public string Tipo { get; private set; }
        public int Quantidade { get; private set; }
        public decimal PrecoDaDiaria { get; private set;}

        protected  Produto()
        {

        }

        public Produto (int id, string nome, string tipo, int quantidade, decimal precoDaDiaria)
        {
            Id = id;
            Nome = nome;
            Tipo = tipo;
            Quantidade = quantidade;
            PrecoDaDiaria = precoDaDiaria;
        }

        public void baixarEstoqueProduto()
        {
            if (Quantidade == 0)
            {
                return;
            }
            Quantidade--;
        }

        public void devolverProduto()
        {
            Quantidade++;
        }

    }

}
