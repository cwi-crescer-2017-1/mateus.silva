using Api.App_Start;
using Api.Models;
using ImobiliariaCrescer.Dominio.Entidades;
using ImobiliariaCrescer.Infraestrutura.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading;
using System.Web.Http;

namespace Api.Controllers
{
    // Permite usuário não autenticados acessarem a controller
        [AllowAnonymous]
        [RoutePrefix("api/acessos")]
        public class UsuarioController : ControllerBasica
        {
            readonly UsuarioRepositorio _usuarioRepositorio;

            public UsuarioController()
            {
                _usuarioRepositorio = new UsuarioRepositorio();
            }

        [BasicAuthorization]
        [HttpPost, Route("registrar")]
        public HttpResponseMessage Registrar([FromBody]RegistrarUsuarioModel model)
        {
            if (_usuarioRepositorio.Obter(model.Email) == null)
            {
                var usuario = new Usuario(model.Nome, model.Email, model.Senha);

                if (usuario.Validar())
                {
                    _usuarioRepositorio.Criar(usuario);
                }
                else
                {
                    return ResponderErro(usuario.Mensagens);
                }
            }
            else
            {
                return ResponderErro("Usuário já existe.");
            }

            return ResponderOK();
        }

        // Exige que o usuário se autentique
        [BasicAuthorization]
            [HttpGet, Route("usuario")]
            public HttpResponseMessage Obter()
            {
                // só pode obter as informações do usuário corrente (logado, autenticado)
                var usuario = _usuarioRepositorio.Obter(Thread.CurrentPrincipal.Identity.Name);

                if (usuario == null)
                    return ResponderErro("Usuário não encontrado.");

                return ResponderOK(new { usuario.Nome, usuario.Permissoes, usuario.Email });
            }
        }
    }
