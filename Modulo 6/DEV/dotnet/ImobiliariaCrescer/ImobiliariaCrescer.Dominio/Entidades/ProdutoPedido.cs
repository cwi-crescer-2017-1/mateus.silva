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
        public Produto Produto { get; private set;}
        public int Quantidade { get; private set; }
    }
}
