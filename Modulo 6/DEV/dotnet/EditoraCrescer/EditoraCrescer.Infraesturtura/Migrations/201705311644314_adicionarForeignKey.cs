namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class adicionarForeignKey : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Livros", "revisor_Id", "dbo.Revisores");
            DropIndex("dbo.Livros", new[] { "revisor_Id" });
            DropColumn("dbo.Livros", "IdRevisor");
            RenameColumn(table: "dbo.Livros", name: "revisor_Id", newName: "IdRevisor");
            AlterColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: false));
            CreateIndex("dbo.Livros", "IdRevisor");
            AddForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores", "Id", cascadeDelete: true);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Livros", "IdRevisor", "dbo.Revisores");
            DropIndex("dbo.Livros", new[] { "IdRevisor" });
            AlterColumn("dbo.Livros", "IdRevisor", c => c.Int());
            RenameColumn(table: "dbo.Livros", name: "IdRevisor", newName: "revisor_Id");
            AddColumn("dbo.Livros", "IdRevisor", c => c.Int(nullable: false));
            CreateIndex("dbo.Livros", "revisor_Id");
            AddForeignKey("dbo.Livros", "revisor_Id", "dbo.Revisores", "Id");
        }
    }
}
