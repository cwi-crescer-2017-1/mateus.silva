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
            return contexto.Livros.Include(x => x.Autor).FirstOrDefault(a => (a.Isbn == isbn));
           
        }

        public dynamic Obter(string genero)
        {
            var livro = contexto.Livros.Select(l => new { l.Isbn, l.Titulo, l.Capa, l.Autor.Nome, l.Genero })
           .FirstOrDefault(a => a.Genero.Contains(genero));
            return livro;

        }

        public dynamic obterLivrosDosUltimos7Dias()
        
        {
            var data = DateTime.Now.AddDays(-7);
            return contexto.Livros.Where (l=> l.DataPublicacao >= data)
            .Select
            (x => new { x.Isbn, x.Titulo, x.Capa, x.Autor.Nome, x.Genero }).ToList();      

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
            contexto.Entry(livroBuscado).CurrentValues.SetValues(livro);
            contexto.SaveChanges();
            
        }  

        public bool verificaExistenciaDelivro(int isbn)
        {
            return contexto.Livros.Count(l => (l.Isbn == isbn))>0;
        }

        public IEnumerable Paginacao (int p, int t)
        {
            return contexto.Livros.OrderBy(a=> a.DataPublicacao).Skip(p).Take(t).ToList();
        }


         public void Dispose()
         {    
            contexto.Dispose();
         }
    }
}
