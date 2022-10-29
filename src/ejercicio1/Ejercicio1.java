package ejercicio1;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {
    /*
    Crea un programa que muestre un menú al usuario como el siguiente:
        Elija qué comando desea ejecutar:
        1. Crear carpeta
        2. Crear fichero
        3. Mostrar contenido del directorio
    Atendiendo a la opción seleccionada por el usuario, el programa debe lanzar un proceso u otro. Toma de base el archivo
    ejercicio1.Ejercicio1.java que se adjunta a la tarea.

     */

    //Declaramos el scanner para poder leer por consola
    public static Scanner sc = new Scanner (System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int opc = pintarMenu();

        // Según la opción introducida debemos lanzar un proceso u otro.
        // Todos los procesos son comandos de Windows, por lo que deben comenzar con cmd

        switch (opc) {

            case 1:
                lanzarProceso1();
                break;

            case 2:
                lanzarProceso2();
                break;

            case 3:
                lanzarProceso3();
                break;
            default:
                System.out.println("La opcion introducida no es correcta");
        }
    }

    public static int pintarMenu() {
        // En opc guardaremos la opción seleccionada por el usuario
        int opc;

        // Imprimimos el menú con las diversas opciones
        System.out.println("Elija que comando desea ejecutar:");
        System.out.println("1. Crear carpeta");
        System.out.println("2. Crear fichero");
        System.out.println("3. Mostrar contenido del directorio");

        // Leemos la opción de teclado
        opc = sc.nextInt();

        return opc;
    }

    public static void lanzarProceso1(){
        String[] comando = {"java", "src/ejercicio1/CrearCarpeta.java"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.inheritIO();

        try {
            Process p = pb.start();
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void lanzarProceso2(){
        String[] comando = {"java", "src/ejercicio1/CrearFichero.java"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.inheritIO();

        try {
            Process p = pb.start();
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void lanzarProceso3(){
        String[] comando = {"java", "src/ejercicio1/MostrarDirectorio.java"};
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.inheritIO();

        try {
            Process p = pb.start();
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}