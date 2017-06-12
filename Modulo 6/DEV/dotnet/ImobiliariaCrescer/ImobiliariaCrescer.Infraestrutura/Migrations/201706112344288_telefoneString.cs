namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class telefoneString : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Clientes", "Telefone", c => c.String());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Clientes", "Telefone", c => c.Int(nullable: false));
        }
    }
}
