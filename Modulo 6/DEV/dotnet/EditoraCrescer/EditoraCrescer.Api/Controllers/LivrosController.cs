﻿using EditoraCrescer.Infraestrutura.Entidades;
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
    public class LivrosController : ApiController
    {
        private LivroRepositorio repositorio = new LivroRepositorio();

        public IHttpActionResult Get()
        {
            var livros = repositorio.Obter();
            return Ok(livros);
        }

        public IHttpActionResult Post(Livro livro)
        {
            repositorio.Criar(livro);
            return Ok();
        }

         public IHttpActionResult Delete (int id)
         {
            
           repositorio.Remover(id);
            return Ok();
        }
    }
}
