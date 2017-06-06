namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class criarDataBase : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Clientes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Cpf = c.Int(nullable: false),
                        Rg = c.String(),
                        Telefone = c.Int(nullable: false),
                        Endereco = c.String(),
                        DataDeNascimento = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Pedidos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataDoPedido = c.DateTime(nullable: false),
                        ValorTotal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Multa = c.Decimal(precision: 18, scale: 2),
                        DataDeEntrega = c.DateTime(nullable: false),
                        DataPrevistaDeEntrega = c.DateTime(nullable: false),
                        IdCliente = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Clientes", t => t.IdCliente, cascadeDelete: true)
                .Index(t => t.IdCliente);
            
            CreateTable(
                "dbo.ProdutoPedido",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Quantidade = c.Int(nullable: false),
                        IdProduto = c.Int(nullable: false),
                        Pedido_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Produtos", t => t.IdProduto, cascadeDelete: true)
                .ForeignKey("dbo.Pedidos", t => t.Pedido_Id)
                .Index(t => t.IdProduto)
                .Index(t => t.Pedido_Id);
            
            CreateTable(
                "dbo.Produtos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Tipo = c.String(),
                        Quantidade = c.Int(nullable: false),
                        PrecoDaDiaria = c.Decimal(nullable: false, precision: 18, scale: 2),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.ProdutoPedido", "Pedido_Id", "dbo.Pedidos");
            DropForeignKey("dbo.ProdutoPedido", "IdProduto", "dbo.Produtos");
            DropForeignKey("dbo.Pedidos", "IdCliente", "dbo.Clientes");
            DropIndex("dbo.ProdutoPedido", new[] { "Pedido_Id" });
            DropIndex("dbo.ProdutoPedido", new[] { "IdProduto" });
            DropIndex("dbo.Pedidos", new[] { "IdCliente" });
            DropTable("dbo.Produtos");
            DropTable("dbo.ProdutoPedido");
            DropTable("dbo.Pedidos");
            DropTable("dbo.Clientes");
        }
    }
}
