using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Pedido
    {
        public int Id { get;  private set;}
        public Cliente Cliente { get; private set;}
        public List<ProdutoPedido> Itens { get; private set;}
        public DateTime DataDoPedido { get; private set;}
        public decimal ValorTotal { get; private set;}
        public decimal? Multa { get;  private set;}
        public DateTime? DataDeEntrega {get;  private set;}
        public DateTime DataPrevistaDeEntrega {get; private  set;}


        public Pedido(int id, Cliente cliente, List<ProdutoPedido> itens, DateTime entrega)
        {
            Id = id;
            Cliente = cliente;
            Itens = itens;
            DataDoPedido = DateTime.Now;
            ValorTotal = itens.Sum(x => x.Produto.PrecoDaDiaria);
            DataPrevistaDeEntrega = entrega;

        }

        public Pedido( Cliente cliente, List<ProdutoPedido> itens, DateTime entrega)
        {
            Cliente = cliente;
            Itens = itens;
            DataDoPedido = DateTime.Now;
            ValorTotal = itens.Sum(x => x.Produto.PrecoDaDiaria);
            DataPrevistaDeEntrega = entrega;

        }

        protected Pedido()
        {

        }

        public void   SetDataDeEntrega()
        {
            DataDeEntrega= DateTime.Now;
        }



        public  void AplicaMulta()
        {
            var diferencaEmDias = (DataDeEntrega.Value - DataPrevistaDeEntrega).TotalDays;
            if (diferencaEmDias > 0)
            {
                Multa = ValorTotal * Convert.ToDecimal(diferencaEmDias);
                var novoValor = ValorTotal + Multa;
                ValorTotal = (decimal)novoValor;
            }
        }


    }
}
