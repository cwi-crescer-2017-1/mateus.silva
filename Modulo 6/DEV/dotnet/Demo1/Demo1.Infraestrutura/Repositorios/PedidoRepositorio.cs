using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Demo1.Dominio.Entidades;

namespace Demo1.Infraestrutura.Repositorios
{
    public class PedidoRepositorio : IPedidoRepositorio
    {
        string stringConexao = @"Server=13.65.101.67; User Id=mateus.silva; Password=123456; Database=aluno20db";

        public void Alterar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"UPDATE PEDIDO SET 
                    NomeCliente =@nomeCliente Itens = @itens WHERE Id = @id";

                    comando.Parameters.AddWithValue("@nomecliente", pedido.NomeCliente);
                    comando.Parameters.AddWithValue("@itens", pedido.Itens);
                    comando.ExecuteNonQuery();
                }
            }        
        }

        public void Criar(Pedido pedido)
        {
            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    //comando.CommandText = @"  INSERT INTO ItemPedido (ProdutoId, Quantidade) VALUES
                    //( @idProduto, @quantidade) INSERT INTO Pedido (NomeCliente, Itens) VALUES 
                   // (@nomeCliente, @itens)";
                    comando.CommandText = @"  INSERT INTO ItemPedido (Id, ProdutoId, Quantidade) VALUES
                    (@id,  @idProduto, @quantidade) INSERT INTO Pedido (NomeCliente) VALUES 
                    (@nomeCliente)";
                    foreach (var item in pedido.Itens)
                    {
                        var idProduto = item.ProdutoId;
                        var quantidade = item.Quantidade;
                        comando.Parameters.AddWithValue("@id", pedido.Id);
                        comando.Parameters.AddWithValue("@idProduto", idProduto);
                        comando.Parameters.AddWithValue("@quantidade", quantidade);
                    }
                    comando.Parameters.AddWithValue("@nomeCliente", pedido.NomeCliente);
                    //comando.Parameters.AddWithValue("@itens", pedido.Itens);
                    comando.Parameters.AddWithValue("@idPedido", pedido.Id);

                 
                    comando.ExecuteNonQuery();

                }
            }
        }

        public void Excluir(int id)
        {
           using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();

                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"DELETE Pedido WHERE Id=@id";
                    comando.Parameters.AddWithValue("@id", id);
                    comando.ExecuteNonQuery();
                }
            }
        }

        public IEnumerable<Pedido> Listar()
        {
            var pedidos = new List<Pedido>();

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT NomeCliente, Id FROM Pedido";
                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        var pedido = new Pedido();
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        foreach (var item in pedido.Itens)
                       {
                            item.Id = (int)dataReader["Id"];
                            item.Quantidade = (int)dataReader["Quantidades"];
                            item.ProdutoId = (int)dataReader["PodudoId"];
                        }
                        pedido.Id = (int)dataReader["Id"];
                        pedidos.Add(pedido);
                    }

                }
            }
            return pedidos;
        }

        public Pedido Obter(int id)
        {
            Pedido pedido = null;

            using (var conexao = new SqlConnection(stringConexao))
            {
                conexao.Open();
                using (var comando = conexao.CreateCommand())
                {
                    comando.CommandText = @"SELECT  NomeCliente WHERE Id = @id";
                    comando.Parameters.AddWithValue("@id", id);
                    var dataReader = comando.ExecuteReader();
                    while (dataReader.Read())
                    {
                        pedido = new Pedido();
                        pedido.Id = (int)dataReader ["Id"];
                        pedido.NomeCliente = (string)dataReader["NomeCliente"];
                        foreach (var item in pedido.Itens)
                        {
                            item.Id = (int)dataReader["Id"];
                            item.Quantidade = (int)dataReader["Quantidades"];
                            item.ProdutoId = (int)dataReader["PodudoId"];
                        }
                        return pedido;

                    }
                }
                return pedido;
            }

        }
    }
}