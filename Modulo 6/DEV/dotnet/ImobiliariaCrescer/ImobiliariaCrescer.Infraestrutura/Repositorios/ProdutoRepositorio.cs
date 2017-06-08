using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ImobiliariaCrescer.Dominio.Entidades;

namespace ImobiliariaCrescer.Infraestrutura.Repositorios
{
    public class ProdutoRepositorio : IDisposable
    {
            private Contexto contexto = new Contexto();

            public dynamic Obter()
            {
                return contexto.Produtos.ToList();
            }

            public Produto ObterPorId(int id)
            {
                return contexto.Produtos.FirstOrDefault(p => (p.Id == id));
            }

            public dynamic ObterPacotes()
            {
            return contexto.Produtos.Where(p => p.Tipo.Contains("Casa") &&p.Quantidade>0||
                   p.Tipo.Contains("Apartamento") && p.Quantidade > 0 ||
                   p.Tipo.Contains("Cabana") && p.Quantidade > 0
                   || p.Tipo.Contains("Suíte") && p.Quantidade > 0).ToList();
            }

            public dynamic ObterOpcionais()
            {
            return contexto.Produtos.Where(p => p.Tipo.Contains("Opcionais") && p.Quantidade>0).ToList();
            }

            public void CriarProduto(Produto produto)
            {
                contexto.Produtos.Add(produto);
                contexto.SaveChanges();
            }

            public void Remover(int id)
            {
                var produto = contexto.Produtos.FirstOrDefault(p=> (p.Id == id));
                contexto.Produtos.Remove(produto);
                contexto.SaveChanges();
            }

            public void Alterar(int id, Produto produto)
            {
                contexto.Entry(produto).State = System.Data.Entity.EntityState.Modified;
                contexto.SaveChanges();
            }

            public void Dispose()
            {
                contexto.Dispose();
            }
    }
}

