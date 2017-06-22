package br.com.crescer.aula1.tema;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mateus
 */
import java.text.Normalizer;

public class ManipuladorDeString implements StringUtils {

    public boolean isEmpty(String string) {
        if ( string == null|| string.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public String inverter(String string) {
        if (isEmpty(string)) {
            return string;
        }
        return new StringBuilder(string).reverse().toString();
    }

    ;
    
    public int contaVogais(String string) {
        int contador = 0;
        string = Normalizer
                .normalize(string, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "").toLowerCase();

        char[] letras = string.toCharArray();
        for (char l : letras) {
            switch (l) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    contador++;
            }
        }
        return contador;
    }

    public boolean isPalindromo(String string) {
        String[] frase = (string).split(" ");
        String palavra = String.join("", frase);
        palavra = Normalizer
                .normalize(palavra, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");
        if (palavra.compareToIgnoreCase(inverter(palavra)) == 0) {
            return true;
        }
        return false;

    }
}
