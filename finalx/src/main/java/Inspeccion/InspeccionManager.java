
package Inspeccion;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class InspeccionManager {

    public static void gestionarInspecciones() {
        List<Inspeccion> inspecciones = leerInspeccionesDesdeCSV("C:\\Users\\USUARIO\\Downloads\\Libro1.csv");
        
        if (inspecciones.isEmpty()) {
            System.out.println("No hay inspecciones registradas.");
            return;
        }

        // Mostrar todas las inspecciones
        System.out.println("\nINSPECCIONES REGISTRADAS:");
        for (Inspeccion inspeccion : inspecciones) {
            System.out.println(inspeccion.getCodigo() + " | " + inspeccion.getFecha() + " | " + inspeccion.getEstado() + " | " + inspeccion.getComentario());
        }
    }

    public static List<Inspeccion> leerInspeccionesDesdeCSV(String archivoCSV) {
        List<Inspeccion> inspecciones = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoCSV))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(";");
                if (datos.length >= 4) { // Asegurarse de que hay suficientes datos
                    String codigo = datos[0].trim(); // Suponiendo que el código está en la primera columna
                    String fecha = datos[1].trim(); // Suponiendo que la fecha está en la segunda columna
                    String estado = datos[2].trim(); // Suponiendo que el estado está en la tercera columna
                    String comentario = datos[3].trim(); // Suponiendo que el comentario está en la cuarta columna
                    inspecciones.add(new Inspeccion(codigo, fecha, estado, comentario));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        return inspecciones;
    }

    public void cargarArchivo(String direccion) {
        List<String> lineas = new ArrayList<>();

        try {
            Path ruta = Paths.get(direccion);

            Stream<String> flujoFormateado = Files.lines(ruta, Charset.forName("UTF-8")); // Cargando el archivo plano
            flujoFormateado.forEach(lineas::add); // Almacenando todos los elementos para su análisis

            System.out.println("Líneas guardadas: " + lineas.size());
        } catch (IOException ex) {
            Logger.getLogger(Inspeccion.class.getName()).log(Level.SEVERE, null, ex);
            
            
        }
    }
}

