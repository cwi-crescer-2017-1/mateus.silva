/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.tema3;

import java.io.File;

/**
 *
 * @author Mateus
 */
public interface SQLUtils {
    void runFile(String filename);

    String executeQuery(String query);
    
    void importCSV(File file);
    
    File importCSV(String query);

}