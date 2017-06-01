using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraestrutura.Entidades;

namespace EditoraCrescer.Infraesturtura.Repositorios
{  
   public  class RepositorioAutor
    {
        private Contexto contexto = new Contexto();

        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
        }

        public Autor Obter(int id)
        {
            return contexto.Autores.FirstOrDefault(a => a.Id == id);  
        }

        public dynamic ObterLivrosDoAutor(int id)
        {
            return contexto.Livros.Where(l => l.IdAutor == id).ToList();
        }


        public void Criar(Autor autor)
        {
            contexto.Autores.Add(autor);
            contexto.SaveChanges();
         }
        
        public void Remover (int id)
        {
            var autor = contexto.Autores.FirstOrDefault(writter => (writter.Id == id));
            contexto.Autores.Remove(autor);
            contexto.SaveChanges();
        }

        public void Alterar(int id, Autor autor)
        {
            var autorBuscado = contexto.Autores.FirstOrDefault(a => (a.Id == id));
           
                contexto.Entry(autorBuscado).CurrentValues.SetValues(autor);
                contexto.SaveChanges();
            
        }

        public bool verificaExistenciaDeAutor(int id)
        {
            return contexto.Autores.Count(a => (a.Id == id)) > 0;
        }
    }
}
