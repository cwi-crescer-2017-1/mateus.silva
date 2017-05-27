using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WebApiChat.Models
{
    public class Texto
    {
        public string Frase { get; set; }
        public Texto(string frase)
        {
            Frase = frase;
        }
    }
}