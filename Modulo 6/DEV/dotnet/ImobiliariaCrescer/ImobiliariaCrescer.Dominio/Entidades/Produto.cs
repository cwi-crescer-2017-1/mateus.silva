﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ImobiliariaCrescer.Dominio.Entidades
{
    public class Produto
    {
        public int  Id { get; private set; }
        public string Nome { get; private set; }
        public string Tipo { get; private set; }
        public int Quantidade { get; private set; }
        public decimal PrecoDaDiaria { get; private set;}
    }
}
