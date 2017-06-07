using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using ImobiliariaCrescer.Dominio.Entidades;
using ImobiliariaCrescer.Infraestrutura.Repositorios;

namespace Api.Controllers
{
    [RoutePrefix("api/pedidos")]

    public class PedidosController : ApiController
    {
        private PedidoRepositorio repositorio = new PedidoRepositorio();

        public IHttpActionResult Get()
        {
            var pedidos = repositorio.Obter();
            return Ok(new { dado = pedidos});
        }

        public IHttpActionResult Post(Pedido pedido)
        {
            repositorio.FazerPedido(pedido);
            return Ok(new { dado = pedido});
        }


    }
}
