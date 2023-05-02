package co.uniquindio.pg2.CentroImpresionMiguelMira.util;
import java.io.*;
import co.uniquindio.pg2.CentroImpresionMiguelMira.model.CentroImpresion;

public class SerializacionUtil {
    public static void serializarCentroImpresion(CentroImpresion centroImpresion, String archivo) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(archivo))) {
            outputStream.writeObject(centroImpresion);
            System.out.println("Centro de impresión serializado exitosamente en " + archivo);
        } catch (IOException e) {
            System.out.println("Error al serializar el centro de impresión: " + e.getMessage());
        }
    }

    public static CentroImpresion deserializarCentroImpresion(String archivo) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(archivo))) {
            CentroImpresion centroImpresion = (CentroImpresion) inputStream.readObject();
            System.out.println("Centro de impresión deserializado exitosamente desde " + archivo);
            return centroImpresion;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al deserializar el centro de impresión: " + e.getMessage());
            return null;
        }
    }
}
