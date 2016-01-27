/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package socketwithobjectprj;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author Dima
 */
public class Client extends JFrame {
    // Server Components
    public static final int PORT = 4447;
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;
    JFrame frame;
    JTextArea enter;
    JTextArea show;
    String cache;

    public Client()
    {
        frame = new JFrame();
        frame.setTitle("Chat Client");
        frame.setSize(300,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        enter = new JTextArea();
        enter.setRows(1);
        enter.setEditable(false);
        enter.setLocation(0, 475);
        frame.add(enter);
        System.out.println(enter.getRows());
        
        frame.setVisible(true);
        cache = "";
    }
    public static void main (String [] args) throws IOException, ClassNotFoundException, InterruptedException
    {
        Client wow = new Client();
        wow.runChat();
    }
    public void runChat() throws IOException, ClassNotFoundException, InterruptedException
    {
        Socket socket = new Socket("127.0.0.1", PORT); // 25.6.251.126
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());// DO NOT FLIP THESE !!! <-- TRIPLE EXCLAMATION IMPORTANCE LEVEL: HELLAx2
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        Message message = new Message();
        //Message message = (Message)objectInputStream.readObject();
        //System.out.print(message.getChat());
        //Scanner keyboard = new Scanner(System.in);
        //message = new Message(keyboard.nextLine(),99);
        //objectOutputStream.writeObject(message);
        InputThread input = new InputThread();
        input.start();
        while (true)
        {
            
            if (input.getNew())
                message = new Message(input.getChat());
            else
                message = new Message();
            input.resetChat();
            //System.out.println("wow");
            objectOutputStream.writeObject(message);
            //System.out.println("Nice");
            Message returnMessage = (Message)objectInputStream.readObject();
            if (!returnMessage.isBlank())
                System.out.println(returnMessage.getChat());
            //Thread.sleep(50);
        } 
    }
}
