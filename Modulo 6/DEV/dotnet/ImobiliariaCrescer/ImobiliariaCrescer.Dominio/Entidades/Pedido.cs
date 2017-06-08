using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get;  set; }
        public Cliente Cliente { get;  set; }
        public List<ProdutoPedido> Itens { get; set;}
        public DateTime DataDoPedido { get; set; }
        public decimal ValorTotal { get;set; }
        public decimal? Multa { get;  set; }
        public DateTime DataDeEntrega {get;  set;}
        public DateTime DataPrevistaDeEntrega {get;  set;}


        public Pedido(Cliente cliente, List<ProdutoPedido> itens, DateTime entrega)
        {
            Cliente = cliente;
            Itens = itens;
            DataDoPedido = DateTime.Now;
            ValorTotal = itens.Sum(x => x.Quantidade * x.Produto.PrecoDaDiaria);
            Multa = 0;
            DataDeEntrega = DateTime.Now;
            DataPrevistaDeEntrega = entrega;

        }

        public Pedido()
        {

        }

        public DateTime SetDataDoPedido()
        {
            return DateTime.Now;
        }
    }
}
