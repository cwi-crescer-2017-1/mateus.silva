namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class DataDeRevisaoPodeSerNula : DbMigration
    {
        public override void Up()
        {
            AlterColumn("dbo.Livros", "DataRevisao", c => c.DateTime());
        }
        
        public override void Down()
        {
            AlterColumn("dbo.Livros", "DataRevisao", c => c.DateTime(nullable: false));
        }
    }
}
