using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get; set; }
        public int IdCliente { get; set; }
        public List<Produto> itens { get; set; }
        public DateTime DataDoPedido { get; set; }
        public decimal ValorTotal { get; set; }
        public decimal Multa { get; set; }
        public DateTime DataDeEntrega {get; set;}
        public DateTime DataDeVencimento {get; set;}
    }
}
