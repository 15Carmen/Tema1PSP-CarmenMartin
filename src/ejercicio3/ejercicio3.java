package ejercicio3;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ejercicio3 {
    /*
    Crea un programa que cuente las vocales de un fichero de texto que se adjunta a la tarea (fichero_texto.txt). Para
    ello crea una clase que lance la clase CuentaCaracteres.java (se adjunta a la tarea) 5 veces en paralelo, una por
    cada vocal. La clase CuentaCaracteres.java lee el carácter a contar por la línea de argumentos, por lo que habrá
    indicarle el carácter a buscar en el momento de construir el proceso. La salida de todos los procesos debe ser la
    salida estándar, la heredada por el padre.

    Realiza dos ejecuciones, una en la que cada proceso espere al anterior y otra en la que los procesos no se esperen
    entre sí. Cuenta la cantidad de milisegundos que transcurren entre los dos casos. ¿Hay alguna diferencia? Pon cada
    solución en dos clases distintas.

     */
    public static void main(String[] args) {
        File fichero = new File("C:\\ejercicio2\\numLineas.txt");

        String[] comando1 = {"notepad", fichero.getAbsolutePath()};
        String[] comando2 = {"java", "src\\Ej2\\CuentaLineas.java"};

        ProcessBuilder pb1 = new ProcessBuilder(comando1);
        ProcessBuilder pb2 = new ProcessBuilder(comando2);
        // Redirijo los errores al padre (consola)
        pb1.redirectError(ProcessBuilder.Redirect.INHERIT);
        pb2.redirectError(ProcessBuilder.Redirect.INHERIT);

        pb2.redirectInput(fichero);     // Redirijo la entrada al fichero
        pb2.redirectOutput(ProcessBuilder.Redirect.INHERIT);        // Redirijo la salida al padre (consola)

        crearFichero(fichero);

        try {
            Process process1 = pb1.start();     // Inicio el proceso

            if (process1.waitFor(30, TimeUnit.SECONDS)) { // Si el proceso termina antes de 30 segundos
                System.out.print("El fichero " + fichero.getName() + " tiene: ");
                Process process2 = pb2.start();     // Inicio el segundo proceso y espero a que acabe
                process2.waitFor();
                System.out.print(" líneas.");
            } else {
                System.out.println("Ha tardado más de 30 segundos, no se ha lanzado el proceso 2");
            }


        } catch (IOException e) {
            System.out.println("Error en la entrada/salida del proceso");
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Ejecución del proceso interrumpida");
            System.out.println(e.getMessage());
        }
    }

    /***
     * Proceso que, si no existe, crea el arhivo pasado como File por parámetro.
     * Si no existen las carpetas en la ruta, las crea.
     * Si existe el fichero lo borra y lo crea de nuevo.
     * @param file fichero a crear
     */
    private static void crearFichero(File file) {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error en la creación del fichero");
            System.out.println(e.getMessage());
            ;
        }
    }
}

