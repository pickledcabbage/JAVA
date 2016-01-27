/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;

/**
 *
 * @author Dima
 */
public class Server {
    public static void main (String [] args)
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(4445);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = bufferedReader.readLine();
            System.out.println("the following message was recieved from Client: " + message);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("Server echoing back the following message: '" + message+"' from Client");
        }
        catch (IOException e)
        {
            System.out.println("exception "+ e);
            System.exit(0);
        }
    }
}
