/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package socketwithobjectprj;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dima
 */
public class Server {
    public static final int PORT = 4447;
    private Database db;
    public static void main (String [] args) throws IOException, ClassNotFoundException
    {
        new Server().runServer();
    }
    public Server()
    {
        db = new Database();
    }
    public void runServer() throws IOException, ClassNotFoundException
    {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server up & ready for connections...");
        int number = 0;
        while (true)
        {
            Socket socket = serverSocket.accept();
            db.addPlayer();
            new ServerThread(socket,db,number).start();
            number++;
        }
        
    }
    
}
