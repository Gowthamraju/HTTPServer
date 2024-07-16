package com.httpserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLOutput;

public class SimpleHttpServer {

    public static void main(String args[]) throws IOException {
        ServerSocket port = new ServerSocket(9000);
        while (true) {
            Socket socket = port.accept();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            String name = "";
            String email = "";
            while (true) {
                String firstLine = reader.readLine();


                System.out.println(firstLine);
                if (firstLine.contains("GET")) {
                    int startIndex = firstLine.indexOf("/") + 1;
                    int endIndex = firstLine.indexOf(" HTTP");

                    name = firstLine.substring(startIndex, endIndex);
                    email = "Gowtham@gmail.com";
                }
                
                if (firstLine.equals("")){
                    break;
                    }
            }
            
            Employee employee = new Employee(name, email);
            String crlf = "\r\n";
            writer.print("HTTP/1.1 200 OK" + crlf);
            writer.print("Content-type: application/json" + crlf);
            writer.println("Content-Length:" + employee.toString().length() + crlf);
            writer.print(employee.toString());
            writer.flush();
            writer.close();

        }
    }
}
