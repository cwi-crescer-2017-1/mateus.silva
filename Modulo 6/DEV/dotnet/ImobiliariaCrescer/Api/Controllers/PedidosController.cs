using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Api.App_Start;
using Api.Models;
using ImobiliariaCrescer.Dominio.Entidades;
using ImobiliariaCrescer.Infraestrutura.Repositorios;

namespace Api.Controllers
{
    [RoutePrefix("api/pedidos")]

    public class PedidosController : ApiController
    {
        private PedidoRepositorio repositorio = new PedidoRepositorio();

        [BasicAuthorization]
        public IHttpActionResult Get()
        {
            var pedidos = repositorio.Obter();
            return Ok(new { dado = pedidos});
        }

        [BasicAuthorization]
        public IHttpActionResult Post(PedidoModel pedidoModel)
        {
            Pedido pedido = new Pedido( pedidoModel.Cliente, pedidoModel.Itens, pedidoModel.DataPrevistaDeEntrega);
            repositorio.FazerPedido(pedido);
            return Ok(new { dado = pedido});
        }

        [BasicAuthorization]
        [Route("{id:int}")]
        public HttpResponseMessage Put(int id, PedidoModel pedidoModel)
        {
            Pedido pedido = new Pedido(pedidoModel.Id, pedidoModel.Cliente, pedidoModel.Itens, pedidoModel.DataPrevistaDeEntrega);
            if (id != pedido.Id)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = new string[] { "Id não confere com produto passado" } });
            }           
            repositorio.Alterar(id,pedido);
            return Request.CreateResponse(HttpStatusCode.OK, new { dado = pedido });
        }

        [BasicAuthorization]
        [HttpGet]
        [Route ("relatoriodelocacaomensal")]
        public IHttpActionResult GetRelatorioDeLocacaoMensal()
        {
            var relatorio = repositorio.RelatorioDeLocacaoMensal();
            return Ok (new { dado = relatorio });
        }

        [BasicAuthorization]
        [HttpGet]
        [Route("relatoriodelocacaomensalvalor")]
        public IHttpActionResult GetRelatorioDeLocacaoMensalValor()
        {
            var relatorio = repositorio.RelatorioDeLocacaoMensalValorTotal();
            return Ok(new { dado = relatorio });
        }

        [BasicAuthorization]
        [HttpGet]
        [Route("relatoriodeatrasos")]
        public IHttpActionResult GetRelatorioDeAtrasos()
        {
            var relatorioDeAtrasos = repositorio.RelatorioDeAtrasos();
            return Ok(new { dado = relatorioDeAtrasos });
        }

    }
}
