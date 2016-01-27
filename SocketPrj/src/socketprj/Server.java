/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprj;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author Dima
 */
public class Server {
    public static final int PORT = 4446;
    public static void main (String [] args) throws IOException
    {
        new Server().runServer();
    }
    public void runServer() throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server up & ready for connections...");
        while (true)
        {
            Socket socket = serverSocket.accept();
            new ServerThread(socket).start();
        }
        
    }
}
