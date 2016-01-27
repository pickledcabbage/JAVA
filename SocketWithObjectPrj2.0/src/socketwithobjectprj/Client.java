/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package socketwithobjectprj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Dima
 */
public class Client {
    public static final int PORT = 4447;
    public static void main (String [] args) throws IOException, ClassNotFoundException
    {
        if (args.length == 1)
        {
            String name = args[0];
        Integer firstNumber = 4; //Integer.decode(args[0]);
        Integer secondNumber = 5; //Integer.decode(args[1]);
        Socket socket = new Socket("localhost", PORT); // 25.6.251.126
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());// DO NOT FLIP THESE !!! <-- TRIPLE EXCLAMATION IMPORTANCE LEVEL: HELLAx2
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        objectOutputStream.writeObject(name);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String readerInput = bufferedReader.readLine();
            String[] readerInputTokens = readerInput.split("\u0020");
            Message message = new Message(Integer.decode(readerInputTokens[0]),Integer.decode(readerInputTokens[1]));
            objectOutputStream.writeObject(message);
            Message returnMessage = (Message)objectInputStream.readObject();
            System.out.println(returnMessage.getResult());
            //socket.close();
        }
        }
        else
        {
            System.out.println("Usage: Client <name> ");
        }
        
        
    }
}
