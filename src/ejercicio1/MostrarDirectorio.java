package ejercicio1;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

    /*
    Si elige mostrar un directorio, debo pedirle también la ruta del directorio a
    mostrar. Si lo deja vacío, debo mostrar el contenido del directorio actual
     */

public class MostrarDirectorio {
    public static void main(String[] args) {
        //Declaramos las variables
        String rutaDirectorio;

        //Declaramos el scanner par poder leer por consola
        Scanner sc = new Scanner(System.in);

        //Le pedimos al usuario que introduzca la ruta del directorio que desea ver y lo guardamos en la variable previamente declarada
        System.out.println("Introduzca la ruta del directorio que desea ver");
        rutaDirectorio = sc.nextLine();

        if (rutaDirectorio == null || rutaDirectorio.equals("")) { //Si la ruta introducida es igual a null o no se ha introducido nada
            File directorio = new File("C:/");          //Creamos una variable file directorio que muestre el directorio actual
            String[] lista = directorio.list();                   //Creamos un array lista donde guardaremos los datos del directorio
            Arrays.sort(lista);                                   //Ordenamos la lista
            System.out.println("Este es el contenido del directorio actual: ");
            for (int i = 0; i < lista.length; i++) {
                System.out.println(lista[i]);                     //Imprimimos la lista
            }
        } else {                                                  //Si introduce una ruta
            File directorio = new File(rutaDirectorio);           //Creamos una variable file directorio con la ruta introducida por el usuario
            String[] lista = directorio.list();                   //Creamos un array lista donde guardaremos los datos del directorio
            Arrays.sort(lista);                                   //Ordenamos la lista
            for (int i = 0; i < lista.length; i++) {
                System.out.println(lista[i]);                     //Imprimimos la lista
            }
        }

        //Cerramos el scanner
        sc.close();
    }
}
