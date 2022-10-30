package ejercicio2;

import java.util.Scanner;

public class CuentaLineas {
    /*
    La clase CuentaLineas.java debe leer de la entrada estándar una serie de líneas (no sabemos cuántas) y devolver
    el número de líneas que ha leído.
     */
    public static void main(String[] args) {

        //Declaramos las variables
        int numLineas = 0;  //Variable donde vamos a guardar el numero de lineas que el programa cuente

        //Declaramos el scanner para poder leer por consola
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {      // Mientras haya una línea
            numLineas++;                //Incrementamos en 1 la variable numLineas
            sc.nextLine();              // Paso a la siguiente línea
        }

        //Imprimimos el numero total de líneas contabilizadas
        System.out.print("El fichero tiene "+numLineas+" lineas");

        //Cerramos el scanner
        sc.close();
    }
}
