/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mateus
 */
import static com.sun.org.apache.xml.internal.resolver.helpers.PublicId.normalize;
import java.text.Normalizer;
public class ManipuladorDeString  implements StringUtils{
    
    
    public boolean isEmpty(String string){
        if (string.isEmpty() && string ==null){
             return true;
        }
          return false;
    }
    public String inverter(String string){ 
        if (isEmpty(string)){
          return string;
        }
         return new StringBuilder(string).reverse().toString();
    };
    
    public int contaVogais(String string){
       int contador =0;
       if (string.contains("a")){
           contador++;
       }
       if ( string.contains("e")){
           contador++;
       }
        if (string.contains("o")){
           contador++;
       }
       if (string.contains("i")){
           contador++;
       }
       if( string.contains("u")){
           contador++;
       }
      return contador;
        
    }
    
    public boolean isPalindromo(String string){
      String[] frase = (string).split(" ");
      String palavra = String.join("", frase);
      palavra = Normalizer
      .normalize(palavra, Normalizer.Form.NFD)
      .replaceAll("[^\\p{ASCII}]", "");
      if ( palavra.compareToIgnoreCase(inverter(palavra))==0){
           return true;
        }
      return false;

    }
}
