using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
using System.Globalization;
using System.Collections;

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

        public dynamic obterLivrosDosUltimos7Dias()
        
        {

            return contexto.Livros.ToList().Where(l =>
            {
                if (l.DataPublicacao.Month == DateTime.Now.Month && DateTime.Now.Year == l.DataPublicacao.Year)
                {
                    return DateTime.Now.Day - l.DataPublicacao.Day <= 7;
                }
                else if ((DateTime.Now.Month - l.DataPublicacao.Month == 1) && DateTime.Now.Year == l.DataPublicacao.Year)
                {
                    if (l.DataPublicacao.Day > 7)
                    {
                        return Math.Abs(l.DataPublicacao.Day - DateTime.Now.Day - l.DataPublicacao.Day) <= 7;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }

            }).Select
                (x => new { x.Isbn, x.Titulo, x.Capa,  x.Genero });      

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
