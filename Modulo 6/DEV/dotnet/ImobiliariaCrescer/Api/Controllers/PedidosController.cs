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

        [Route("{id:int}")]
        public HttpResponseMessage Put(int id, Pedido pedido)
        {
            if (id != pedido.Id)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = new string[] { "Id não confere com produto passado" } });
            }           
            repositorio.Alterar(id,pedido);
            return Request.CreateResponse(HttpStatusCode.OK, new { dado = pedido });
        }
      
        [HttpGet]
        [Route ("relatoriodelocacaomensal")]
        public IHttpActionResult GetRelatorioDeLocacaoMensal()
        {
            var relatorio = repositorio.RelatorioDeLocacaoMensal();
            return Ok (new { dado = relatorio });
        }

        [HttpGet]
        [Route("RelatorioDeAtrasos")]
        public IHttpActionResult GetRelatorioDeAtrasos()
        {
            var relatorioDeAtrasos = repositorio.RelatorioDeAtrasos();
            return Ok(new { dado = relatorioDeAtrasos });
        }

    }
}
