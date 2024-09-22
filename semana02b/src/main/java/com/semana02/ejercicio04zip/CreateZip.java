package com.semana02.ejercicio04zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZip {
    public static void main(String[] args) {
        String[] files = { "D:/CLASES ANALIA/VI CICLO/01-DESARROLLO DE SERVICIOS WEB/FILE/Auto_FiestasG1.json",
        "D:/CLASES ANALIA/VI CICLO/01-DESARROLLO DE SERVICIOS WEB/FILE/Clientes_FiestasG1.xml",
        "D:/CLASES ANALIA/VI CICLO/01-DESARROLLO DE SERVICIOS WEB/FILE/Productos_FiestasG1.xlsx" };

        try {
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream("D:/CLASES ANALIA/VI CICLO/01-DESARROLLO DE SERVICIOS WEB/FILE/comprimido_G1.zip"));
            for (String ruta : files) {
                System.out.println("Agregando archivo: " + ruta);

                //crear un archivo
                File file = new File(ruta);
                FileInputStream fis = new FileInputStream(file);
                
                //Crear un archivo en el zip
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipOut.putNextEntry(zipEntry);

                //Escribir el contenido del archivo
                int byteLeidos = 0;
                while( (byteLeidos = fis.read()) != -1){
                    zipOut.write(byteLeidos);
                }
                
                fis.close();
                zipOut.closeEntry();
            }
            zipOut.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
