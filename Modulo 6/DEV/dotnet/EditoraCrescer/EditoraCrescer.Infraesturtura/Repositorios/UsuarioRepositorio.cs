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

        public void Alterar(Usuario usuario)
        {
            _usuarios[usuario.Email] = usuario;
        }
        public void Excluir(Usuario usuario)
        {
            _usuarios[usuario.Email] = usuario;
        }

        public IEnumerable<Usuario> Listar()
        {
            return _usuarios.Select(u => u.Value);
        }

        public Usuario Obter(string email)
        {
            return _usuarios.Where(u => u.Key == email).Select(u => u.Value).FirstOrDefault();
        }
    }
}