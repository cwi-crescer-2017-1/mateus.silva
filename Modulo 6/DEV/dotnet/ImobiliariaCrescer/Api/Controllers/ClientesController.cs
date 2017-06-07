using ImobiliariaCrescer.Dominio.Entidades;
using ImobiliariaCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Api.Controllers
{
    [RoutePrefix("api/clientes")]
    public class ClientesController : ApiController
    {

        private ClienteRepositorio repositorio = new ClienteRepositorio();


        public IHttpActionResult Get()
        {
            var clientes = repositorio.Obter();
            return Ok(new { dado = clientes });
        }

       [Route("{id}")]
       public IHttpActionResult Get(int id)
       {
            var cliente = repositorio.ObterPorID(id);
            return Ok(new {dado = cliente});
       }

        public IHttpActionResult Post(Cliente cliente)
       {
          repositorio.Criar(cliente);
          return Ok(new { dado = cliente });
       }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }

    }

}