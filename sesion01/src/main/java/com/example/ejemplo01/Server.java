package com.example.ejemplo01;

import java.net.Socket;

public class Server {
     try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("1 > Server started alt port" + PORT);

            
            System.out.println("2 > Closing connection...");
            socket.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }

}
