
package Reporte;

import Inspeccion.Inspeccion;
import Inspeccion.InspeccionManager;
import java.io.*;
import java.util.*;

public class Reporte {

    public static void generarReporte() {
        List<Inspeccion> inspecciones = InspeccionManager.leerInspeccionesDesdeCSV("C:\\Users\\USUARIO\\Downloads\\Libro1.csv");
        
        if (inspecciones.isEmpty()) {
            System.out.println("No hay inspecciones registradas para generar el reporte.");
            return;
        }

        // Imprimir el reporte
        System.out.println("\nREPORTE DE INSPECCIONES:");
        System.out.println("Código | Fecha | Estado | Comentario");
        
        for (Inspeccion inspeccion : inspecciones) {
            System.out.println(inspeccion.getCodigo() + " | " + inspeccion.getFecha() + " | " + inspeccion.getEstado() + " | " + inspeccion.getComentario());
        }

        // Preguntar si desea exportar el reporte
        System.out.println("\n¿Desea exportar el reporte a un archivo CSV?");
        System.out.println("1. Sí");
        System.out.println("2. No");

        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            exportarReporte(inspecciones);
        }
    }

    private static void exportarReporte(List<Inspeccion> inspecciones) {
        try (FileWriter writer = new FileWriter("reporte_inspecciones.csv")) {
            writer.append("Código,Fecha,Estado,Comentario\n");

            for (Inspeccion inspeccion : inspecciones) {
                writer.append(inspeccion.getCodigo() + "," + inspeccion.getFecha() + "," + inspeccion.getEstado() + "," + inspeccion.getComentario() + "\n");
            }
            System.out.println("Reporte exportado a 'reporte_inspecciones.csv'");
        } catch (IOException e) {
            System.err.println("Error al exportar el reporte: " + e.getMessage());
        }
    }
}
