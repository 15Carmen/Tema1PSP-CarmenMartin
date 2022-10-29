package ejercicio1;

import java.io.File;
import java.util.Scanner;

    /*
    Si elige crear una carpeta, debo pedirle también la ruta donde quiere crearla
    y el nombre de la carpeta
     */
public class CrearCarpeta {

    public static void main(String[] args) {

        //Declaramos las variables
        String ruta;
        String nombreCarpeta;

        //Declaramos el scanner par poder leer por consola
        Scanner sc = new Scanner(System.in);

        //Le pedimos al usuario que introduzca la ruta donde quiere crear la carpeta y la guardamos en la variable previamente declarada
        System.out.println("Introduzca la ruta donde quiere crear la carpeta: ");
        ruta = sc.next();

        //Le pedimos al usuario que introduzca el nombre de la carpeta y lo guardamos en la variable previamente declarada
        System.out.println("Introduzca el nombre de la carpeta: ");
        nombreCarpeta = sc.next();

        //Creamos una variable file directorio con los datos introducidos por el usuario
        File directorio = new File(ruta + "\\" + nombreCarpeta);

        if (!directorio.exists()) {                                 //Si el directorio no existe
            if (directorio.mkdirs()) {                              //Si se crea el directorio
                System.out.println("Directorio creado");            //Imprimimos un mensaje de que se ha creado el directorio con éxito
            } else {                                                //Si no se crea el directorio
                System.out.println("Error al crear directorio");    //Imoprimimos un mensaje de error al crear el directorio
            }
        }

        //Cerramos el scanner
        sc.close();
    }
}
