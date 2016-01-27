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

/**
 *
 * @author Dima
 */
public class Client extends JFrame {
    public static final int PORT = 4447;
    int GAMEWIDTH = 1028;
    int GAMEHEIGHT = 796;
    int REFRESH_SPEED = 1;
    int moveDirection;
    boolean moving;
    private Image dbImage;
    private Graphics dbg;
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;
    JFrame frame;
    int[][] currentLocations;
    int playerNumber;
    Image grasstile;
    Image hero1;
    Image hero2;
    Image notFound;
    public Client()
    {
        grasstile = importImage("grass1.png");
        hero1 = importImage("red.png");
        hero2 = importImage("JokuK8K.png");
        notFound = importImage("NotFound.png");
        moving = false;
        moveDirection = 0;
        addKeyListener(new AL());
        addMouseListener(new Mouse());
        
        setTitle("SteamPunkDND or something we'll figure out later");
        setSize(GAMEWIDTH,GAMEHEIGHT);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        currentLocations = new int[1][3];
    }
    public static void main (String [] args) throws IOException, ClassNotFoundException, InterruptedException
    {
        Client wow = new Client();
        wow.runGame();
    }
    public void runGame() throws IOException, ClassNotFoundException, InterruptedException
    {
        Socket socket = new Socket("25.6.251.126", PORT); // 25.6.251.126
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());// DO NOT FLIP THESE !!! <-- TRIPLE EXCLAMATION IMPORTANCE LEVEL: HELLAx2
        objectInputStream = new ObjectInputStream(socket.getInputStream());
        while (true)
        {
            //GET LOCATIONS PACKET
            Message message = new Message();
            message.setRequest(2,0,0);
            objectOutputStream.writeObject(message);
            //RETURNED LOCATIONS PACKET
            Message returnMessage = (Message)objectInputStream.readObject();
            if (moving)
            {
                moving = false;
                Message moveRequest = new Message();
                moveRequest.setRequest(1, moveDirection, 0);
                objectOutputStream.writeObject(moveRequest);
            }
            
            int[][] temp = returnMessage.getReply().getInfo();
            currentLocations = new int[temp.length][3];
            for (int i = 0; i < temp.length; i++)
            {
                currentLocations[i][0] = temp[i][0];
                currentLocations[i][1] = temp[i][1];
                currentLocations[i][2] = temp[i][2];
            }
            repaint();
            Thread.sleep(REFRESH_SPEED);
        } 
    }
    public Image importImage(String path)
    {
        try
        {
            return ImageIO.read(new File(path));
        }
        catch(IOException e)
        {
            e.printStackTrace();
            System.exit(0);
        }
        return null;
    }
    public void paint (Graphics g)
    {
        dbImage = createImage(getWidth(),getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage,0,0,this);
    }
    public void paintComponent(Graphics g)
    {
        for(int i = 0; i < 32; i++)
        {
            for (int a = 1; a < 25; a++)
            {
                g.drawImage(grasstile,i*32,a*32-8,null);
                //g.drawRect(i*32,a*32-8,32,32);
            }
        }
        for (int x = 0; x < currentLocations.length; x++)
        {
            Image temp;
            if (currentLocations[x][2] == 1)
                temp = hero1;
            else if (currentLocations[x][2] == 2)
                temp = hero2;
            else
                temp = notFound;
            g.drawImage(temp,currentLocations[x][0],currentLocations[x][1],null);
        }
        
    }
    public class AL extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            if (e.getKeyCode() == KeyEvent.VK_D)
            {
                moving = true;
                moveDirection = 1;
            }
            else if (e.getKeyCode() == KeyEvent.VK_W)
            {
                moving = true;
                moveDirection = 2;
            }
            else if (e.getKeyCode() == KeyEvent.VK_A)
            {
                moving = true;
                moveDirection = 3;
            }
            else if (e.getKeyCode() == KeyEvent.VK_S)
            {
                moving = true;
                moveDirection = 4;
            }
        }
        public void keyReleased(KeyEvent e)
        {
            
        }
    }
    public class Mouse extends MouseAdapter
    {
        
    }
}
