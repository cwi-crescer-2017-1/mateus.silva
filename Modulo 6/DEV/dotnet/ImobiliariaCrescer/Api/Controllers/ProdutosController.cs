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
    [RoutePrefix("api/produtos")]
    public class ProdutosController : ApiController
    {
        private ProdutoRepositorio repositorio = new ProdutoRepositorio();

        [BasicAuthorization]
        public IHttpActionResult Get()
        {
            var produtos = repositorio.Obter();
            return Ok(new { dado = produtos });
        }

        [BasicAuthorization]
        [HttpGet]
        [Route("pacotes")]
        public IHttpActionResult GetPacotes()
        {
            var pacotes = repositorio.ObterPacotes();
            return Ok(new { dado = pacotes });
        }

        [BasicAuthorization]
        [HttpGet]
        [Route("opcionais")]
        public IHttpActionResult GetOpcionais()
        {
            var opcionais = repositorio.ObterOpcionais();
            return Ok(new { dado = opcionais});
        }

        [BasicAuthorization]
        [Route("{id:int}")]
        public IHttpActionResult Get(int id)
        {
            var produto = repositorio.ObterPorId(id);
            return Ok(new { dado = produto });
        }

        [BasicAuthorization]
        [Route("{id:int}")]
        public HttpResponseMessage Put(int id, ProdutoModel produtoModel)
        {
            var produto = new Produto(produtoModel.Id, produtoModel.Nome, produtoModel.Tipo, produtoModel.Quantidade, produtoModel.PrecoDaDiaria);

            if (id != produto.Id)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = new string[] { "Id não confere com produto passado" } });
            }
            repositorio.Alterar(id, produto);
            return Request.CreateResponse(HttpStatusCode.OK, new { dado = produto });
        }

        [BasicAuthorization]
        public IHttpActionResult Post(ProdutoModel produtoModel)
        {
            var produto = new Produto(produtoModel.Id, produtoModel.Nome, produtoModel.Tipo, produtoModel.Quantidade, produtoModel.PrecoDaDiaria);
            repositorio.CriarProduto(produto);
            return Ok(new { dado = produto });
        }

        [BasicAuthorization]
        [Route("{id}")]
        public HttpResponseMessage Delete(int id)
        {
            repositorio.Remover(id);
            return Request.CreateResponse(HttpStatusCode.OK);
        }

    

        protected override void Dispose(bool disposing)
        {

            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}