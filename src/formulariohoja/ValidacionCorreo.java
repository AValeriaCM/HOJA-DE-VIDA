/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulariohoja;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Angie Castañeda
 */
public class ValidacionCorreo {
        
    /*Inicializa variable privada mensaje*/
    
    private String mensaje;
    int color;
    /**
    *Constructor de la clase
    * @param emailA
    */
    
        public ValidacionCorreo(String emailA){
            // El email a validar
            
            String email = emailA;
            
            // Patrón para validar el email
            Pattern pattern = Pattern.compile("^([^0-9!@#$%^&*/])+([\\w-][^!@#$%^&*/])+");
            
            Matcher mather = pattern.matcher(email);
            
            if (mather.find() == true) {
               color = 1;
               mensaje = "Email válido.";
               
               Pattern pattern1 = Pattern.compile(".*@");
            
               Matcher mather1 = pattern1.matcher(email);
            
                if (mather1.find() == true) {
                    color = 1;
                    mensaje = "Email válido.";
                    
                    Pattern pattern2 = Pattern.compile(".*@([^0-9!@#$%^&*/])+[A-Za-z-][^!@#$%^&*/]+(\\.[A-Za-z][^!@#$%^&*/]+)");
            
                    Matcher mather2 = pattern2.matcher(email);
            
                    if (mather2.find() == true) {
                        color = 1;
                      mensaje = "Email válido.";
                      
                      Pattern pattern3 = Pattern.compile(".*@([^0-9!@#$%^&*/])[A-Za-z-]+(\\.[A-Za-z][^!@#$%^&*/]+)*(\\.[A-Za-z][^!@#$%^&*/]{2,})$");
            
                      Matcher mather3 = pattern3.matcher(email);
            
                      if (mather3.find() == true) {
                          color = 2;
                           mensaje = "Email válido.";
               
                      } else {
                          color = 0;
                          mensaje = "Dominio inválido.";
                                     
                      }
               
                    } else {
                        color = 0;
                    mensaje = "Nombre de empresa o institucion inválido.";
            
                  }
                } else {
                    color = 0;
                mensaje = "Falta caracter '@'";
            
                }
               
            } else {
                
            mensaje = "Caracteres inválidos.";
            
            }
  
        }

    /**
    *Metodo que retorna
    * @return mensaje
    */
        
    public String getMensaje() {
        return mensaje;
    }
    /**
    *Metodo que modifica
     * @param mensaje
    */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    /**
    *Metodo que retorna
    * @return color
    */
    public int getColor() {
        return color;
    }
    /**
    *Metodo que modifica
     * @param color
    */

    public void setColor(int color) {
        this.color = color;
    }

 }

