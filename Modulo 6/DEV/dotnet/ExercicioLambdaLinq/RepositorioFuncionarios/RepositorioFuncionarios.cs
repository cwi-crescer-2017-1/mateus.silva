using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }
        
        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return Funcionarios.Where(funcionario => funcionario.Cargo.Equals(cargo)).ToList();
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return  Funcionarios.OrderBy(funcionario =>funcionario.Cargo.Titulo)
                .ThenBy(funcionario => funcionario.Nome)
                .ToList();
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
            return Funcionarios.Where(funcionario => funcionario.Nome.Contains(nome)).ToList();
        }        

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            if (turnos == null)
            {
               return  Funcionarios.ToList();
            }
            else
            {
               return  Funcionarios.Where(funcionario => turnos.Contains(funcionario.TurnoTrabalho)).ToList();
            }
            
        }

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {

            return Funcionarios.Where(funcionario =>
            { if ((CalcularIdade(funcionario.DataNascimento)) <= (idade + 5) &&
                    (CalcularIdade(funcionario.DataNascimento)) >=(idade - 5)){
                    return true;

                }
                else { return false; }

            }).ToList();
        }

        private int CalcularIdade(DateTime dataNascimento)
        {
           var idade = (DateTime.Today.Year - dataNascimento.Year);

            if (dataNascimento > DateTime.Today.AddYears(-idade))
            {
                idade--;
            }
            return idade;
        }

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            double soma = 0;
            if (turno == null)
            {
                foreach (var funcionario in Funcionarios)
                {
                    soma+= funcionario.Cargo.Salario;
                }
                return soma / Funcionarios.Count();
            }
            else
            {
                var funcionariosDoMesmoTurno = Funcionarios.Where(funcionario => funcionario.TurnoTrabalho.Equals(turno)).ToList();
                
                foreach (var funcionario in funcionariosDoMesmoTurno)
                {
                    soma+= funcionario.Cargo.Salario;
                    
                }
                return soma / funcionariosDoMesmoTurno.Count(); 
            }
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            return Funcionarios.Where(funcionario => funcionario.DataNascimento.Month == DateTime.Today.Month).ToList();

        }

        public IList<dynamic> BuscaRapida()
        {
            var listaNova = new List<Object> ();
            foreach (var funcionario in Funcionarios)
            {
                listaNova.Add(new  { NomeFuncionario = funcionario.Nome, TituloCargo = funcionario.Cargo.Titulo });
              
            }
            return listaNova;
        }

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {
            var manha = 0;
            var tarde = 0;
            var noite = 0;
            foreach (var funcionario in Funcionarios)
            {
                if (funcionario.TurnoTrabalho.Equals(TurnoTrabalho.Manha)) {
                    manha++;
                }
                if (funcionario.TurnoTrabalho.Equals(TurnoTrabalho.Tarde)) {
                    tarde++;
                }
                if (funcionario.TurnoTrabalho.Equals(TurnoTrabalho.Noite)) {
                    noite++;
                }
            }
            var listaNova = new List<Object>();
            listaNova.Add( new { Turno =TurnoTrabalho.Manha, Quantidade = manha });
            listaNova.Add(new { Turno = TurnoTrabalho.Tarde, Quantidade = tarde });
            listaNova.Add ( new { Turno = TurnoTrabalho.Noite, Quantidade = noite });
            return listaNova;
        }

        public dynamic FuncionarioMaisComplexo()
        {
            object MaiorDeTodos = null;
            var maior = 0;
             foreach (var funcionario in Funcionarios)
            {
                var nome = funcionario.Nome;
                var consoantes = 0;
                for (int i = 0; i < nome.Length; i++)
                {
                    
                    char c = nome.ElementAt(i);

                    if (c != 'a' || c != 'e' || c != 'i' || c != 'o' || c != 'u')
                    {
                        consoantes++;
                    }

                }
                if (consoantes > maior)
                {
                    var QuantidadeMesmoCargoArray = Funcionarios.Where(f => f.Cargo.Titulo.Contains(funcionario.Cargo.Titulo)).ToList();

                    MaiorDeTodos = new
                    {
                        Nome = funcionario.Nome,
                        DataNascimento = funcionario.DataNascimento.ToShortDateString(),
                        SalarioRS =  funcionario.Cargo.Salario.ToString("C", CultureInfo.CurrentCulture),
                        SalarioUS = funcionario.Cargo.Salario.ToString("C", CultureInfo.CreateSpecificCulture("en-US")),
                        QuantidadeMesmoCargo = QuantidadeMesmoCargoArray.Count()
                       };

                }

               
            }

            return MaiorDeTodos;

        }
    }
}