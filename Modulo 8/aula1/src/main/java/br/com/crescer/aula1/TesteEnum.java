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
public class TesteEnum {

    public static void main(String[] args) {
        StringBuffer var = new StringBuffer();
        
        for (Estados e : Estados.values()) {
            var.append(e.getNome()).append(", ");
        }
        
       // for (int i = 0; i < Estados.values().length; i++) {
      //      var.append(Estados.values()[i].getNome() + " , ");
       // }

        System.out.println(var);
    }
}
