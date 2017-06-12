using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ImobiliariaCrescer.Dominio.Entidades;

namespace ImobiliariaCrescer.Infraestrutura.Mapping
{
    public class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuarios");
            HasKey(x => x.Id);
            Property(p => p.Nome).HasMaxLength(300);

        }
    }
}