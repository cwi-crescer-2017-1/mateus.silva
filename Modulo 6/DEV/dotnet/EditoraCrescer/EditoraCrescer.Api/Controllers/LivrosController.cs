using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraesturtura;
using EditoraCrescer.Infraesturtura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/livros")]
    public class LivrosController : ApiController
    {
        private RepositorioLivro repositorio = new RepositorioLivro();


        public IHttpActionResult Get()
        {
            var livros = repositorio.Obter();
            return Ok(new { dado = livros });
        }

        [Route("{isbn:int}")]
        public IHttpActionResult Get(int isbn)
        {
            var livro = repositorio.Obter(isbn);
            return Ok(new { dado = livro });
        }

        [HttpGet]
        [Route("lancamentos")]
        public IHttpActionResult GetLivroDosUltimos7Dias()
        {
            var livros = repositorio.obterLivrosDosUltimos7Dias();
            return Ok(new { dado = livros });
        }

        [Route("{isbn:int}")]
        public HttpResponseMessage Put(int isbn, Livro livro)
        {
            if (isbn!= livro.Isbn)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = new string[] { "Id não confere com livro passado" } });
            }
            if (!repositorio.verificaExistenciaDelivro(isbn))
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = new string[] { "Livro não existe" } });
            }
                repositorio.Alterar(isbn, livro);
            return Request.CreateResponse(HttpStatusCode.OK, new { dado = livro });
        }
    
        [Route("{genero}")]
        public IHttpActionResult Get(string genero)
        {
            var livro = repositorio.Obter(genero);
            return Ok(new { dado = livro });
        }


        public IHttpActionResult Post(Livro livro)
        {
            repositorio.Criar(livro);
            return Ok(new { dado = livro });
        }

         [Route("{isbn}")]
         public HttpResponseMessage Delete (int isbn)
         {
            if (!repositorio.verificaExistenciaDelivro(isbn))
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = new string[] { "Livro não existe" } });
            }
            repositorio.Remover(isbn);

            return Request.CreateResponse(HttpStatusCode.OK);
        }

        protected override void Dispose(bool disposing)
        {

            repositorio.Dispose();
            base.Dispose(disposing);
        }
    }
}
