using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1.Dominio.Entidades
{
    public class ItemPedido
    {
        public int Id { get; set; }
        public int ProdutoId { get; set; }
        public int Quantidade { get; set; }


        public bool ValidarPedido(out List<string> mensagens)
        {
            mensagens = new List<string>();

            if (Quantidade < 0)
                mensagens.Add("Pedido não pode ser negativo.");

            if (Quantidade == 0)
                mensagens.Add("Peido deve conter pelo menos um item");

            return mensagens.Count() == 0;
        }
    }
}
