using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EditoraCrescer.Infraestrutura.Entidades;
using EditoraCrescer.Infraesturtura.Entidades;

namespace EditoraCrescer.Infraesturtura.Mappings
{
    class RevisorMap : EntityTypeConfiguration<Revisor>
    {
        public RevisorMap()
        {
            ToTable("Revisores");

        }
    }
}
