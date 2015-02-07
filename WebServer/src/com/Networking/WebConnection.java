package com.Networking;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Brettness on 2/6/15.
 */
public class WebConnection implements Runnable {

    private Socket connection;
    private Scanner in;
    private PrintStream out;
    private String firstLine;

    public WebConnection(Socket connection) throws IOException {

        this.connection = connection;
        System.out.println("Local host: "+this.connection.getLocalAddress());
        System.out.println("Local port: "+this.connection.getLocalPort());
        System.out.println("Remote host: "+this.connection.getInetAddress());
        System.out.println("Remote port: "+this.connection.getPort());
        in = new Scanner(connection.getInputStream());
        out = new PrintStream(connection.getOutputStream());

    }

    @Override
    public void run() {

        if(in.hasNextLine()) firstLine = in.nextLine();

        if(isRequest(firstLine)){
            WebRequest request = new WebRequest(firstLine, in);
            WebResponse response = WebRequestHandler.processRequest(request);
            response.send(out);
        }

        while(in.hasNextLine()) {
            String echoText = in.nextLine();
            System.out.println(echoText);
            out.println(echoText);
        }

        try {
            connection.close();
            out.println("Connection Closed!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private boolean isRequest(String input){

        if(input.contains("GET")){
            return true;
        }

        return false;
    }
}
