namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDoBanco : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
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
                        IdCliente = c.Int(nullable: false),
                        DataDoPedido = c.DateTime(nullable: false),
                        ValorTotal = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Multa = c.Decimal(precision: 18, scale: 2),
                        DataDeEntrega = c.DateTime(nullable: false),
                        DataPrevistaDeEntrega = c.DateTime(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente, cascadeDelete: true)
                .Index(t => t.IdCliente);
            
            CreateTable(
                "dbo.Produtos",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                        Tipo = c.String(),
                        Quantidade = c.Int(nullable: false),
                        PrecoDaDiaria = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Pedido_Id = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Pedidos", t => t.Pedido_Id)
                .Index(t => t.Pedido_Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Produtos", "Pedido_Id", "dbo.Pedidos");
            DropForeignKey("dbo.Pedidos", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.Produtos", new[] { "Pedido_Id" });
            DropIndex("dbo.Pedidos", new[] { "IdCliente" });
            DropTable("dbo.Produtos");
            DropTable("dbo.Pedidos");
            DropTable("dbo.Cliente");
        }
    }
}
