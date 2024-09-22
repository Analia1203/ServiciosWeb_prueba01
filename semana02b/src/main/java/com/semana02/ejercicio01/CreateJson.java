package com.semana02.ejercicio01;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class CreateJson {

    public static void main(String[] args) {
        
        Auto auto1 = new Auto(1, "Toyota");
        Auto auto2 = new Auto(2, "Nissan");
        Auto auto3 = new Auto(3, "Hyundai");

        ArrayList<Auto> autos = new ArrayList<Auto>();
        autos.add(auto1);
        autos.add(auto2);
        autos.add(auto3);

        System.out.println(autos);

        FileWriter fileWriter  = null;
        try {
            //Leer el archivo
            File file = new File("D:/CLASES ANALIA/VI CICLO/01-DESARROLLO DE SERVICIOS WEB/FILE/Auto_FiestasG1.json");
            fileWriter = new FileWriter(file);

            // Convertir el objeto a JSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(autos, fileWriter);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
