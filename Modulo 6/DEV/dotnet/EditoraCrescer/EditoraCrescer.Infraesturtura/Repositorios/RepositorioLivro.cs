using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
   public  class RepositorioLivro : IDisposable
    {

    
         private Contexto contexto = new Contexto();

         public dynamic Obter()
         {
            return contexto.Livros.Select
                (x => new { x.Isbn, x.Titulo, x.Capa, x.Autor.Nome, x.Genero}).
                ToList();
         }
    
        public Livro Obter(int isbn)
        {
            return contexto.Livros.FirstOrDefault(a => (a.Isbn == isbn));
        }

        public Livro Obter(string genero)
        {
            return contexto.Livros.FirstOrDefault(a => a.Genero.Contains(genero));
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

        public  void Alterar   (int isbn, Livro livro)
        {
            ////if (isbn!=livro.Isbn)
            ////{
            ////    return; };

             var livroBuscado = contexto.Livros.FirstOrDefault(a => (a.Isbn == isbn));
             livroBuscado = livro;
             contexto.Entry(livroBuscado).State = System.Data.Entity.EntityState.Modified;
             contexto.SaveChanges();
        }  

         public void Dispose()
         {    
            contexto.Dispose();
         }
    }
}
