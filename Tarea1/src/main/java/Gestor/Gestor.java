package Gestor;
import java.io.FileWriter;
import java.nio.file.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Sebastian
 */
public class Gestor {

    public static void main(String[] args) {
        boolean bandera = true;
        int opcion = 0;
        while (bandera) {
            try {
                Scanner teclado = new Scanner(System.in);
                System.out.println("Seleccione una opcion: ");
                System.out.println("1. Leer un archivo");
                System.out.println("2. Agregar linea de texto");
                System.out.println("3. Salir del menu");
                opcion = teclado.nextInt();
            } catch (Exception e) {
                System.out.println("El caracter ingresado no es numerico.");
            }
            switch (opcion) {
                case 1:
                     System.out.println(leerArchivo("C:\\Users\\Sebastian\\Documents\\NetBeansProjects\\Tarea1\\texto.txt"));
                    break;
                case 2:
                    System.out.println(agregarTexto("C:\\Users\\Sebastian\\Documents\\NetBeansProjects\\Tarea1\\textoPrueba.txt"));
                    break;
                case 3:
                    bandera = false;
                    break;

            }
        }
    }

    public static String agregarTexto(String ruta) {//agrega una linea de texto al final de un archivo .txt, devolviendo todo el contenido nuevo del texto
        try {
            FileWriter archivo = new FileWriter(ruta, true);
            PrintWriter texto = new PrintWriter(archivo);
            texto.println("The first man who stepped on the moon.");
            texto.close();
        } catch (IOException e) {
            System.out.println("Error al agregar el texto");
        }

        return leerArchivo(ruta);   
    }

    public static String leerArchivo(String ruta) {//lee el archivo de la ruta especificada y retorna el texto contenido

        Path archivo = Paths.get(ruta);
        String texto = "";
        try {
            texto = new String(Files.readAllBytes(archivo));
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser leido");
        }
        return texto;
    }
       
   
   }

