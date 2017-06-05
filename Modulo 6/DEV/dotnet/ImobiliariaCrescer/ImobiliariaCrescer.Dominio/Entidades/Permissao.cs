using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Permissao
    {
        public string Nome { get; private set; }
        public int Id { get; private set; }

        public Permissao(string nome)
        {
            Nome = nome;
        }
    }
}
