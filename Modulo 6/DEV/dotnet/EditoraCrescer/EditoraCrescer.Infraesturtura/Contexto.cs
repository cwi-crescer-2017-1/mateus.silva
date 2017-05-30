﻿using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraesturtura.Mappings;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EditoraCrescer.Infraesturtura
{
   public  class Contexto : DbContext 
    {
        public Contexto (): base("ExemploEFSP")
        {

        }
        public DbSet<Autor> Autores { get; set; }
        
        public DbSet<Livro> Livros { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new AutorMap());
            modelBuilder.Configurations.Add(new LivroMap());
        }
    }
}
