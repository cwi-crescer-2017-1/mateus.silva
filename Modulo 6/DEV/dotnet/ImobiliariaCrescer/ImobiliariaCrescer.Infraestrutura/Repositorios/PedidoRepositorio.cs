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
            return contexto.Pedidos.Include(x=> x.Cliente).Include(x => x.Itens).ToList();
        }

        public void FazerPedido(Pedido pedido)
        {
            ProdutoRepositorio produtoRepositorio = new ProdutoRepositorio();

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
                    var saldo = produto.Quantidade - item.Produto.Quantidade;
                    produto.Quantidade = saldo;
                }

                produtoRepositorio.Alterar(produto.Id, produto);

            }
            contexto.SaveChanges();


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
