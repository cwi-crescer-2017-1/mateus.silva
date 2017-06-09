using ImobiliariaCrescer.Dominio.Entidades;
using ImobiliariaCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using Api.Models;

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

        public HttpResponseMessage Post(ClienteModel model)
       {
          var cliente = new Cliente (model.Id, model.Nome, model.Cpf, model.Rg, model.Endereco, model.Genero, model.DataDeNascimento);
          ClienteRepositorio clienter = new ClienteRepositorio();
          if(clienter.VerificarCpf(cliente.Cpf))
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensagem = new string[] { "CPF já está sendo usado" } });
            }
          repositorio.Criar(cliente);
            
          return Request.CreateResponse(HttpStatusCode.OK, new { dado = cliente });
        }

        protected override void Dispose(bool disposing)
        {
            repositorio.Dispose();
            base.Dispose(disposing);
        }

    }

}