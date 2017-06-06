using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ImobiliariaCrescer.Dominio.Entidades;

namespace ImobiliariaCrescer.Infraestrutura.Mapping
{
    public class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap ()
        {
            ToTable("Clientes");
            HasKey(x => x.Id);

        }

    }
}
