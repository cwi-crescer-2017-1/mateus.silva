package br.com.crescer.aula1.tema;


import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateus
 */
public class ManipuladorDeDatas implements CalendarUtils{
    
   public  DiaSemana diaSemana(Date date){
      Calendar calendar = Calendar.getInstance(); 
      calendar.setTime(date);
      return DiaSemana.values()[calendar.get(Calendar.DAY_OF_WEEK)-1];
   }

   public  String tempoDecorrido(Date date){
      Calendar data = Calendar.getInstance(); 
      data.setTime(date);
      Calendar hoje = Calendar.getInstance(); 
      hoje.setTime(new Date());
      
      int ano = hoje.get(Calendar.YEAR) -data.get(Calendar.YEAR);
      int mes = hoje.get(Calendar.MONTH) -data.get(Calendar.MONTH);
      int dia = hoje.get(Calendar.DATE) -data.get(Calendar.DATE);
   return Math.abs(ano) +" ano(s), " + Math.abs(mes) + " mes(es) e " +  Math.abs(dia) + " dia(s)";
   }
}
