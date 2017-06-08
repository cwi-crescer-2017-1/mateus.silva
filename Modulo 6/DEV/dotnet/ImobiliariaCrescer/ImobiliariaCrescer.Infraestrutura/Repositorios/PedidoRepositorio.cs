using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ImobiliariaCrescer.Dominio.Entidades;
using System.Data.Entity;

namespace ImobiliariaCrescer.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public dynamic Obter()
        {
           
            return contexto.Pedidos.Include(x=> x.Cliente).Include(x => x.Itens.Select(y => y.Produto)).Where(x=> x.DataDeEntrega == null).ToList();
        }

        public void FazerPedido(Pedido p)
        {
            ProdutoRepositorio produtoRepositorio = new ProdutoRepositorio();
            Pedido pedido = new Pedido(p.Cliente, p.Itens, p.DataPrevistaDeEntrega);
            contexto.Entry(pedido.Cliente).State = EntityState.Unchanged;
            contexto.Pedidos.Add(pedido);
           
            foreach (var item in pedido.Itens)
            {
                contexto.Entry(item.Produto).State = EntityState.Unchanged;
            }

            foreach (var item in pedido.Itens)
            {
                var produto = produtoRepositorio.ObterPorId(item.Produto.Id);
                if (produto.Quantidade > 0)
                {
                    var saldo = produto.Quantidade - 1;
                    produto.Quantidade = saldo;
                }

                produtoRepositorio.Alterar(produto.Id, produto);
                contexto.SaveChanges();
            }

        }

        public void Alterar(int id, Pedido pedido)
        {
            ProdutoRepositorio produtoRepositorio = new ProdutoRepositorio();

            pedido.DataDeEntrega = DateTime.Now;

            var diferencaEmDias = (pedido.DataDeEntrega.Value - pedido.DataPrevistaDeEntrega).TotalDays;

            if (diferencaEmDias > 0)
            {
                pedido.Multa = pedido.ValorTotal * Convert.ToDecimal(diferencaEmDias);
            }
            contexto.Entry(pedido).State = System.Data.Entity.EntityState.Modified;

            
            foreach (var item in pedido.Itens)
            {
                var produto = produtoRepositorio.ObterPorId(item.Produto.Id);
                if (produto.Quantidade > 0)
                {
                    var saldo = produto.Quantidade + 1;
                    produto.Quantidade = saldo;
                }

                produtoRepositorio.Alterar(produto.Id, produto);
                contexto.SaveChanges();
            }
            contexto.SaveChanges();
        }


        
        public dynamic RelatorioDeLocacaoMensal()
        {
            var pedidos = contexto.Pedidos.ToList();
            return pedidos.Where(x => (DateTime.Now - x.DataDoPedido).TotalDays < 31).ToList();
        }

        public dynamic RelatorioDeAtrasos()
        {
            var pedidos = contexto.Pedidos.ToList();
            return pedidos.Where(x => (x.DataDeEntrega.Value - x.DataDoPedido).TotalDays > 0).ToList();
        }
         
        private void RealizarBaixaEstoque()
        {

        }

        public void Dispose()
        {
            contexto.Dispose();
        }

    }
}
