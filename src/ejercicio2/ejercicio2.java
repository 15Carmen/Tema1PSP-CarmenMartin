package ejercicio2;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ejercicio2 {

    //Declaramos un file fichero que es el que vamos a abrir con el block de notas
    private static final File FICHERO = new File("C:\\ejercicio2\\numLineas.txt");
    //Declaramos un file carpeta con la ruta donde vamos a guardar el fichero
    private static final File CARPETA = new File("C:\\ejercicio2");

    public static void main(String[] args) {
        //Primero llamamos al metodo que acabamos de crear para crear tanto la carpeta como el fichero
        crearCarpetaFichero();
        //Por ultimo llamamos al metodo que ejecuta los procesos 1 y 2
        procesos();
    }

    /*
     * Método para crear la carpeta ejercicio2 y el fichero numLineas.txt si todavía no existe, pero que si existe el fichero
     * lo borre para que no haya ningún problema con el que estamos creando en el main
     */
    private static void crearCarpetaFichero() {
        try {
            if(!CARPETA.exists()){          //Si la carpeta o el fichero no existe
                CARPETA.mkdir();            //La creamos
                FICHERO.createNewFile();    //Y creamos un nuevo fichero en ella
            }
            if (FICHERO.exists()){          //Si hay un fichero ya existente
                FICHERO.delete();           //Lo borramos
                FICHERO.createNewFile();    //Y nos creamos uno nuevo
            }
        }catch (IOException e) {            //Si el método falla lanzamos un mensaje de error
            System.out.println("Error al lanzar el proceso! Ha habido algun problema de E/S");
            System.out.println(e.getMessage());
        }
    }

    public static void procesos(){

        //Declaramos los comandos para hacer parte de los procesos 1 y 2
        String[] comando1 = {"notepad", String.valueOf(FICHERO)};           //Variable donde guardamos el comando para abrir el fichero en el block de notas
        String[] comando2 = {"java", "src/ejercicio2/CuentaLineas.java"};   //Variable donde guardamos el comando para llamar a la clase CuentaLineas

        //Declaramos 2 ProcessBuilder y les pasamos los dos comandos creados previamente
        ProcessBuilder pb1 = new ProcessBuilder(comando1);
        ProcessBuilder pb2 = new ProcessBuilder(comando2);

        // El proceso 2 debe redireccionar la entrada estándar de forma que ésta sea el fichero numLineas.txt creado por el
        //Proceso 1. La salida estándar y la de error del Proceso 2 deben redirigirse hacia las del proceso padre (es decir,
        //la consola).
        pb2.redirectInput(FICHERO);                                 //Redirijo la entrada del proceso2 al fichero
        pb2.redirectOutput(ProcessBuilder.Redirect.INHERIT);        //Redirijo la salida del proceso2 a la consola
        pb2.redirectError(ProcessBuilder.Redirect.INHERIT);         //Redirijo los errores del proceso2 a la consola

        try {
            /*
            El usuario debe escribir en el block de notas una serie de líneas. Cuando termine de escribir, guardará el
            fichero y cerrará el bloc de notas.
             */
            Process proceso1 = pb1.start();                           //Iniciamos el proceso1

            /*
            El Proceso 2 debe esperar a que el Proceso 1 termine para así poder leer del fichero, pero si el Proceso 1 tarda
            más de 30 segundos en terminar, se debe de terminar la ejecución del proceso, mostrando el mensaje de error
            correspondiente.
            */
            if (proceso1.waitFor(30, TimeUnit.SECONDS)) {   //Si el proceso termina antes de 30 segundos
                Process proceso2 = pb2.start();                       //Iniciamos el proceso2
                proceso2.waitFor();                                   //Y esperamos a que acabe
            } else {                                                  //Si no es el caso, el proceso termina después de que pasen 30 segundos y se lanza un mensaje de error
                System.out.println("Ha tardado más de 30 segundos, no se ha lanzado el proceso 2");
            }


        } catch (IOException e) {                                     //Si el proceso falla lanzamos un mensaje de error
            System.out.println("Error al lanzar el proceso! Ha habido algun problema de E/S");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Error! Se ha interrumpido algun proceso");
            System.out.println(e.getMessage());
        }
    }
}

