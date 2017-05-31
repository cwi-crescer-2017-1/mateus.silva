﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraestrutura.Entidades;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
   public  class AutorRepositorio
    {
        private Contexto contexto = new Contexto();
        public List<Autor> Obter()
        {
            return contexto.Autores.ToList();
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

    }
}
