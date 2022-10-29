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
        String ruta;
        String nombreFichero;

        //Declaramos el scanner par poder leer por consola
        Scanner sc = new Scanner(System.in);

        //Le pedimos al usuario que introduzca la ruta donde quiere crear el fiichero y lo guardamos en la variable previamente declarada
        System.out.println("Introduzca la ruta donde quiere crear el fichero: ");
        ruta=sc.next();

        //Le pedimos al usuario que introduzca el nombre del fichero y lo guardamos en la variable previamente declarada
        System.out.println("Introduzca el nombre del fichero: ");
        nombreFichero=sc.next();

        //Creamos una variable file fichero con los datos introducidos por el usuario
        File fichero = new File(ruta+"\\"+nombreFichero);

        try {
            if (!fichero.exists())
                if (fichero.createNewFile()){                                       //Si se crea el fichero
                    System.out.println("El fichero se ha creado correctamente");    //Imprimimos un mensaje de que se ha creado el fichero con éxito
                }else {                                                             //Si no es el caso
                    System.out.println("El fichero no se ha creado correctamente"); //Imprimimos un mensaje de que se ha creado el fichero con éxito
                }
        } catch (IOException e) {
            e.getMessage();
        }

        //Cerramos el scanner
        sc.close();
    }
}
