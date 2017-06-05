using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.Entity;
using System.Globalization;
using System.Collections;
using EditoraCrescer.Infraesturtura.Entidades;

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
            return contexto.Livros.Include(x => x.Autor).Include(x => x.Revisor).FirstOrDefault(a => (a.Isbn == isbn));
           
        }

        public dynamic Obter(string genero)
        {
            var livro = contexto.Livros.Select(l => new { l.Isbn, l.Titulo, l.Capa, Autor = l.Autor.Nome, l.Genero })
           .FirstOrDefault(a => a.Genero.Contains(genero));
            return livro;

        }

        public dynamic obterLivrosNaoPublicados()
        {
             return contexto.Livros.Include(x => x.Autor).Include(x => x.Revisor).Where(l => l.DataPublicacao == null);
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
            if (livro.Revisor == null)
            {
                livro.Revisor = new Revisor();
            }
            
            if (livro.Autor == null)
            {
                livro.Autor = new Autor();    
            }

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
            contexto.Entry(livro).State = System.Data.Entity.EntityState.Modified;
            contexto.Entry(livro.Autor).State = System.Data.Entity.EntityState.Modified;
            contexto.Entry(livro.Revisor).State = System.Data.Entity.EntityState.Modified;
            contexto.SaveChanges();
            
        }  

        public bool verificaExistenciaDelivro(int isbn)
        {
            return contexto.Livros.Count(l => (l.Isbn == isbn))>0;
        }

        public IEnumerable Paginacao (int p, int t)
        {
            var seteDiasAtras = DateTime.Now.AddDays(-7);
            return contexto.Livros.Where(x => x.DataPublicacao != null &&
                         DbFunctions.TruncateTime(x.DataPublicacao.Value) < seteDiasAtras).OrderBy(a=> a.DataPublicacao).Skip(p).Take(t).Select
            (x => new { x.Isbn, x.Titulo, x.Capa, x.Autor.Nome, x.Genero }).ToList(); 
        }

        public IEnumerable PaginacaoLancamentos(int p, int t)
        {
            var seteDiasAtras = DateTime.Now.AddDays(-7);
            return contexto.Livros.Where(x => x.DataPublicacao != null &&
                         DbFunctions.TruncateTime(x.DataPublicacao.Value) > seteDiasAtras).OrderBy(a => a.DataPublicacao).Skip(p).Take(t).Select
            (x => new { x.Isbn, x.Titulo, x.Capa, x.Autor.Nome, x.Genero }).ToList();
        }

        public int ObterQuantidadeLivrosPublicadosExcetoLancamentos()
         {
            var seteDiasAtras = DateTime.Now.AddDays(-7);
             return contexto.Livros
                     .Where(x => x.DataPublicacao != null &&
                         DbFunctions.TruncateTime(x.DataPublicacao.Value) < seteDiasAtras)
                     .Count();
         }

        public int ObterQuantidadeLivrosPublicadosLancamentos()
        {
            var seteDiasAtras = DateTime.Now.AddDays(-7);
            return contexto.Livros
                    .Where(x => x.DataPublicacao != null &&
                        DbFunctions.TruncateTime(x.DataPublicacao.Value) > seteDiasAtras)
                    .Count();
        }



        public void Dispose()
         {    
            contexto.Dispose();
         }
    }
}
