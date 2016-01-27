/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Dima
 */
public class ServerThread extends Thread {
    Socket socket = null;
    String username;
    int number;
    Database database;
    public ServerThread (Socket socket,int n,Database db)
    {
        this.socket = socket;
        number = n;
        database = db;
    }
    public void run()
    {
        Message message = null;
        try
        {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream()); // DO NOT FLIP THESE !!! <-- TRIPLE EXCLAMATION IMPORTANCE LEVEL: HELLAx2
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            //message = new Message("Enter your username: ", 99);
            //objectOutputStream.writeObject(message);
            //String username = ((Message)objectInputStream.readObject()).getChat();
            //message = (Message)objectInputStream.readObject();
            //System.out.println("["+number+"]"+username + " is now connected...");
            username = "Person#" + number + "";
            while (true)
            {
                message = (Message)objectInputStream.readObject();
                //System.out.println("Nice");
                database.distribute(number, message.getChat(),username);
                if (database.isMail(number))
                    message = new Message(database.recieve(number));
                else
                    message = new Message();
                objectOutputStream.writeObject(message);
                //socket.close();
            }
            
            
            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
    }
}
