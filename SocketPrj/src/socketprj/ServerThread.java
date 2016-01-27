/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Dima
 */
public class ServerThread extends Thread {
    Socket socket;
    ServerThread(Socket socket)
    {
        this.socket = socket;
    }
    public void run ()
    {
        try
        {
            String message = null;
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("user '" + bufferedReader.readLine()+"' is now connected to the server.");
            while ((message = bufferedReader.readLine()) != null)
            {
                System.out.println("Incoming client message: " + message);
                printWriter.println("Server echoing Client message==> "+message);
            }
            socket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}













