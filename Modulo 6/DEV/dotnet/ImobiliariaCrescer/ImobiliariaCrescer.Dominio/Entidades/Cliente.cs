using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Cliente
    {
        public int Id { get; private set;}
        public string Nome { get;  private set;}
        public string Cpf { get; private set;}
        public string Rg { get;  private set;}
        public int Telefone { get; private set;}
        public string Endereco { get;  private set;}
        public char Genero { get;  private set;}
        public DateTime DataDeNascimento { get; private set;}

       protected Cliente()
        {
                
        }
        public Cliente( int id, string nome, string cpf, string rg, string endereco, char genero, DateTime nascimento)
        {
            Id = id;
            Nome = nome;
            Cpf = cpf;
            Rg = rg;
            Endereco = endereco;
            Genero = genero;
            DataDeNascimento = nascimento;
         }



    
    }
}