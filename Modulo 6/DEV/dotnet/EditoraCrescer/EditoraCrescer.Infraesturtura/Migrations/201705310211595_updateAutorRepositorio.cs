namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class updateAutorRepositorio : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Revisors",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
            AddColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: false));
            AddColumn("dbo.Livros", "DataRevisao", c => c.DateTime(nullable: false));
            AddColumn("dbo.Livros", "revisor_Id", c => c.Int());
            CreateIndex("dbo.Livros", "revisor_Id");
            AddForeignKey("dbo.Livros", "revisor_Id", "dbo.Revisors", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livros", "revisor_Id", "dbo.Revisors");
            DropIndex("dbo.Livros", new[] { "revisor_Id" });
            DropColumn("dbo.Livros", "revisor_Id");
            DropColumn("dbo.Livros", "DataRevisao");
            DropColumn("dbo.Livros", "IdRevisor");
            DropTable("dbo.Revisors");
        }
    }
}
