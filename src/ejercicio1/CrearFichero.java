package ejercicio1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

    /*
    Si elige crear un fichero, debo pedirle también la ruta donde quiere crearlo
    y el nombre del fichero
     */

public class CrearFichero {


    public static void main(String[] args) {

        //Declaramos las variables
        String ruta;            //Variable donde vamos a guardar la ruta introducida por el usuario
        String nombreFichero;   //Variable donde vamos a guardar el nombre del fichero introducido por el usuario
        String[] comando;       //Variable donde vamos a hacer el comando para crear el fichero con los datos introducidos por el usuario

        //Declaramos el scanner par poder leer por consola
        Scanner sc = new Scanner(System.in);

        //Le pedimos al usuario que introduzca la ruta donde quiere crear el fiichero y lo guardamos en la variable previamente declarada
        System.out.println("Introduzca la ruta donde quiere crear el fichero: ");
        ruta=sc.next();

        //Le pedimos al usuario que introduzca el nombre del fichero y lo guardamos en la variable previamente declarada
        System.out.println("Introduzca el nombre del fichero: ");
        nombreFichero=sc.next();

        //Con los datos introducidos por el usuario creamos el comando para crear el fichero
        comando = new String[]{"cmd", "/C", "type", "nul", ">", ruta+"\\"+nombreFichero};

        //Declaramos un ProcessBuilder y le pasamos el comando que acabamos de hacer
        ProcessBuilder processBuilder = new ProcessBuilder(comando);
        processBuilder.inheritIO();

        try {
            Process process = processBuilder.start();       //Iniciamos el proceso
            System.out.println("Fichero creado con exito"); //Imprimimos un mensaje confirmando la creación del fichero
            process.waitFor();                              //Y esperamos a que el proceso acabe
        } catch (IOException e) {                           //Si el proceso falla lanzamos un mensaje de error
            System.out.println("Error! No se ha podido crear el fichero");
        } catch (InterruptedException e) {
            System.out.println("Error! Se ha interrumpido el proceso, no se ha podido crear el fichero");
        }

        //Cerramos el scanner
        sc.close();
    }
}
