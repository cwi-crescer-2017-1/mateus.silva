using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ImobiliariaCrescer.Dominio.Entidades;

namespace ImobiliariaCrescer.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public dynamic Obter()
        {
            return contexto.Pedidos.ToList();
        }

        public void FazerPedido(Pedido pedido)
        {
            contexto.Pedidos.Add(pedido);
            contexto.SaveChanges();
        }

        public void Dispose()
        {
            contexto.Dispose();
        }

    }
}
