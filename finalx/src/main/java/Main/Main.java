/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;


import Inspeccion.InspeccionManager;
import Reporte.Reporte;
import Usuario.Login;
import Usuario.Usuario;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Intento de login
        Usuario usuario = Login.validarLogin();
        if (usuario == null) {
            System.out.println("Acceso denegado. Fin del programa.");
            return;
        }

        // Menú principal
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("1. Gestión de Inspecciones");
            System.out.println("2. Reportes");
            System.out.println("3. Salir");
            System.out.print("Ingrese opción [1-3]: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                    InspeccionManager.gestionarInspecciones();
                    break;
                case 2:
                    Reporte.generarReporte();
                    break;
                case 3:
                    System.out.println("Fin del programa.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        
        scanner.close();
    }
}
