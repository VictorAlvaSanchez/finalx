/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Login {

    public static Usuario validarLogin() {
        Scanner scanner = new Scanner(System.in);
        int intentos = 0;
        boolean acceso = false;
        Usuario usuario = null;

        while (intentos < 3 && !acceso) {
            System.out.print("Ingrese el nombre de usuario: ");
            String nombreUsuario = scanner.nextLine();
            System.out.print("Ingrese la contraseña: ");
            String contrasena = scanner.nextLine();

            // Verificar las credenciales en el archivo usuarios.txt
            usuario = leerUsuarioDesdeArchivo(nombreUsuario, contrasena);

            if (usuario != null) {
                acceso = true;
                System.out.println("Acceso permitido.");
            } else {
                intentos++;
                System.out.println("Credenciales incorrectas. Intento " + intentos + " de 3.");
            }
        }

        if (!acceso) {
            System.out.println("Acceso denegado.");
            return null;
        }

        return usuario;
    }

    private static Usuario leerUsuarioDesdeArchivo(String nombreUsuario, String contrasena) {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\USUARIO\\Documents\\NetBeansProjects\\tallerprogramacion\\final1\\src\\main\\resources\\usuarios.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos[0].equals(nombreUsuario) && datos[1].equals(contrasena)) {
                    return new Usuario(datos[0], datos[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }
        return null;
    }
}
