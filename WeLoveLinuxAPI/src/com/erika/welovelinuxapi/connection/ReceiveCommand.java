package com.erika.welovelinuxapi.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ReceiveCommand  {

	private static ServerSocket server;
    private static int port = 8888;

    public String receiveCmd() throws IOException, ClassNotFoundException{

        server = new ServerSocket(port);
        String message = null;

        while(true){
            System.out.println("Waiting for client request");

            Socket socket = server.accept();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            message = (String) ois.readObject();
            System.out.println("Message Received: " + message);
            ois.close();

            socket.close();

            if(message != null) break;
        }
        System.out.println("Shutting down Socket server!!");
        server.close();

        return message;
    }

}
