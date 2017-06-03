using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraesturtura.Entidades;

namespace EditoraCrescer.Infraesturtura.Mappings
{
   public  class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuarios");
            HasKey(x => x.Id);
            Property(p => p.Nome).HasMaxLength(300);
                  
        }
    }
}
