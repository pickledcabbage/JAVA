/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketwithobjectprj;

import java.io.IOException;
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
        Integer firstNumber = 5; //Integer.decode(args[0]);
        Integer secondNumber = 2; //Integer.decode(args[1]);
        Socket socket = new Socket("25.7.67.65", PORT); // 25.6.251.126
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        Message message = new Message(firstNumber,secondNumber);
        objectOutputStream.writeObject(message);
        Message returnMessage = (Message)objectInputStream.readObject();
        System.out.println(returnMessage.getResult());
        socket.close();
    }
}
