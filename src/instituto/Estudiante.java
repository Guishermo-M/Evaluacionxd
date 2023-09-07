/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto;

import java.util.Scanner;

/**
 *
 * @author cetecom
 */
public class Estudiante {
    /**
    * 
    * Nombre: Guillermo Adrian Mercado Castillo
    * Asignatura: PGY2121-006V
    * 
    */
    Scanner scanner = new Scanner(System.in);
    private int edad, rut;
    private char dv;
    private String nombre;

    public Estudiante(int rut, int edad, char dv, String nombre) {
        this.rut = rut;
        this.dv = dv;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Estudiante() {
               
    }

    public int getRut() {
        return rut;
    }

    public int getEdad() {
        return edad;
    }

    public char getDv() {
        return dv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
