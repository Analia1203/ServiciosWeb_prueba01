package com.semana02.ejercicio5Lab2;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class serverZipCatalogo {
      public static void main(String[] args) {
        new serverZipCatalogo();
    }

    private final int PORT = 13;

    public serverZipCatalogo() {
        System.out.println("1 Server started");
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("2 Server waiting for client");
            while(true){
                Socket socket = server.accept();
                System.out.println("3 Client connected");
    
                //Flujos para recibir archivos
                DataInputStream entrada = new DataInputStream(socket.getInputStream());
                FileOutputStream fos = new FileOutputStream("D:/CLASES ANALIA/VI CICLO/01-DESARROLLO DE SERVICIOS WEB/SERVER/catalogoComprimido.zip");
    
                //recibir archivo
                int byteLeidos = 0;
                while ((byteLeidos = entrada.read()) != -1) {
                    fos.write(byteLeidos);
                }
                System.out.println("4 File received");
    
                fos.close();
                entrada.close();
                System.out.println("5 Server finished");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
