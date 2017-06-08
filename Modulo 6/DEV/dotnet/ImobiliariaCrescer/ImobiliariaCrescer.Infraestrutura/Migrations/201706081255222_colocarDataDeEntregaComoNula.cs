namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class colocarDataDeEntregaComoNula : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Pedidos", "DataDeEntrega", c => c.DateTime());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Pedidos", "DataDeEntrega", c => c.DateTime(nullable: false));
        }
    }
}
