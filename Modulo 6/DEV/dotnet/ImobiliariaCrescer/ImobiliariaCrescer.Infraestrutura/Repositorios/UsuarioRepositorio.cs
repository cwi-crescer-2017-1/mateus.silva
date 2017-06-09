using ImobiliariaCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Repositorios
{
    public class UsuarioRepositorio
    {

        Contexto contexto = new Contexto();
        static readonly Dictionary<string, Usuario> _usuarios = new Dictionary<string, Usuario>();

        static UsuarioRepositorio()
        {

            var colaborador = new Usuario("Colaborador", "colaborador@cwi.com.br", "123456");
            colaborador.AtribuirPermissoes("Colaborador");
            _usuarios.Add(colaborador.Email, colaborador);

            var gerente = new Usuario("Gerente", "gerente@cwi.com.br", "123456");
            gerente.AtribuirPermissoes("Gerente");
            _usuarios.Add(gerente.Email, gerente);
        }

        public UsuarioRepositorio()
        {

        }
        //public void Criar(Usuario usuario)
        //{
        //    _usuarios.Add(usuario.Email, usuario);
        //    contexto.Usuario.Add(usuario);
        //    contexto.SaveChanges();
        //}


        public Usuario Obter(string email)
        {
            return _usuarios.Where(u => u.Key == email).Select(u => u.Value).FirstOrDefault();
        }
    }
}