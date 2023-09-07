/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instituto;

/**
 *
 * @author cetecom
 */
public class Asignatura {
    /**
    * 
    * Nombre: Guillermo Adrian Mercado Castillo
    * Asignatura: PGY2121-006V
    * 
    */
    private String codAsig, nombre, estado;
    private double nota1, nota2, nota3, notaPresentacion, notaExamen, notaFinal;
    private Estudiante estudiante;

    public Asignatura(String codAsig, String nombre, String estado, double nota1, double nota2, double nota3, Estudiante estudiante) {
        this.codAsig = codAsig;
        this.nombre = nombre;
        this.estado = estado;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.estudiante = estudiante;
    }

    public Asignatura() {
    }
    
    public String getCodAsig() {
        return codAsig;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public double getNotaPresentacion() {
        return notaPresentacion;
    }

    public double getNotaExamen() {
        return notaExamen;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setCodAsig(String codAsig) {
        this.codAsig = codAsig;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public void setNotaPresentacion(double notaPresentacion) {
        this.notaPresentacion = notaPresentacion;
    }

    public void setNotaExamen(double notaExamen) {
        this.notaExamen = notaExamen;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }
    
    
}
