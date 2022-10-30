package ejercicio1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

    /*
    Si elige mostrar un directorio, debo pedirle también la ruta del directorio a
    mostrar. Si lo deja vacío, debo mostrar el contenido del directorio actual
     */

public class MostrarDirectorio {
    public static void main(String[] args) {
        //Declaramos las variables
        String ruta;        //Variable donde vamos a guardar la ruta introducida por el usuario
        String[] comando;   //Variable donde vamos a hacer el comando para mostrar el contenido del directorio con los datos introducidos por el usuario

        //Declaramos el scanner par poder leer por consola
        Scanner sc = new Scanner(System.in);

        //Le pedimos al usuario que introduzca la ruta del directo que quiere consultar y lo guardamos en la variable ruta
        System.out.print("Ingrese la ruta del directorio que ver: ");
        ruta = sc.nextLine();

        //Con los datos introducidos por el usuario creamos el comando para ver los datos del directorio
        comando = new String[]{"cmd", "/C", "DIR", ruta};

        //Declaramos un ProcessBuilder y le pasamos el comando que acabamos de hacer
        ProcessBuilder processBuilder = new ProcessBuilder(comando);
        processBuilder.inheritIO();

        try {
            Process process = processBuilder.start();       //Iniciamos el proceso
            process.waitFor();                              //Y esperamos a que el proceso acabe
        } catch (IOException e) {                           //Si el proceso falla lanzamos un mensaje de error
            System.out.println("Error! No se ha podido mostrar el directorio");
        } catch (InterruptedException e) {
            System.out.println("Error! Se ha interrumpido el proceso, no se ha podido mostrar el directorio");
        }

        //Cerramos el scanner
        sc.close();
    }
}
