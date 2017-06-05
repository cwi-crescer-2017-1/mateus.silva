using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public int Cpf { get; set; }
        public string Rg { get; set; }
        public int Telefone { get; set; }
        public string Endereco { get; set;}
        public char Genero { get; set; }
        public DateTime DataDeNascimento { get; set;}
    }
}