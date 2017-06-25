package br.com.crescer.aula1.tema;

import java.math.RoundingMode;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.math.RoundingMode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateus
 */
public class JurosSimples implements Parcelator{
    

  public   Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento){ 
          
        Map<String, BigDecimal> map = new LinkedHashMap<>();
        
        BigDecimal multiplicador  = new BigDecimal (1 + taxaJuros/100);
        BigDecimal valorDaParcela = valorParcelar.multiply(multiplicador).divide(new BigDecimal (numeroParcelas)).setScale(2, BigDecimal.ROUND_HALF_UP);         
        BigDecimal resto = valorDaParcela.multiply(new BigDecimal(numeroParcelas)).subtract(valorParcelar.multiply(multiplicador));
        
        int contador =1; 
        
        Calendar data = Calendar.getInstance();  
        DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy"); 
        data.setTime(dataPrimeiroVencimento); 
        
        while (contador<=numeroParcelas)  {
            map.put(dateformat.format(data.getTime()) , valorDaParcela.setScale(2, BigDecimal.ROUND_HALF_UP));         
            contador++;
            data.add(Calendar.MONTH,1);    
            if (contador == numeroParcelas) {
                valorDaParcela =  valorDaParcela.subtract(resto);
            }
        }
        return map;
    }
  }
  