using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class ProdutoPedido
    {
        public int Id { get; set; }
        public Produto Produto { get; set; }
        public int Quantidade { get; set; } = 1;


        protected ProdutoPedido()
        {

        }

        public ProdutoPedido(int id, Produto produto)
        {
            Id = id;
            Produto = produto;
        }
    }




}
