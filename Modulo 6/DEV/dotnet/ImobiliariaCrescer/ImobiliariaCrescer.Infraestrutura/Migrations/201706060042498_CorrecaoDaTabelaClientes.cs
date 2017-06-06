namespace ImobiliariaCrescer.Infraestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CorrecaoDaTabelaClientes : DbMigration
    {
        public override void Up()
        {
            RenameTable(name: "dbo.Cliente", newName: "Clientes");
        }
        
        public override void Down()
        {
            RenameTable(name: "dbo.Clientes", newName: "Cliente");
        }
    }
}
