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

        [Route("{isbn:int}")]
        public IHttpActionResult Put(int isbn, Livro livro)
        {
                repositorio.Alterar(isbn, livro);
                return Ok(new { dado = livro }); 
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
         public IHttpActionResult Delete (int isbn)
         {
           repositorio.Remover(isbn);
            return Ok();
        }

         
    }
}
