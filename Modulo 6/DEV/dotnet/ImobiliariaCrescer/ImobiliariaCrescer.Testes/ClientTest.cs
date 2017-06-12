using System;
using ImobiliariaCrescer.Dominio.Entidades;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ImobiliariaCrescer.Testes
{
    [TestClass]
    public class ClientTest
    {
        [TestMethod]
        public void instanciarCliente()
        {
            int id= 1;
            string nome = "Mateus";
            string cpf = "02701870071";
            string rg = "0193453291";
            string telefone = "05199924262160";
            string endereco = "Sapucaia do Sul, rua Mario Bandeira, 42";
            string genero = "Masculino";
            DateTime nascimento = DateTime.Parse("26-03-1990");

            var cliente = new Cliente(id, nome, cpf, rg, telefone, endereco, genero, nascimento);

            Assert.AreEqual(nome, cliente.Nome);
            Assert.AreEqual(cpf, cliente.Cpf);
            Assert.AreEqual(rg, cliente.Rg);
            Assert.AreEqual(endereco, cliente.Endereco);
            Assert.AreEqual(genero, cliente.Genero);
            Assert.AreEqual(nascimento, cliente.DataDeNascimento);

        }
        [TestMethod]
        public void instanciarClienteComValoresDiferentes()
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
            Assert.AreNotEqual("Jose", cliente.Nome);
            Assert.AreNotEqual("4324323", cliente.Cpf);
            Assert.AreNotEqual("334334", cliente.Rg);
            Assert.AreNotEqual("Porto Alegre", cliente.Endereco);
            Assert.AreNotEqual('F', cliente.Genero);
            Assert.AreNotEqual(DateTime.Parse("26-03-1290"), cliente.DataDeNascimento);

        }


    }
}
