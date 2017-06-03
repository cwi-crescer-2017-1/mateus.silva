namespace EditoraCrescer.Infraesturtura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class CriacaoDePermissaoEUsuario2 : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Permissoes", "Usuario_Id", "dbo.Usuarios");
            DropIndex("dbo.Permissoes", new[] { "Usuario_Id" });
            DropPrimaryKey("dbo.Usuarios");
            AlterColumn("dbo.Usuarios", "Id", c => c.Guid(nullable: false, identity: true));
            AlterColumn("dbo.Permissoes", "Usuario_Id", c => c.Guid());
            AddPrimaryKey("dbo.Usuarios", "Id");
            CreateIndex("dbo.Permissoes", "Usuario_Id");
            AddForeignKey("dbo.Permissoes", "Usuario_Id", "dbo.Usuarios", "Id");
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Permissoes", "Usuario_Id", "dbo.Usuarios");
            DropIndex("dbo.Permissoes", new[] { "Usuario_Id" });
            DropPrimaryKey("dbo.Usuarios");
            AlterColumn("dbo.Permissoes", "Usuario_Id", c => c.Guid());
            AlterColumn("dbo.Usuarios", "Id", c => c.Guid(nullable: false));
            AddPrimaryKey("dbo.Usuarios", "Id");
            CreateIndex("dbo.Permissoes", "Usuario_Id");
            AddForeignKey("dbo.Permissoes", "Usuario_Id", "dbo.Usuarios", "Id");
        }
    }
}
