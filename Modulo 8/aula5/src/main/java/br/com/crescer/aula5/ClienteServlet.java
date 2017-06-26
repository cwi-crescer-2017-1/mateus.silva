/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula5;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mateus.silva
 */
public class ClienteServlet extends HttpServlet {
    
    private Set<String> clientes = new HashSet<>();// não adiciona strings repetidas. 
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
                
        
       try(final PrintWriter out = resp.getWriter();){
            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");
            out.append("<title>Java - aula5</title>");
            out.append("<meta charset=\"UTF-8\">");
            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.append("</head>");
            out.append("<body>");
            out.append("<form>");
            out.append("<input type= 'text' name='oi' >");
            out.append("<input type='submit' value='enviar'/>");
            out.append("</form>"); 
            out.append("</body>");
            out.append("</html>");
            
        }
    }
   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse  resp)  throws ServletException, IOException {
           
       try(final PrintWriter out = resp.getWriter();){
     
       }
     //  resp.sendRedirect(location);
       }
        
    }
