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
    public ServerThread (Socket socket)
    {
        this.socket = socket;
    }
    public void run()
    {
        Message message = null;
        try
        {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream()); // DO NOT FLIP THESE !!! <-- TRIPLE EXCLAMATION IMPORTANCE LEVEL: HELLAx2
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            String username = (String)objectInputStream.readObject();
            System.out.println(username + " is now connected...");
            while ((message = (Message)objectInputStream.readObject()) != null)
            {
                doSomething(message);
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
    private void doSomething(Message message)
    {
        message.setResult(message.getFirstNumber().intValue()*message.getSecondNumber().intValue());
    }
}
