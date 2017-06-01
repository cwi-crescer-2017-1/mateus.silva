using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
using System.Globalization;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
   public  class RepositorioLivro : IDisposable
    {

    
         private Contexto contexto = new Contexto();

         public dynamic Obter()
         {
            return contexto.Livros.Select
                (l => new { l.Isbn, l.Titulo, l.Capa, l.Autor.Nome, l.Genero}).
                ToList();
         }
    
        public Livro Obter(int isbn)
        {
            return contexto.Livros.FirstOrDefault(a => (a.Isbn == isbn));
        }

        public dynamic Obter(string genero)
        {
            var livro = contexto.Livros.Select(l => new { l.Isbn, l.Titulo, l.Capa, l.Autor.Nome, l.Genero })
           .FirstOrDefault(a => a.Genero.Contains(genero));
            return livro;

        }

        public dynamic obterLivrosDaSemana()
        
        {
            // ; ;  DateTime.Now.Day
            //Livro y = contexto.Livros.FirstOrDefault(a => a.Genero.Contains("aventura"));
            //var b = y.DataPublicacao.Day - DateTime.Now.Day;
            //  if (y.DataPublicacao.Day < DateTime.Now.Day)
            //  {
            //   var a = 2 + 1;
            // }

              return contexto.Livros.Where(l => DateTime.Now.Day - l.DataPublicacao.Day == 27);
     //Select(l => new { l.Isbn, l.Titulo, l.Capa, l.Autor.Nome, l.Genero }).ToList();
          
        }

        public void Criar(Livro livro)
         {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
         }

         public void Remover(int isbn)
         {
            var livro = contexto.Livros.FirstOrDefault(a => (a.Isbn == isbn));
            contexto.Livros.Remove(livro);
            contexto.SaveChanges();
        }

        public  void Alterar(int isbn, Livro livro)
        {
            var livroBuscado = contexto.Livros.FirstOrDefault(a => (a.Isbn == isbn));
            if (isbn == livro.Isbn && livroBuscado!=null)
            {
                contexto.Entry(livroBuscado).CurrentValues.SetValues(livro);
                contexto.SaveChanges();
            }
        }  

         public void Dispose()
         {    
            contexto.Dispose();
         }
    }
}
