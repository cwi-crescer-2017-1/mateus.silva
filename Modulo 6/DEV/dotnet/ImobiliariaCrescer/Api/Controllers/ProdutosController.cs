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
    [RoutePrefix("api/produtos")]
    public class ProdutosController : ApiController
    {
        private ProdutoRepositorio repositorio = new ProdutoRepositorio();


        public IHttpActionResult Get()
        {
            var produtos = repositorio.Obter();
            return Ok(new { dado = produtos });
        }

        [HttpGet]
        [Route("pacotes")]
        public IHttpActionResult GetPacotes()
        {
            var pacotes = repositorio.ObterPacotes();
            return Ok(new { dado = pacotes });
        }
        [HttpGet]
        [Route("opcionais")]
        public IHttpActionResult GetOpcionais()
        {
            var opcionais = repositorio.ObterOpcionais();
            return Ok(new { dado = opcionais});
        }

        [Route("{id:int}")]
        public IHttpActionResult Get(int id)
        {
            var produto = repositorio.ObterPorId(id);
            return Ok(new { dado = produto });
        }


        [Route("{id:int}")]
        public HttpResponseMessage Put(int id, Produto produto)
        {
            if (id != produto.Id)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = new string[] { "Id não confere com produto passado" } });
            }
            //if (!repositorio.verificaExistenciaDeProduto(id))
            //{
            //    return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = new string[] { "Produto não existe" } });
            //}
            repositorio.Alterar(id, produto);
            return Request.CreateResponse(HttpStatusCode.OK, new { dado = produto });
        }

        public IHttpActionResult Post(Produto produto)
        {
            repositorio.CriarProduto(produto);
            return Ok(new { dado = produto });
        }

        [Route("{id}")]
        public HttpResponseMessage Delete(int id)
        {
            //if (!repositorio.verificaExistenciaDelivro(isbn))
            //{
            //    return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = new string[] { "Livro não existe" } });
            //}
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