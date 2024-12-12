/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Auditoria;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Auditoria {

    public static void registrarError(String mensajeError) {
        try (FileWriter writer = new FileWriter("auditoria.log", true)) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            writer.append("[" + timestamp + "] ERROR: " + mensajeError + "\n");
        } catch (IOException e) {
            System.err.println("Error al registrar la auditoría: " + e.getMessage());
        }
    }
}
