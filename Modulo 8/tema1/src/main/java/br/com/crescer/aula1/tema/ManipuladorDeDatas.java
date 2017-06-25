package br.com.crescer.aula1.tema;


import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
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
    
   private static final Calendar CALENDAR = Calendar.getInstance();
   private static final String TEMPLATE = "%s ano(s), %s messe(s) e %s dia(s)";
   
   public  DiaSemana diaSemana(Date date){
      Calendar calendar = Calendar.getInstance(); 
      calendar.setTime(date);
      return DiaSemana.values()[calendar.get(Calendar.DAY_OF_WEEK)-1];
   }

   public  String tempoDecorrido(Date date){
      Calendar data = Calendar.getInstance();  
      data.setTime(date);
      data.set(data.get(YEAR), data.get(MONTH), data.get(DAY_OF_MONTH),0,0,0);
      
      Calendar hoje = Calendar.getInstance(); 
      hoje.setTime(new Date());
      hoje.set(hoje.get(YEAR), hoje.get(MONTH), hoje.get(DAY_OF_MONTH),0,0,0);

      CALENDAR.setTime(new Date(hoje.getTime().getTime()- data.getTime().getTime()));
      return String.format(TEMPLATE, (CALENDAR.get(YEAR) - 1970), CALENDAR.get(MONTH), CALENDAR.get(DAY_OF_MONTH));
   }
}