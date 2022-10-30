package ejercicio1;

import java.io.IOException;
import java.util.Scanner;

    /*
    Si elige crear una carpeta, debo pedirle también la ruta donde quiere crearla
    y el nombre de la carpeta
     */
public class CrearCarpeta {

    public static void main(String[] args) {

        //Declaramos las variables
        String ruta;            //Variable donde vamos a guardar la ruta introducida por el usuario
        String nombreCarpeta;   //Variable donde vamos a guardar el nombre de la carpeta introducido por el usuario
        String[] comando;       //Variable donde vamos a hacer el comando para crear el directorio con los datos introducidos por el usuario

        //Declaramos el scanner par poder leer por consola
        Scanner sc = new Scanner(System.in);

        //Le pedimos al usuario que introduzca la ruta donde quiere crear la carpeta y la guardamos en la variable previamente declarada
        System.out.println("Introduzca la ruta donde quiere crear la carpeta: ");
        ruta = sc.next();

        //Le pedimos al usuario que introduzca el nombre de la carpeta y lo guardamos en la variable previamente declarada
        System.out.println("Introduzca el nombre de la carpeta: ");
        nombreCarpeta = sc.next();

        //Con los datos introducidos por el usuario creamos el comando para crear la carpeta
        comando= new String[]{"cmd", "/C", "md", ruta+"\\"+nombreCarpeta};

        //Declaramos un ProcessBuilder y le pasamos el comando que acabamos de hacer
        ProcessBuilder processBuilder = new ProcessBuilder(comando);
        processBuilder.inheritIO();

        try {
            Process process = processBuilder.start();       //Iniciamos el proceso
            process.waitFor();                              //Y esperamos a que el proceso acabe
        } catch (IOException e) {                           //Si el proceso falla lanzamos un mensaje de error
            System.out.println("Error! No se ha podido crear la carpeta");
        } catch (InterruptedException e) {
            System.out.println("Error! Se ha interrumpido el proceso, no se ha podido crear la carpeta");
        }

        //Cerramos el scanner
        sc.close();
    }
}
