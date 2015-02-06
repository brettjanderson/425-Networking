package com.Networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private ServerSocket listener;

    public static void main(String[] args){

        WebServer server = new WebServer(8080);
        server.run();

    }

    public WebServer(int port){

        try{
            listener = new ServerSocket(port);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public void run(){
        try {

            while(true){
                System.out.println("Listening");
                Socket connection = listener.accept();
                System.out.println("Accepted Connection");
                (new Thread(new WebConnection(connection))).start();
            }

        } catch(IOException e){
            e.printStackTrace();
        }
    }

}