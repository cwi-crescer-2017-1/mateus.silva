using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ImobiliariaCrescer.Dominio.Entidades;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ImobiliariaCrescer.Testes
{

    [TestClass]
    public class ProdutoTest
    {
        [TestMethod]
        public void instanciarProduto()
        {
            int id = 1;
            string nome = "Suíte";
            string tipo = "Economy";
            int quantidade = 12;
            decimal preco = 100;

            var produto = new Produto(id, nome, tipo, quantidade, preco);
            Assert.AreEqual(id, produto.Id);
            Assert.AreEqual(nome, produto.Nome);
            Assert.AreEqual(tipo, produto.Tipo);
            Assert.AreEqual(quantidade, produto.Quantidade);
            Assert.AreEqual(preco, produto.PrecoDaDiaria);
        }

        [TestMethod]
        public void instanciarProduoComValoresFalsos()
        {
            int id = 1;
            string nome = "Suíte";
            string tipo = "Economy";
            int quantidade = 12;
            decimal preco = 100;

            var produto = new Produto(id, nome, tipo, quantidade, preco);
            Assert.AreNotEqual(2, produto.Id);
            Assert.AreNotEqual("Joel", produto.Nome);
            Assert.AreNotEqual("King", produto.Tipo);
            Assert.AreNotEqual(1, produto.Quantidade);
            Assert.AreNotEqual(20, produto.PrecoDaDiaria);
        }

        [TestMethod]
        public void DiminuirQuantidade()
        {
            int id = 1;
            string nome = "Suíte";
            string tipo = "Economy";
            int quantidade = 12;
            decimal preco = 100;

            var produto = new Produto(id, nome, tipo, quantidade, preco);
            Assert.AreEqual(id, produto.Id);
            Assert.AreEqual(nome, produto.Nome);
            Assert.AreEqual(tipo, produto.Tipo);
            Assert.AreEqual(quantidade, produto.Quantidade);
            Assert.AreEqual(preco, produto.PrecoDaDiaria);


            produto.baixarEstoqueProduto();
            Assert.AreEqual(11, produto.Quantidade);
        }

        [TestMethod]
        public void DevolverProduto()
        {
            int id = 1;
            string nome = "Suíte";
            string tipo = "Economy";
            int quantidade = 12;
            decimal preco = 100;

            var produto = new Produto(id, nome, tipo, quantidade, preco);
            Assert.AreEqual(id, produto.Id);
            Assert.AreEqual(nome, produto.Nome);
            Assert.AreEqual(tipo, produto.Tipo);
            Assert.AreEqual(quantidade, produto.Quantidade);
            Assert.AreEqual(preco, produto.PrecoDaDiaria);


            produto.baixarEstoqueProduto();
            Assert.AreEqual(11, produto.Quantidade);

            produto.devolverProduto();
            Assert.AreEqual(12, produto.Quantidade);
        }

        [TestMethod]
        public void baixarEstoqueDeProdutoZerado()
        {
            int id = 1;
            string nome = "Suíte";
            string tipo = "Economy";
            int quantidade = 0;
            decimal preco = 100;

            var produto = new Produto(id, nome, tipo, quantidade, preco);
            Assert.AreEqual(id, produto.Id);
            Assert.AreEqual(nome, produto.Nome);
            Assert.AreEqual(tipo, produto.Tipo);
            Assert.AreEqual(quantidade, produto.Quantidade);
            Assert.AreEqual(preco, produto.PrecoDaDiaria);


            produto.baixarEstoqueProduto();
            Assert.AreEqual(0, produto.Quantidade);
        }

        [TestMethod]
        public void baixarEstoqueAteZerar()
        {
            int id = 1;
            string nome = "Suíte";
            string tipo = "Economy";
            int quantidade = 3;
            decimal preco = 100;

            var produto = new Produto(id, nome, tipo, quantidade, preco);
            Assert.AreEqual(id, produto.Id);
            Assert.AreEqual(nome, produto.Nome);
            Assert.AreEqual(tipo, produto.Tipo);
            Assert.AreEqual(quantidade, produto.Quantidade);
            Assert.AreEqual(preco, produto.PrecoDaDiaria);


            produto.baixarEstoqueProduto();
            Assert.AreEqual(2, produto.Quantidade);
            produto.baixarEstoqueProduto();
            Assert.AreEqual(1, produto.Quantidade);
            produto.baixarEstoqueProduto();
            Assert.AreEqual(0, produto.Quantidade);
            produto.baixarEstoqueProduto();
            Assert.AreEqual(0, produto.Quantidade);
      
        }
    }
}
