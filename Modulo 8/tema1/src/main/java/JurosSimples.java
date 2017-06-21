
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
         
        HashMap<String, BigDecimal> bd_map = new HashMap<>();
        
        BigDecimal valor = valorParcelar.divide(new BigDecimal (numeroParcelas)).multiply( new BigDecimal (1 + taxaJuros));        
        int contador =1;
        
        Calendar data = Calendar.getInstance(); 
        DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
        data.setTime(dataPrimeiroVencimento);
        
        while (contador<=numeroParcelas)  {
            data.add(Calendar.DATE,30);
            String date  = dateformat.format(data.getTime());
            bd_map.put(contador+". " + date + " - R$ ",  valor.setScale(2, BigDecimal.ROUND_HALF_UP));
            contador++;   
        }
        return bd_map;    
     }
}
