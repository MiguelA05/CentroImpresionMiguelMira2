package co.uniquindio.pg2.CentroImpresionMiguelMira.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        // Creamos un objeto File para el archivo .txt
        File archivo = new File("usuarios.txt");
        // Declaramos un objeto BufferedReader para leer el archivo
        BufferedReader br = null;
        try {
            // Inicializamos el BufferedReader con un FileReader
            br = new BufferedReader(new FileReader(archivo));
            // Declaramos una variable para almacenar cada línea del archivo
            String linea;
            // Leemos el archivo mientras haya líneas que leer
            while ((linea = br.readLine()) != null) {
                // Separamos los atributos de la línea por #
                String[] atributos = linea.split("#");
                // Mostramos los atributos por consola
                System.out.println("ID: " + atributos[0]);
                System.out.println("Pass: " + atributos[1]);
                System.out.println("TD: " + atributos[2]);
                System.out.println("Saldo: " + atributos[3]);
                System.out.println("-----------------");
            }
        } catch (IOException e) {
            // Capturamos la excepción en caso de error
            e.printStackTrace();
        } finally {
            // Cerramos el BufferedReader si no es nulo
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
