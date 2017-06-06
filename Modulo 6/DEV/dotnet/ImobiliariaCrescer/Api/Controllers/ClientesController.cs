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

            public IHttpActionResult Post(Cliente cliente)
            {
                repositorio.Criar(cliente);
                return Ok(new { dado = cliente });
            }

        
    }

}