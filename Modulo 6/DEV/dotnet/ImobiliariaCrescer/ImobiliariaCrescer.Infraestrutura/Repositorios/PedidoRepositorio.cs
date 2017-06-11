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

        public void FazerPedido(Pedido pedido)
        {
            contexto.Entry(pedido.Cliente).State = EntityState.Unchanged;
            contexto.Pedidos.Add(pedido);
   
            foreach (var item in pedido.Itens)
            {
                contexto.Entry(item.Produto).State = EntityState.Unchanged;
            }
            RealizarBaixaEstoque(pedido);
            contexto.SaveChanges();
        }

        public void Alterar(int id, Pedido pedido)
        {
            pedido.SetDataDeEntrega();
            pedido.AplicaMulta();   
            contexto.Entry(pedido).State = System.Data.Entity.EntityState.Modified;
            Devolver(pedido);
            contexto.SaveChanges();
        }
        
        public dynamic RelatorioDeLocacaoMensal()
        {
            var pedidos = contexto.Pedidos.Include(x => x.Cliente).ToList();
            return pedidos.Where(x => (DateTime.Now - x.DataDoPedido).TotalDays < 31).ToList();
        }

        public dynamic RelatorioDeLocacaoMensalValorTotal()
        {
            var pedidos = contexto.Pedidos.Include(x => x.Cliente).ToList();
            var soma = pedidos.Where(x => (DateTime.Now - x.DataDoPedido).TotalDays < 31).ToList();
            return soma.Sum(x => x.ValorTotal);
        }

        public dynamic RelatorioDeAtrasos()
        {
            var pedidos = contexto.Pedidos.Include(x => x.Cliente).ToList();
             return pedidos.Where(x => (x.DataPrevistaDeEntrega - DateTime.Now).TotalDays < 0).OrderBy(x=> x.DataPrevistaDeEntrega).ToList();
          
        }


        private void RealizarBaixaEstoque(Pedido pedido)
        {
            ProdutoRepositorio produtoRepositorio = new ProdutoRepositorio();
            foreach (var item in pedido.Itens)
            {
                var produto = produtoRepositorio.ObterPorId(item.Produto.Id);
                if (produto.Quantidade > 0)
                {
                    produto.baixarEstoqueProduto();
                }
                produtoRepositorio.Alterar(produto.Id, produto);
                contexto.SaveChanges();
            }
        }

        private void Devolver(Pedido pedido)
        {
            ProdutoRepositorio produtoRepositorio = new ProdutoRepositorio();
            foreach (var item in pedido.Itens)
            {
                var produto = produtoRepositorio.ObterPorId(item.Produto.Id);
                if (produto.Quantidade > 0)
                {
                    produto.devolverProduto();
                }
                produtoRepositorio.Alterar(produto.Id, produto);
                contexto.SaveChanges();
            }
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

    }
}
