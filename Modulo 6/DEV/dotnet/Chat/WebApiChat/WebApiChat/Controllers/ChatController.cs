using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Text.RegularExpressions;
using System.Web.Http;
using WebApiChat.Models;

namespace WebApiChat.Controllers
{
    public class ChatController : ApiController
    {
        private static int Id = 0;
        private static List<Texto> frases = new List<Texto>();
        private static object @lock = new object();


        public List<Texto> Get()
        {
            return frases;
        }

        public IHttpActionResult Post(Texto frase)
        {
           
            lock (@lock)
            frase.ID = Id++;
            string pattern = "(?i)nunes(?i)";
            string replacement = "$$$$$$$$$ $$$$$$$$$";
            Regex rgx = new Regex(pattern);
            frase.Frase = rgx.Replace(frase.Frase, replacement);
            frases.Add(frase);
            return Ok();
           
        }
    }
   
          
    
}
