package ejercicio3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CuentaCaracteres {

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

    private final static String RUTA_FICHERO = "src/ejercicio3/texto_largo.txt";

    public static void main(String[] args) {
        try {
            // El carácter a contar lo tomo de la línea de argumentos.
            // Me quedo con el primero de los argumentos, que debe ser el carácter a buscar.
            String caracter = args[0];

            // En numCaracteres llevaré la cuenta del carácter que se ha introducido por argumentos
            int numCaracteres = 0;

            // En caracterLeido guardaré cada carácter leído del texto
            String caracterLeido;

            // caracterNumero es el carácter leído en formato número
            int caracterNumero;

            // Abro para su lectura el fichero texto_largo.txt
            FileReader fr = new FileReader(RUTA_FICHERO);

            // Mientras siga habiendo caracteres para leer
            caracterNumero = fr.read();
            while (caracterNumero != -1) {
                // Paso todos los caracteres a minúscula para facilitar la comparación
                caracterLeido = String.valueOf((char) caracterNumero).toLowerCase();

                // Cada vez que encuentre al carácter sumo 1 al contador
                if(caracterLeido.equals(caracter)) {
                    numCaracteres++;
                }
                caracterNumero = fr.read();
            }

            System.out.println("El caracter " + caracter + " aparece " + numCaracteres + " veces.");

            fr.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se ha encontrado el fichero especificado");
        } catch (IOException e) {
            System.err.println("Se ha producido un error durante la lectura del fichero");
            e.printStackTrace();
        }
    }
}

