/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1;

/**
 *
 * @author mateus.silva
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
public class NovoClass {
 public static void main (String []args) throws ParseException{
   StringBuffer var = new StringBuffer();
    
    List <String> lista = new ArrayList <String>  ();
     for (Estados e : Estados.values()) {
         lista.add(e.getNome());
       }
     Collections.sort(lista);
     for (String l : lista) {
        var.append(l).append(", ");
       }
      System.out.println(var);
      
      //-----------------------------------
      
     
      Scanner input = new Scanner (System.in);
      System.out.println("Digite uma data  no formato dd/MM/yyyy");
      SimpleDateFormat simpleDateFormat;
      simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
      Calendar cal = Calendar.getInstance();
      String  data = input.nextLine();
      cal.setTime(simpleDateFormat.parse(data));
      System.out.println("Informe os dias");
      int dias = input.nextInt();  
      cal.add(Calendar.DATE, dias);
       System.out.println(cal.getTime());
   
    }
      
      
}
