using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using EditoraCrescer.Infraesturtura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;

namespace EditoraCrescer.Api.Controllers
{
    public class RevisoresController : ApiController
    {
        private RepositorioRevisor  repositorio = new RepositorioRevisor();

        public IHttpActionResult Get()
        {
           var revisor =  repositorio.Obter();
           return Ok(revisor);

        }
        public IHttpActionResult Post(Revisor revisor)
        {
            repositorio.Criar(revisor);
            return Ok(revisor);

        }
        public IHttpActionResult Delete(int id)
        {
            repositorio.Remover(id);
            return Ok();
        }
    }
}
