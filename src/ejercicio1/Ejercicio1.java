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
            case 1 -> lanzarCrearCarpeta();
            case 2 -> lanzarCrearFichero();
            case 3 -> lanzarMostrarDirectorio();
            default -> System.out.println("La opcion introducida no es valida");
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

    //Metodo para lanzar la clase CrearCarpeta
    public static void lanzarCrearCarpeta(){

        //Declaramos la variable comando donde guardamos la ruta de la clase
        String[] comando = {"java", "src/ejercicio1/CrearCarpeta.java"};

        //Declaramos el ProcessBuilder y le pasamos el comando que acabamos de crear
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.inheritIO();

        try {
            Process p = pb.start();                         //Iniciamos el proceso
            p.waitFor();                                    //Y esperamos a que acabe
        } catch (IOException | InterruptedException e) {    //Si el proceso falla lanzamos un mensaje de error
            System.out.println("Error al lanzar el proceso!");
        }
    }

    //Metodo para lanzar la clase CrearFichero
    public static void lanzarCrearFichero(){

        //Declaramos la variable comando donde guardamos la ruta de la clase
        String[] comando = {"java", "src/ejercicio1/CrearFichero.java"};

        //Declaramos el ProcessBuilder y le pasamos el comando que acabamos de crear
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.inheritIO();

        try {
            Process p = pb.start();                         //Iniciamos el proceso
            p.waitFor();                                    //Y esperamos a que acabe
        } catch (IOException | InterruptedException e) {    //Si el proceso falla lanzamos un mensaje de error
            System.out.println("Error al lanzar el proceso!");
        }
    }

    //Metodo para lanzar la clase MostrarDirectorio
    public static void lanzarMostrarDirectorio(){

        //Declaramos la variable comando donde guardamos la ruta de la clase
        String[] comando = {"java", "src/ejercicio1/MostrarDirectorio.java"};

        //Declaramos el ProcessBuilder y le pasamos el comando que acabamos de crear
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.inheritIO();

        try {
            Process p = pb.start();                         //Iniciamos el proceso
            p.waitFor();                                    //Y esperamos a que acabe
        } catch (IOException | InterruptedException e) {    //Si el proceso falla lanzamos un mensaje de error
            System.out.println("Error al lanzar el proceso!");
        }
    }

}