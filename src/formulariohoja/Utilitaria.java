/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulariohoja;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Angie Castañeda
 */
public class Utilitaria {
    
    private Date fecha;
    private static final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    /*public Utilidad(){
        
        fecha = new Date();
        System.out.println(fecha);
        String fechaS = formato.format(fecha);
        System.out.println(fechaS);
        Date fecha2;
        
        try{
            fecha2 = formato.parse(fechaS);
            System.out.println(fecha2);
        } catch (ParseException ex){
            Logger.getLogger(Utilidad.class.getName()).log(Level.SEVERE,null,ex);
        }
    }*/
    
   
    public static String FechaRecibe(Date fecha){
        
        String fechaS = formato.format(fecha);
        
        return (fechaS);
        
    }
    
    public static Date FechaDevuelve(String fecha) {
        Date fechaDate = new Date();
        try {
            fechaDate = formato.parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(Utilitaria.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fechaDate;
        
    }
    
    public static void Escribe(String direccion, String persona) throws IOException{
        
        Writer fichero = new FileWriter(direccion, true);
        PrintWriter pw = new PrintWriter(fichero);
        pw.println(persona);
        pw.close();
        
    }
    
    public static String Lee(String direccion) throws IOException{
        
        FileReader fr = new FileReader (direccion);
        BufferedReader br = new BufferedReader(fr);

         // Lectura del fichero         
         String linea;
         StringBuilder cualquiera = new StringBuilder();
         while((linea=br.readLine())!=null) {
             cualquiera.append(linea + "\n");
         }
         fr.close();
        return cualquiera.toString();
        
    }
    
    
}
