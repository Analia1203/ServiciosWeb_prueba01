package com.semana02.ejercicio5Lab1;

import java.net.Socket;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;


public class ClienteZipPais {

    public static void main(String[] args) {
        new ClienteZipPais();
    }

    private final int PORT = 13;
    private final String HOST = "localhost";


    public ClienteZipPais(){
        //PASO 1 Generar los archivos
        System.out.println("1 Generando archivos JSON, XML y ZIP");
        GenerateZipPais generateZipPais = new GenerateZipPais();
        generateZipPais.procesar();
        

        //PASO 2 Crear el Socket CLiente
        try {
            System.out.println("2 Client started");
            Socket socket = new Socket(HOST, PORT);
            System.out.println("3 Connected to server");

            //PASO 3 Enviar el archivo ZIP
            //Fllujos para enviar y recibir archivos
            File file = new File("D:/CLASES ANALIA/VI CICLO/01-DESARROLLO DE SERVICIOS WEB/FILE/paisComprimido.zip");
            FileInputStream fis = new FileInputStream(file);
            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            
            //enviar archivo
            int byteLeidos = 0;
            while ((byteLeidos = fis.read()) != -1) {
                salida.write(byteLeidos);
            }
            System.out.println("3 File sent");
            fis.close();
            salida.close();
            System.out.println("4 Client finished");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }    



    }
}