using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Demo1
{
    class Program
    {
        static void Main(string[] args)
        {

          

            bool continua = true;
            var entradas = new int[0]; 
            while (continua)
            {
                Console.WriteLine("Digite um valor");
                var linhaLida = Console.ReadLine();
                if (linhaLida =="exit")
                {
                    break;
                }

                var nrEntradas = entradas.Length;
                var entradasAux = new int[nrEntradas + 1];
                for (int i = 0; i < nrEntradas; i++)
                {
                    entradasAux[i] = entradas[i];

                }
                entradasAux[nrEntradas] = int.Parse(linhaLida);
                entradas = entradasAux;
             }

             foreach (var entrada in entradas)
                 {
                Console.WriteLine(entrada);
            }
            Console.ReadLine();


            //-------------------- exercícios feitos em aula ---------------------------
            //   List <int> entradas = new List <int>{ };
            //  var  a = 0;
            //  while (true)
            //  {
            //    Console.WriteLine("Digite um valor");
            //     var entrada = Console.ReadLine();

            //   if (entrada == "exit")
            //     break;
            //   else
            //  {

            //      var valor = int.Parse(entrada);
            //       entradas.Add(valor);
            //    }
            // }

            // foreach (var entrada in entradas)
            // {
            //Console.WriteLine(entrada);
            //}
            //Console.ReadLine();

--------------------------------------------------------------

            //Console.WriteLine("Informe seu peso: ");
            //   var entradaPeso = Console.ReadLine();
            //var peso = 0D;
            // if (!double.TryParse(entradaPeso, out peso))
            //    Console.WriteLine("entrada inválida");

            //  Console.WriteLine("Informe sua altura");
            //  var entradaAltura = Console.ReadLine();

            //   var peso = double.Parse(entradaPeso);
            //   var altura = double.Parse(entradaAltura);

            //  var calculoIMC = new CalculoIMC(altura, peso);
            //  var imc = calculoIMC.CalcularIMC();


            //  Console.WriteLine($"Seu IMC: {imc}");
            // Console.ReadKey();


----------------------------------------------------------------------------------------


            //   Pessoa pessoa = new Pessoa();
            //pessoa.Id = null;
            /// pessoa.Nascimento = new DateTime(1990, 03, 26);
            // pessoa.Nome = "Mateus Forgiarini da Silva";
            //  pessoa.Nome = "Mateus Forgiarini " + pessoa.Id;
            //pessoa.Nome = $"Mateus Forgiarini {pessoa.Id}";

            //    if (pessoa.Id== null)
            // {
            //   Console.WriteLine("nao tem valor");
            //  }
            // else
            // {
            // Console.WriteLine(pessoa.Id);
            // }



            // Console.WriteLine(pessoa.Nome);
            // Console.ReadKey();
        }
    }
}
