using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ImobiliariaCrescer.Dominio.Entidades;

namespace Api.Models
{
    public class PedidoModel
    {
        public int Id { get;  set; }
        public Cliente Cliente { get;  set; }
        public List<ProdutoPedido> Itens { get;  set; }
        public DateTime DataDoPedido { get;  set; }
        public decimal ValorTotal { get; set; }
        public decimal? Multa { get;  set; }
        public DateTime? DataDeEntrega { get; set; }
        public DateTime DataPrevistaDeEntrega { get;  set; }
    }
}