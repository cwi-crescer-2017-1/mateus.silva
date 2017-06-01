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
    [RoutePrefix("api/revisores")]
    public class RevisoresController : ApiController
    {
        
        private RepositorioRevisor  repositorio = new RepositorioRevisor();

        public IHttpActionResult Get()
        {
           var revisores =  repositorio.Obter();
           return Ok(new { dado = revisores });
        }
        [Route("{id}")]
        public IHttpActionResult Get(int id)
        {
            var revisor = repositorio.Obter(id);
            return Ok(new { dado = revisor });
        }
        public IHttpActionResult Post(Revisor revisor)
        {
            repositorio.Criar(revisor);
            return Ok(new { dado = revisor });

        }
        [Route("{id}")]
        public HttpResponseMessage Delete(int id)
        {
            if (!repositorio.verificaExistenciaDeRevisor(id))
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = new string[] { "Revisor não existe" } });
            }
            repositorio.Remover(id);
           return Request.CreateResponse(HttpStatusCode.OK);
        }
        [Route("{id}")]
        public HttpResponseMessage Put (int id, Revisor revisor)
        {

            if (id != revisor.Id)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = new string[] { "Id não confere com revisor passado" } });
            }
            if (!repositorio.verificaExistenciaDeRevisor(id))
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = new string[] { "Revisor não existe" } });
            }
            
            repositorio.Alterar(id, revisor);
            return Request.CreateResponse(HttpStatusCode.OK, new { dado = revisor });

        }
    }
}
