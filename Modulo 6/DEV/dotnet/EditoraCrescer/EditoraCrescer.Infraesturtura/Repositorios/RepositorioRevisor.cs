﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraesturtura.Entidades;

namespace EditoraCrescer.Infraesturtura.Repositorios
{
    public class RepositorioRevisor
    {
        private Contexto contexto = new Contexto();

        public List<Revisor> Obter()
        {
            return contexto.Revisores.ToList();
        }

        public void  Criar (Revisor revisor)
        {
            contexto.Revisores.Add(revisor);
            contexto.SaveChanges();
        }

        public void  Remover(int id)
        {
            var revisor = contexto.Revisores.FirstOrDefault(revi => (revi.Id ==id));
            contexto.Revisores.Remove(revisor);
            contexto.SaveChanges();
        }

    }
}
