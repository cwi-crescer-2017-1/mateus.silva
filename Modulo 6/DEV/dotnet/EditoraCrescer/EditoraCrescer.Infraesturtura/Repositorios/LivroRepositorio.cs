using EditoraCrescer.Infraestrutura.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
   public  class LivroRepositorio
    {

    
         private Contexto contexto = new Contexto();

         public List<Livro> Obter()
         {
             return contexto.Livros.ToList();
         }
    
         public void Criar(Livro livro)
         {
            contexto.Livros.Add(livro);
            contexto.SaveChanges();
         }

         public void Remover(int id)
         {
            var livro = contexto.Livros.FirstOrDefault(a => (a.Isbn == id));


            contexto.Livros.Remove(livro);
            contexto.SaveChanges();
        }


    }
}
