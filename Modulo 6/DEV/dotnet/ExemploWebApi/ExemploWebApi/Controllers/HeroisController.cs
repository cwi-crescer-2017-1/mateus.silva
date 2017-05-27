using ExemploWebApi.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace ExemploWebApi.Controllers
{
    public class HeroisController : ApiController
    {

        public static int ultimoId  = 0;
        private static List<Heroi> herois = new List<Heroi>();
       


        public IEnumerable<Heroi> Get(int? id = null)
        {
            return herois;

            //   return herois.Where(heroi => (heroi.Id == id || id == null) && (nome == null || heroi.Nome == nome));
            //  // if (id == null){
            // //      return herois;
            ////   }else {
            // //      return herois.Where(heroi => heroi.Id == id);


        }

       public IHttpActionResult Post(Heroi heroi)
        //  public void Post(Heroi heroi)

        {
            if (heroi.Id == 0)
            {
                heroi.Id = ultimoId;


                herois.Add(heroi);
                ultimoId++;
                return Ok(heroi);
               

            }
           else
            {
                return BadRequest();

            }
        }


    }
}

