using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; private set; }
        public Cliente Cliente { get; private set; }
        public List<ProdutoPedido> Itens { get; private set;}
        public DateTime DataDoPedido { get; private set; }
        public decimal ValorTotal { get; private set; }
        public decimal? Multa { get; private set; }
        public DateTime DataDeEntrega {get; private set;}
        public DateTime DataPrevistaDeEntrega {get; private set;}
    }
}
