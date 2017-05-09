/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulariohoja;

import java.util.Date;

/**
 *
 * @author Angie Castañeda
 */
public class Persona {
    
    String nombre;
    String apellido1, apellido2;
    Date fecha;
    int cedula;
    String email;
    String genero;
    Profesion profesion;

    public Persona(String nombre, String apellido1, String apellido2, Date fecha, int cedula, String email, String genero, Profesion profesion) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha = fecha;
        this.cedula = cedula;
        this.email = email;
        this.genero = genero;
        this.profesion = profesion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }
    
    
    
    @Override
    public String toString(){
        return nombre + ";" + apellido1 + ";" + apellido2 + ";" + fecha + ";"+ cedula+ ";" + email + ";" + genero + ";" + profesion + ";";
    }
}
