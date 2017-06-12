using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ImobiliariaCrescer.Dominio.Entidades;
using ImobiliariaCrescer.Infraestrutura.Mapping;

namespace ImobiliariaCrescer.Infraestrutura
{
    public class Contexto : DbContext
    {
        public Contexto() : base("ExemploEFSP")
        {

        }
        public DbSet<Cliente> Clientes { get; set; }

        public DbSet<Pedido> Pedidos { get; set; }

        public DbSet<Produto> Produtos { get; set; }

        public DbSet<ProdutoPedido> ProdutoPedido { get; set; }

        public DbSet<Usuario> Usuario { get; set; }

        public DbSet<Permissao> Permissao { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new PedidoMap());
            modelBuilder.Configurations.Add(new ProdutoMap());
            modelBuilder.Configurations.Add(new ProdutoPedidoMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
        
        }
    }
}
