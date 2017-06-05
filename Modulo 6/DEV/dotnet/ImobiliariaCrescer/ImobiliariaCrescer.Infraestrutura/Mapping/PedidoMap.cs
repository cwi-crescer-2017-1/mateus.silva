using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ImobiliariaCrescer.Dominio.Entidades;

namespace ImobiliariaCrescer.Infraestrutura.Mapping
{
    public class PedidoMap : EntityTypeConfiguration<Pedido>
    {
        public PedidoMap()
        {
            ToTable("Pedidos");
            HasKey(x => x.Id);
            HasRequired(x => x.Cliente).WithMany().HasForeignKey(x => x.IdCliente);
        }
    }
}
