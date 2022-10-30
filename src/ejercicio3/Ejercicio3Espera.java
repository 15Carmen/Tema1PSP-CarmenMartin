package ejercicio3;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ejercicio3Espera {

    public static void main(String[] args) {
        //Declaramos las variables
        double comienzo = System.currentTimeMillis();   //Variable donde vamos a guardar el tiempo de inicio del programa
        double fin;                                     //Variable donde vamos a guardar el tiempo de finalización del programa

        //Declaramos 5 ProcessBuilder, uno por cada vocal
        ProcessBuilder pb1 = new ProcessBuilder("java","src/ejercicio3/CuentaCaracteres.java","a");
        ProcessBuilder pb2 = new ProcessBuilder("java","src/ejercicio3/CuentaCaracteres.java","e");
        ProcessBuilder pb3 = new ProcessBuilder("java","src/ejercicio3/CuentaCaracteres.java","i");
        ProcessBuilder pb4 = new ProcessBuilder("java","src/ejercicio3/CuentaCaracteres.java","o");
        ProcessBuilder pb5 = new ProcessBuilder("java","src/ejercicio3/CuentaCaracteres.java","u");

        //E indicamos que su E/S por consola
        pb1.inheritIO();
        pb2.inheritIO();
        pb3.inheritIO();
        pb4.inheritIO();
        pb5.inheritIO();

        try {
            //Comenzamos los procesos y esperamos a que termine uno para comenzar el siguiente
            Process p1 = pb1.start();
            p1.waitFor();
            Process p2 = pb2.start();
            p2.waitFor();
            Process p3 = pb3.start();
            p3.waitFor();
            Process p4 = pb4.start();
            p4.waitFor();
            Process p5 = pb5.start();
            p5.waitFor();

        } catch (IOException e) { //Si hay algun problema con los procesos lanzamos un mensaje de error
            System.out.println("Error al lanzar el proceso! Ha habido algun problema de E/S");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error! Se ha interrumpido algun proceso");
            System.out.println(e.getMessage());
        }

        //Marcamos este como el fin del programa y lo guardamos en la variable fin
        fin = System.currentTimeMillis();

        //Imprimimos por consola el tiempo de ejecución total del programa, que es el fin de este menos el comienzo
        System.out.println("El tiempo de ejecucion sin esperas es de " + (fin-comienzo) + " milisegundos");
    }
}

