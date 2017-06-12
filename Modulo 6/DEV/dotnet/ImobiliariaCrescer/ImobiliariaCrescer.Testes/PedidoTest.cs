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
    public class PedidoTest
    {

        [TestMethod]
        public void instanciarPedidoComUmProduto()
        {
            int id = 1;
            string nome = "Mateus";
            string cpf = "02701870071";
            string rg = "0193453291";
            string telefone = "05199924262160";
            string endereco = "Sapucaia do Sul, rua Mario Bandeira, 42";
            string genero = "Masculino";
            DateTime nascimento = DateTime.Parse("26-03-1990");

            var cliente = new Cliente(id, nome, cpf, rg, telefone, endereco, genero, nascimento);
            var produto1 = new Produto(1, "Sauna", "Economy", 10, 100);
            var produto2 = new Produto(2, "Frigobar", "Opcional", 10, 10);
            var item1 = new ProdutoPedido(1, produto1);
            int idp = 1;
            List<ProdutoPedido> itens = new List<ProdutoPedido>();
            itens.Add(item1);
            DateTime entrega = DateTime.Now.AddDays(1);

            var pedido = new Pedido(idp, cliente, itens, entrega);
            Assert.AreEqual(cliente, pedido.Cliente);
            Assert.AreEqual(idp, pedido.Id);
            Assert.AreEqual(entrega, pedido.DataPrevistaDeEntrega);
            Assert.AreEqual(100, pedido.ValorTotal);
            Assert.AreEqual(DateTime.Now.Month, pedido.DataDoPedido.Month);
            Assert.AreEqual(DateTime.Now.Year, pedido.DataDoPedido.Year);
            Assert.AreEqual(DateTime.Now.Day, pedido.DataDoPedido.Day);
        }


        [TestMethod]
        public void instanciarPedidoComDoisProdutos()
        {
            int id = 1;
            string nome = "Mateus";
            string cpf = "02701870071";
            string rg = "0193453291";
            string telefone = "05199924262160";
            string endereco = "Sapucaia do Sul, rua Mario Bandeira, 42";
            string genero = "Masculino";
            DateTime nascimento = DateTime.Parse("26-03-1990");

            var cliente = new Cliente(id, nome, cpf, rg, telefone, endereco, genero, nascimento);
            var produto1 = new Produto(1, "Sauna", "Economy", 10, 100);
            var produto2 = new Produto(2, "Frigobar", "Opcional", 10, 10);
            var item1 = new ProdutoPedido(1, produto1);
            var item2 = new ProdutoPedido(2, produto2);
            int idp = 1;
            List<ProdutoPedido> itens = new List<ProdutoPedido>();
            itens.Add(item1);
            itens.Add(item2);
            DateTime entrega = DateTime.Now.AddDays(1);

            var pedido = new Pedido(idp, cliente, itens,  entrega);
            Assert.AreEqual(cliente , pedido.Cliente);
            Assert.AreEqual(idp, pedido.Id);
            Assert.AreEqual(entrega, pedido.DataPrevistaDeEntrega);
            Assert.AreEqual(110, pedido.ValorTotal);
            Assert.AreEqual(DateTime.Now.Month, pedido.DataDoPedido.Month);
            Assert.AreEqual(DateTime.Now.Year, pedido.DataDoPedido.Year);
            Assert.AreEqual(DateTime.Now.Day, pedido.DataDoPedido.Day);
        }

        [TestMethod]
        public void pedidoComDoisDiasDeAtraso()
        {
            int id = 1;
            string nome = "Mateus";
            string cpf = "02701870071";
            string rg = "0193453291";
            string telefone = "05199924262160";
            string endereco = "Sapucaia do Sul, rua Mario Bandeira, 42";
            string genero = "Masculino";
            DateTime nascimento = DateTime.Parse("26-03-1990");

            var cliente = new Cliente(id, nome, cpf, rg, telefone, endereco, genero, nascimento);
            var produto1 = new Produto(1, "Sauna", "Economy", 10, 100);
            var produto2 = new Produto(2, "Frigobar", "Opcional", 10, 10);
            var item1 = new ProdutoPedido(1, produto1);
            var item2 = new ProdutoPedido(2, produto2);
            int idp = 1;
            List<ProdutoPedido> itens = new List<ProdutoPedido>();
            itens.Add(item1);
            itens.Add(item2);
            DateTime entrega = DateTime.Now.AddDays(-2); 

            var pedido = new Pedido(idp, cliente, itens, entrega);
            Assert.AreEqual(cliente, pedido.Cliente);
            Assert.AreEqual(idp, pedido.Id);
            Assert.AreEqual(220, Math.Abs(pedido.ValorTotal));
            Assert.AreEqual(DateTime.Now.Month, pedido.DataDoPedido.Month);
            Assert.AreEqual(DateTime.Now.Year, pedido.DataDoPedido.Year);
            Assert.AreEqual(DateTime.Now.Day, pedido.DataDoPedido.Day);

            pedido.SetDataDeEntrega();
            pedido.AplicaMulta();
            Assert.AreEqual(440, Math.Abs(Math.Truncate((decimal)pedido.Multa)));
        }

        [TestMethod]
        public void pedidoComDoisProdutosIguais()
        {
            int id = 1;
            string nome = "Mateus";
            string cpf = "02701870071";
            string rg = "0193453291";
            string telefone = "05199924262160";
            string endereco = "Sapucaia do Sul, rua Mario Bandeira, 42";
            string genero = "Masculino";
            DateTime nascimento = DateTime.Parse("26-03-1990");

            var cliente = new Cliente(id, nome, cpf, rg, telefone, endereco, genero, nascimento);
            var produto1 = new Produto(1, "Sauna", "Economy", 10, 100);
            var produto2 = new Produto(2, "Frigobar", "Opcional", 10, 10);
            var item1 = new ProdutoPedido(1, produto1);
            var item2 = new ProdutoPedido(2, produto2);
            int idp = 1;
            List<ProdutoPedido> itens = new List<ProdutoPedido>();
            itens.Add(item1);
            itens.Add(item2);
            itens.Add(item2);
           DateTime entrega = DateTime.Now.AddDays(1);

            var pedido = new Pedido(idp, cliente, itens, entrega);
            Assert.AreEqual(cliente, pedido.Cliente);
            Assert.AreEqual(idp, pedido.Id);
            Assert.AreEqual(120, pedido.ValorTotal);
            Assert.AreEqual(DateTime.Now.Month, pedido.DataDoPedido.Month);
            Assert.AreEqual(DateTime.Now.Year, pedido.DataDoPedido.Year);
            Assert.AreEqual(DateTime.Now.Day, pedido.DataDoPedido.Day);

            produto2.baixarEstoqueProduto();
            produto2.baixarEstoqueProduto();
            Assert.AreEqual(8, produto2.Quantidade);
        }

        public void instanciarPedidoComUmProdutodeValoresNotEqual()
        {
            int id = 1;
            string nome = "Mateus";
            string cpf = "02701870071";
            string rg = "0193453291";
            string telefone = "05199924262160";
            string endereco = "Sapucaia do Sul, rua Mario Bandeira, 42";
            string genero = "Masculino";
            DateTime nascimento = DateTime.Parse("26-03-1990");

            var cliente = new Cliente(id, nome, cpf, rg, telefone, endereco, genero, nascimento);
            var produto1 = new Produto(1, "Sauna", "Economy", 10, 100);
            var produto2 = new Produto(2, "Frigobar", "Opcional", 10, 10);
            var item1 = new ProdutoPedido(1, produto1);
            int idp = 1;
            List<ProdutoPedido> itens = new List<ProdutoPedido>();
            itens.Add(item1);
            DateTime entrega = DateTime.Now;

            var pedido = new Pedido(idp, cliente, itens, entrega);
            Assert.AreEqual(cliente, pedido.Cliente);
            Assert.AreEqual(idp, pedido.Id);
            Assert.AreNotEqual(DateTime.Now.AddDays(1), pedido.DataPrevistaDeEntrega);
            Assert.AreNotEqual(13, pedido.ValorTotal);
            Assert.AreNotEqual(DateTime.Now.AddMonths(1), pedido.DataDoPedido.Month);
            Assert.AreNotEqual(DateTime.Now.AddYears(3), pedido.DataDoPedido.Year);
            Assert.AreNotEqual(DateTime.Now.AddDays(-3), pedido.DataDoPedido.Day);
        }

        [TestMethod]
        public void pedidoCom100DiasDeAtraso()
        {
            int id = 1;
            string nome = "Mateus";
            string cpf = "02701870071";
            string rg = "0193453291";
            string telefone = "05199924262160";
            string endereco = "Sapucaia do Sul, rua Mario Bandeira, 42";
            string genero = "Masculino";
            DateTime nascimento = DateTime.Parse("26-03-1990");

            var cliente = new Cliente(id, nome, cpf, rg, telefone, endereco, genero, nascimento);
            var produto1 = new Produto(1, "Sauna", "Economy", 10, 100);
            var produto2 = new Produto(2, "Frigobar", "Opcional", 10, 10);
            var item1 = new ProdutoPedido(1, produto1);
            var item2 = new ProdutoPedido(2, produto2);
            int idp = 1;
            List<ProdutoPedido> itens = new List<ProdutoPedido>();
            itens.Add(item1);
            itens.Add(item2);
            DateTime entrega = DateTime.Now.AddDays(-10);

            var pedido = new Pedido(idp, cliente, itens, entrega);
            Assert.AreEqual(cliente, pedido.Cliente);
            Assert.AreEqual(idp, pedido.Id);
            Assert.AreEqual(1100, Math.Abs(pedido.ValorTotal));
            Assert.AreEqual(DateTime.Now.Month, pedido.DataDoPedido.Month);
            Assert.AreEqual(DateTime.Now.Year, pedido.DataDoPedido.Year);
            Assert.AreEqual(DateTime.Now.Day, pedido.DataDoPedido.Day);

            pedido.SetDataDeEntrega();
            pedido.AplicaMulta();
            Assert.AreEqual(11000, Math.Abs(Math.Truncate((decimal)pedido.Multa)));
        }

        [TestMethod]
        public void pedidoCom40DiasDeAtraso()
        {
            int id = 1;
            string nome = "Mateus";
            string cpf = "02701870071";
            string rg = "0193453291";
            string telefone = "05199924262160";
            string endereco = "Sapucaia do Sul, rua Mario Bandeira, 42";
            string genero = "Masculino";
            DateTime nascimento = DateTime.Parse("26-03-1990");

            var cliente = new Cliente(id, nome, cpf, rg, telefone, endereco, genero, nascimento);
            var produto1 = new Produto(1, "Sauna", "Economy", 10, 100);
            var produto2 = new Produto(2, "Frigobar", "Opcional", 10, 10);
            var item1 = new ProdutoPedido(1, produto1);
            var item2 = new ProdutoPedido(2, produto2);
            int idp = 1;
            List<ProdutoPedido> itens = new List<ProdutoPedido>();
            itens.Add(item1);
            itens.Add(item2);
            DateTime entrega = DateTime.Now.AddDays(-40);

            var pedido = new Pedido(idp, cliente, itens, entrega);
            Assert.AreEqual(cliente, pedido.Cliente);
            Assert.AreEqual(idp, pedido.Id);
            Assert.AreEqual(4400, Math.Abs(pedido.ValorTotal));
            Assert.AreEqual(DateTime.Now.Month, pedido.DataDoPedido.Month);
            Assert.AreEqual(DateTime.Now.Year, pedido.DataDoPedido.Year);
            Assert.AreEqual(DateTime.Now.Day, pedido.DataDoPedido.Day);

            pedido.SetDataDeEntrega();
            pedido.AplicaMulta();
            Assert.AreEqual(176000, Math.Abs(Math.Truncate((decimal)pedido.Multa)));
        }

        [TestMethod]
        public void pedidoSemMulta()
        {
            int id = 1;
            string nome = "Mateus";
            string cpf = "02701870071";
            string rg = "0193453291";
            string telefone = "05199924262160";
            string endereco = "Sapucaia do Sul, rua Mario Bandeira, 42";
            string genero = "Masculino";
            DateTime nascimento = DateTime.Parse("26-03-1990");

            var cliente = new Cliente(id, nome, cpf, rg, telefone, endereco, genero, nascimento);
            var produto1 = new Produto(1, "Sauna", "Economy", 10, 100);
            var produto2 = new Produto(2, "Frigobar", "Opcional", 10, 10);
            var item1 = new ProdutoPedido(1, produto1);
            var item2 = new ProdutoPedido(2, produto2);
            int idp = 1;
            List<ProdutoPedido> itens = new List<ProdutoPedido>();
            itens.Add(item1);
            itens.Add(item2);
            DateTime entrega = DateTime.Now.AddDays(1);

            var pedido = new Pedido(idp, cliente, itens, entrega);
            Assert.AreEqual(cliente, pedido.Cliente);
            Assert.AreEqual(idp, pedido.Id);
            Assert.AreEqual(110, Math.Abs(pedido.ValorTotal));
            Assert.AreEqual(DateTime.Now.Month, pedido.DataDoPedido.Month);
            Assert.AreEqual(DateTime.Now.Year, pedido.DataDoPedido.Year);
            Assert.AreEqual(DateTime.Now.Day, pedido.DataDoPedido.Day);

            pedido.SetDataDeEntrega();
            pedido.AplicaMulta();
            Assert.AreEqual(0, Math.Abs(Math.Truncate((decimal)pedido.Multa)));
        }
    }




}
