using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;

namespace EditoraCrescer.Api.Controllers
{
    [RoutePrefix("api/autores")]
    public class AutoresController : ApiController
    {

        private RepositorioAutor repositorio = new RepositorioAutor();

        public IHttpActionResult Get()
        {
            var autores = repositorio.Obter();
            return Ok(new { dado = autores });
        }

        [Route("{id:int}")]
           
        public IHttpActionResult Get(int id)
        {
            var autores = repositorio.Obter(id);
            return Ok(new { dado = autores });
        }

        [HttpGet]
        [Route("{id}/livros")]
        public IHttpActionResult GetLivrosDoAutor(int id)
        {
            var livros = repositorio.ObterLivrosDoAutor(id);
            return Ok(new { dado = livros });
        }

        [Route("{id:int}")]
        public IHttpActionResult Put(int id, Autor autor)
        {
            repositorio.Alterar(id, autor);
            return Ok(new { dado = autor });
        }

        public IHttpActionResult Post(Autor autor)
        {
            repositorio.Criar(autor);
            return Ok(new { dado = autor });
        }
        [Route("{id:int}")]
        public IHttpActionResult Delete(int id)
        {
            repositorio.Remover(id);
            return Ok();
        }

    }
}
