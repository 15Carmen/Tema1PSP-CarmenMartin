package ejercicios.ejercicio1;

import java.util.Scanner;

public class Ejercicio1 {
    /*
    Crea un programa que muestre un menú al usuario como el siguiente:
        Elija qué comando desea ejecutar:
        1. Crear carpeta
        2. Crear fichero
        3. Mostrar contenido del directorio
    Atendiendo a la opción seleccionada por el usuario, el programa debe lanzar un proceso u otro. Toma de base el archivo Ejercicio1.java que se adjunta a la tarea.

     */

    public static void main(String[] args) {
        menu();

    }

    public static void menu(){
        int opc = pintarMenu();

        // Según la opción introducida debemos lanzar un proceso u otro.
        // Todos los procesos son comandos de Windows, por lo que deben comenzar con cmd

        switch (opc) {
            // Si elige crear una carpeta, debo pedirle también la ruta donde quiere crearla
            // y el nombre de la carpeta
            case 1:
                break;
            // Si elige crear un fichero, debo pedirle también la ruta donde quiere crearlo
            // y el nombre del fichero
            case 2:
                break;
            // Si elige mostrar un directorio, debo pedirle también la ruta del directorio a
            // mostrar. Si lo deja vacío, debo mostrar el contenido del directorio actual
            case 3:
                break;
            default:
                System.out.println("La opcion introducida no es correcta");
        }
    }

    public static int pintarMenu() {
        // En opc guardaremos la opciÃ³n seleccionada por el usuario
        int opc;
        Scanner sc = new Scanner(System.in);

        // Imprimimos el menÃº con las diversas opciones
        System.out.println("Elija que comando desea ejecutar:");
        System.out.println("1. Crear carpeta");
        System.out.println("2. Crear fichero");
        System.out.println("3. Mostrar contenido del directorio");

        // Leemos la opciÃ³n de teclado
        opc = sc.nextInt();
        sc.close();

        return opc;
    }

    public static void crearCarpeta(){

    }

}