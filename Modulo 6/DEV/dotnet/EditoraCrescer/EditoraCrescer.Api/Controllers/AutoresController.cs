﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraesturtura.Repositorios;

namespace EditoraCrescer.Api.Controllers
{
    public class AutoresController : ApiController
    {

        private  RepositorioAutor repositorio = new RepositorioAutor();

        public IHttpActionResult Get()
        {
            var autores = repositorio.Obter();
            return Ok(autores);
        }

        public IHttpActionResult Post(Autor autor)
        {
            repositorio.Criar(autor);
            return Ok(autor);

        }

        public IHttpActionResult Delete(int id)
        {
            repositorio.Remover(id);
            return Ok();

        }

    }
}
