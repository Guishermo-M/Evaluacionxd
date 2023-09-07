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
public class Instituto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * 
         * Nombre: Guillermo Adrian Mercado Castillo
         * Asignatura: PGY2121-006V
         * 
         */
        String opcion;
        int opcionInt = 0;
        boolean val = true;
        Estudiante estudiante = new Estudiante();
        Asignatura asignatura = new Asignatura();
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("\n-----Sistema---Notas---Final-----");
            System.out.println("1.- Ingresar Estudiante");
            System.out.println("2.- Ingresar Asignatura");
            System.out.println("3.- Calcular Nota Presentacion y si esta eximido");
            System.out.println("4.- Ingresar Nota Examen y calcular estado final alumno");
            System.out.println("5.- Salir");
            System.out.print("Ingresar opcion: ");
            do {
                opcion = entrada.nextLine();
                if (!opcion.isEmpty()) {
                    try {
                        opcionInt = Integer.parseInt(opcion);
                        if (opcionInt >= 1 && opcionInt <= 5) {
                            val = true;
                        } else {
                            System.out.println("La opción ingresada no es válida (Debe ser entre 1 y 5)");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Opción invalida! Ingrese una opcion entre 1 y 5");
                    }
                }
            } while (!val);
            
            switch (opcionInt) {
                case 1:
                    ingresarEstudiante(estudiante);
                    break;
                case 2:
                    ingresarAsignatura(asignatura, estudiante);
                    break;
                case 3:
                    calcularNotaPresentacion(asignatura, estudiante);
                    break;
                case 4:
                    calcularEstadoFinalAlumno(asignatura, estudiante);
                    break;
            }
        } while (opcionInt != 5);
        entrada.close();
    }
    
    public static void ingresarEstudiante(Estudiante estudiante){
        Scanner entrada = new Scanner(System.in);
        boolean asig = false;
        String rutStr, nombre, edad;
        char dv = '\0';
        int edadInt = 0,rutInt=0;
        System.out.println("");
        do {
            System.out.print("Ingrese solo el RUT sin Digito Verificador: ");
            rutStr = entrada.nextLine();
            
            // el sgte codigo elimina los puntos y cualquier espacio en blanco del rut ingresado
            rutStr = rutStr.replace(".", "").replaceAll("\\s", "");
            
            // el sgte "if" valida que el RUT tenga solo dígitos numericos y no sea minimo 7 y maximo 8 caracteres
            if (rutStr.matches("\\d+") && rutStr.length() <= 8 &&rutStr.length()>=7) {
                
                // Convertir el RUT a un número entero
                rutInt = Integer.parseInt(rutStr);
                asig=true;
            } else {
                System.out.println("El RUT ingresado no es válido.");
            }
        }while(!asig);
        asig=false;
        
        // EL sgte "do" valida que el dv ingresado no este vacio y sea solo un caracter
        do {
            System.out.print("DV estudiante (solo un dígito): ");
            String input = entrada.nextLine();

            if (input.length() == 1 && (Character.isLetter(input.charAt(0)) || Character.isDigit(input.charAt(0)))) {
                dv = input.charAt(0);
                asig = true;
            }else {
            System.out.println("El DV ingresado no es válido.");
            }
        }while(!asig);
        asig=false;
        
        //El sgte do valida que el nombre del estudiante no este vacio
        do{
            System.out.print("Nombre estudiante:");
            nombre = entrada.nextLine();
            if (!nombre.isEmpty()){
                asig = true;
            }
        }while(!asig);
        asig = false;
        
        //el sgte do valida que la edad del estudiante sea un numero y que este entre 18 y 100
        do{
            System.out.print("Edad estudiante:");
            edad = entrada.nextLine();
            if (!edad.isEmpty()){
                try {
                    edadInt = Integer.parseInt(edad);
                    if (edadInt >=18 && edadInt<100){
                        asig = true;
                    }
                    else{
                        System.out.println("La edad ingresada no es válida (Debe ser entre 18 y 100)");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("La edad debe ser un numero y debe ser entero!!!!!");
                }
            }
        }while(!asig);
        
        //Una vez validado todo asigna las variables a los atributos correspondientes
        estudiante.setRut(rutInt);
        estudiante.setDv(dv);
        estudiante.setNombre(nombre);
        estudiante.setEdad(edadInt);    
    }
    
    public static void ingresarAsignatura(Asignatura asignatura, Estudiante estudiante){
        Scanner entrada = new Scanner(System.in);
        String codAsig, nombreAsignatura, nota;
        double nota1 = 0, nota2 = 0, nota3 = 0;
        boolean validar = false;
        System.out.println("");
        
        //valida que el codigo de la asignatura no este vacio
        do{
            System.out.print("Codigo Asignatura:");
            codAsig = entrada.nextLine();
            if (!codAsig.isEmpty()){
                validar = true;
            }
        }while(!validar);
        validar = false;
        
        //valida que el nombre de la asignatura no este vacio
        do{
            System.out.print("Nombre Asignatura:");
            nombreAsignatura = entrada.nextLine();
            if (!codAsig.isEmpty()){
                validar = true;
            }
        }while(!validar);
        validar = false;
        
        // los sgtes 3 "Do" validan que las notas ingresadas sean numeros entre 1.0 y 7.0
        do{
            System.out.print("Ingrese la 1era nota de "+nombreAsignatura+":  (ejemplo: 4.0)");
            nota = entrada.nextLine();
            if (!nota.isEmpty()){
                try {
                    nota1 = Double.parseDouble(nota);
                    if (nota1 >=1.0 && nota1<=7.0){
                        validar = true;
                    }
                    else{
                        System.out.println("La nota ingresada debe ser entre 1.0 y 7.0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("La nota ingresada debe ser un numero");
                }
            }
        }while(!validar);
        validar=false;
        
        do{
            System.out.print("Ingrese la 2da nota de "+nombreAsignatura+":  (ejemplo: 4.0)");
            nota = entrada.nextLine();
            if (!nota.isEmpty()){
                try {
                    nota2 = Double.parseDouble(nota);
                    if (nota2 >=1.0 && nota2<=7.0){
                        validar = true;
                    }
                    else{
                        System.out.println("La nota ingresada debe ser entre 1.0 y 7.0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("La nota ingresada debe ser un numero");
                }
            }
        }while(!validar);
        validar = false;
        
        do{
            System.out.print("Ingrese la 3era nota de "+nombreAsignatura+":  (ejemplo: 4.0)");
            nota = entrada.nextLine();
            if (!nota.isEmpty()){
                try {
                    nota3 = Double.parseDouble(nota);
                    if (nota3 >=1.0 && nota3<=7.0){
                        validar = true;
                    }
                    else{
                        System.out.println("La nota ingresada debe ser entre 1.0 y 7.0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("La nota ingresada debe ser un numero");
                }
            }
        }while(!validar);
        asignatura.setCodAsig(codAsig);
        asignatura.setNombre(nombreAsignatura);
        //la sgte parte redondea las notas a 1 decimal
        nota1 =Math.round(nota1 * 10.0) / 10.0;
        nota2 =Math.round(nota2 * 10.0) / 10.0;
        nota3 =Math.round(nota3 * 10.0) / 10.0;
        // la sgte parte asigna las notas redondeadas a la asignatura
        asignatura.setNota1(nota1);
        asignatura.setNota2(nota2);
        asignatura.setNota3(nota3);
    }
    
    public static void calcularNotaPresentacion(Asignatura asignatura,Estudiante estudiante){
        double notaPresentacion;
        //calculo de la nota de Presentacion NP=n1*0.3  + n2*0.3 + n3*0,4
        notaPresentacion = asignatura.getNota1()*0.3 + asignatura.getNota2()*0.3 + asignatura.getNota3()*0.4;
        //redondea la nota de Presentacion a 1 decimal
        notaPresentacion = Math.round(notaPresentacion * 10.0) / 10.0;
        //lo sgte verifica si el estudiante esta eximido o no
        if (notaPresentacion >= 5.0){
            asignatura.setNotaPresentacion(notaPresentacion);
            asignatura.setNotaExamen(notaPresentacion);
            asignatura.setNotaFinal(notaPresentacion);
            asignatura.setEstado("Eximido");
            System.out.println("");
            System.out.println("-----Inicio-del-Calculo-de-Nota-de-Presentacion-----");
            System.out.println("Nota de Presentacion: "+asignatura.getNotaPresentacion());
            System.out.println("El Estudiante SI se encuentra Eximido");
            System.out.println("-----Fin-del-Calculo-de-Nota-de-Presentacion-----");
            System.out.println("");
            Instituto.mostrarEstado(estudiante, asignatura);
        }else{
            asignatura.setNotaPresentacion(notaPresentacion);
            System.out.println("");
            System.out.println("-----Inicio-del-Calculo-de-Nota-de-Presentacion-----");
            System.out.println("Nota de Presentacion: "+asignatura.getNotaPresentacion());
            System.out.println("El Estudiante NO se encuentra Eximido");
            System.out.println("Considere ingresar nota de examen para conocer el estado final del alumno");
            System.out.println("-----Fin-del-Calculo-de-Nota-de-Presentacion-----");
            System.out.println("");
        }
    }
    
    public static void calcularEstadoFinalAlumno(Asignatura asignatura, Estudiante estudiante){
        double notaExamen=0,notaFinal;
        String nota;
        boolean validar = false;
        Scanner entrada = new Scanner(System.in);
        do{
            System.out.print("Ingrese la nota de Examen de "+asignatura.getNombre()+":  (ejemplo: 4.0)");
            nota = entrada.nextLine();
            if (!nota.isEmpty()){
                try {
                    notaExamen = Double.parseDouble(nota);
                    notaExamen = Math.round(notaExamen * 10.0) / 10.0;
                    if (notaExamen >=1.0 && notaExamen<=7.0){
                        validar = true;
                    }
                    else{
                        System.out.println("La nota ingresada debe ser entre 1.0 y 7.0");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("La nota ingresada debe ser un numero");
                }
            }
        }while(!validar);
        asignatura.setNotaExamen(notaExamen);
        notaFinal = notaExamen*0.4+asignatura.getNotaPresentacion()*0.6;
        asignatura.setNotaFinal(Math.round(notaFinal * 10.0) / 10.0);
        if(asignatura.getNotaFinal()>=4.0){
            asignatura.setEstado("Aprobado");
            Instituto.mostrarEstado(estudiante, asignatura);
        }else{
            asignatura.setEstado("Reprobado");
            Instituto.mostrarEstado(estudiante, asignatura);
        }
    }
    public static void mostrarEstado(Estudiante estudiante, Asignatura asignatura){
        System.out.println("");
        System.out.println("-----Inicio-Estado-Final-del-Alumno-----");
        System.out.println("Codigo Asignatura: "+asignatura.getCodAsig());
        System.out.println("Nombre Asignatura: "+asignatura.getNombre());
        System.out.println("Nombre Estudiante: "+estudiante.getNombre());
        System.out.println("Nota 1: "+asignatura.getNota1());
        System.out.println("Nota 2: "+asignatura.getNota2());
        System.out.println("Nota 3: "+asignatura.getNota3());
        System.out.println("Nota Presentacion: "+asignatura.getNotaPresentacion());
        System.out.println("Nota Examen: "+asignatura.getNotaExamen());
        System.out.println("Nota Final: "+asignatura.getNotaFinal());
        System.out.println("Estado Alumno: "+asignatura.getEstado());
        System.out.println("-----Fin-Estado-Final-del-Alumno-----");
        System.out.println("");
    }
}
