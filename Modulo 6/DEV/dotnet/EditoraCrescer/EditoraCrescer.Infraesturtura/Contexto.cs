﻿using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraesturtura.Mappings;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraesturtura.Entidades;

namespace EditoraCrescer.Infraesturtura
{
   public  class Contexto : DbContext 
    {
        public Contexto (): base("ExemploEFSP")
        {

        }
        public DbSet<Autor> Autores { get; set; }
        
        public DbSet<Livro> Livros { get; set; }

        public DbSet<Revisor> Revisores {get; set;}

        public DbSet<Usuario> Usuario { get; set; }

        public DbSet<Permissao> Permissao { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new AutorMap());
            modelBuilder.Configurations.Add(new LivroMap());
            modelBuilder.Configurations.Add(new RevisorMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
        }
    }
}
