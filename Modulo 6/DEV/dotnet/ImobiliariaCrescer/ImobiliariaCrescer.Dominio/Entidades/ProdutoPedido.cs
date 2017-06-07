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
        public int Quantidade { get; set; }


        public ProdutoPedido(Produto produto)
        {
            Produto = produto;
            Quantidade = produto.Quantidade;
        }
    }




}
