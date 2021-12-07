package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(27015);
        Socket client = server.accept();

        System.out.println("Client "+client.getInetAddress());

        PrintWriter send = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        send.println("Welcome to hell!");
        send.flush();

        BufferedReader getFromUser = new BufferedReader(new InputStreamReader(client.getInputStream()));
        while (true){
            String mes = getFromUser.readLine();

            if (mes == null)
                break;
            else{
                System.out.println("Message from user = " + mes);
            }

        }

    }
}
