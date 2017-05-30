using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using Demo1.Dominio.Entidades;
using Demo1.Infraestrutura.Repositorios;


namespace Demo1.WebAP1.Controllers
{
    public class PedidosController :ApiController
    {
        PedidoRepositorio _pedidoRepositorio = new PedidoRepositorio();


        public IHttpActionResult Post(Pedido pedido)
        {

            var mensagens = new List<string>();
            foreach (var item in pedido.Itens) { 
            if (!item.ValidarPedido(out mensagens))
            {
                return BadRequest(string.Join(".", mensagens.ToArray()));
            }
            }
            _pedidoRepositorio.Criar(pedido);
            return Ok(pedido);

        }

        public IHttpActionResult Get()
        {
            var pedidos = _pedidoRepositorio.Listar();
            return Ok(pedidos);
        }

        public IHttpActionResult Put(Pedido pedido)
        {
            var mensagens = new List<string>();
            foreach (var item in pedido.Itens)
            {
                if (!item.ValidarPedido(out mensagens))
                {
                    return BadRequest(string.Join(".", mensagens.ToArray()));
                }
            }
                _pedidoRepositorio.Alterar(pedido);

            return Ok(pedido);
        }

        public IHttpActionResult Get(int id)
        {
            return Ok(_pedidoRepositorio.Obter(id));
        }

        public IHttpActionResult Delete(int id)
        {
            _pedidoRepositorio.Excluir(id);

            return Ok();
        }
    }
}