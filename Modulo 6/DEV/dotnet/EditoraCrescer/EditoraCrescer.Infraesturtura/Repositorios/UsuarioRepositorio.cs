using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraesturtura.Entidades;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class UsuarioRepositorio
    {
        Contexto contexto = new Contexto();
        static readonly Dictionary<string, Usuario> _usuarios = new Dictionary<string, Usuario>();

        static UsuarioRepositorio()
        {    
            var usrAdmin = new Usuario("admin", "admin@cwi.com.br", "123456");
            usrAdmin.AtribuirPermissoes("Administrador");
            _usuarios.Add(usrAdmin.Email, usrAdmin);
            var revisor  = new Usuario("revisor", "revisor@cwi.com.br", "123456");
            revisor.AtribuirPermissoes("Revisor");
            _usuarios.Add(revisor.Email, revisor);
            var publicador = new Usuario("publicador", "publicador@cwi.com.br", "123456");
            publicador.AtribuirPermissoes("Publicador");
            _usuarios.Add(publicador.Email, publicador);
        }

        public UsuarioRepositorio()
        {

        }

        public void Criar(Usuario usuario)
        {
            _usuarios.Add(usuario.Email, usuario);
            contexto.Usuario.Add( usuario);
            contexto.SaveChanges();


        }

       
        public Usuario Obter(string email)
        {
            return _usuarios.Where(u => u.Key == email).Select(u => u.Value).FirstOrDefault();
        }
    }
}