using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Usuario
    {
        public string Nome { get; set;}
        public string Email { get; set;}
        public string Senha { get; set;}
        public int Id {get; set;}
        
        public Usuario(string nome, string email, string senha)
        {
            Nome = nome;
            Email = email;
            Senha = senha;
        }
    }
}
