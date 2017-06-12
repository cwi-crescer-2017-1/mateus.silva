namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AdicionarGenero : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Clientes", "Genero", c => c.String());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Clientes", "Genero");
        }
    }
}
