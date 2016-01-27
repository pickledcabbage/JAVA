/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package socketwithobjectprj;

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
    Database db;
    int number;
    public ServerThread (Socket socket, Database db, int number)
    {
        this.socket = socket;
        this.db = db;
        this.number = number;
    }
    public void run()
    {
        Message message = null;
        try
        {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream()); // DO NOT FLIP THESE !!! <-- TRIPLE EXCLAMATION IMPORTANCE LEVEL: HELLAx2
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            System.out.println("User #" + number + " is now connected...");
            while (true)
            {
                message = (Message)objectInputStream.readObject();
                
                if (message != null)
                {
                    //System.out.println("Sweet!");
                    doSomething(message);
                    if(message.getRequest().getFirst() != 1)
                    {
                        //System.out.println("wow");
                        objectOutputStream.writeObject(message);
                    }
                        
                }
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
    private void doSomething(Message message)
    {
        if (message.getRequest().getFirst() == 1)
        {
            handleMovement(message);
        }
        else if (message.getRequest().getFirst() == 2)
        {
            handleLocations(message);
        }
    }
    public void handleMovement(Message message)
    {
        db.movePlayer(number,message.getRequest().getSecond());
    }
    public void handleLocations(Message message)
    {
        message.setReply(db.getPlayerLocations());
    }
}
