﻿using ImobiliariaCrescer.Dominio.Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Infraestrutura.Repositorios
{
    public class ClienteRepositorio : IDisposable
    {
        private Contexto contexto = new Contexto();

        public dynamic Obter()
        {
            return contexto.Clientes.ToList();
        }

        public dynamic ObterPorID(int id)
        {
            return contexto.Clientes.FirstOrDefault(x => x.Id == id);
        }

        public void Criar (Cliente cliente)
        {
            contexto.Clientes.Add(cliente);
            contexto.SaveChanges();
        }
        public bool VerificarCpf(string Cpf)
        {
            var array=  contexto.Clientes.Where(x => x.Cpf.Contains(Cpf));
            if (array.Count() > 0)
            {
                return true;

            }
            else
            {
                return false;
            }
        }
        
        
        public void Dispose()
        {
            contexto.Dispose();
        }
    }
}

