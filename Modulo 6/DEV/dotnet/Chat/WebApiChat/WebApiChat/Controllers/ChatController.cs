using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WebApiChat.Models;

namespace WebApiChat.Controllers
{
    public class ChatController : ApiController
    {
        public static int Id = 0;
        private static List<Texto> frases = new List<Texto>();

     
        public IEnumerable<Texto> Get()
        {
            return frases;
        }

        public IHttpActionResult Post(Texto frase)
        {
              frase.ID = Id++;
              frases.Add(frase);
            return Ok();
        }
    }
}
