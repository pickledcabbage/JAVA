/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steampunkdnd;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Dima
 */
public class SteamPunkDND extends JFrame {
    int GAMEWIDTH = 1028;
    int GAMEHEIGHT = 796;
    int REFRESH_SPEED = 15;
    int x = 0;
    int y = 0;
    private Image dbImage;
    private Graphics dbg;
    private JPanel charCreation;
    public SteamPunkDND ()
    {
        addKeyListener(new AL());
        addMouseListener(new Mouse());
        
        setTitle("SteamPunkDND or something we'll figure out later");
        setSize(GAMEWIDTH,GAMEHEIGHT);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        charCreation = new JPanel();
        
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
    public static void main(String [] args)
    {
        SteamPunkDND run = new SteamPunkDND();
        run.loop();
    }
    public void loop()
    {
        try
        {
            while(true)
            {
                repaint();
                Thread.sleep(REFRESH_SPEED);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
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
                g.drawImage(importImage("grass1.png"),i*32,a*32-8,null);
                g.drawRect(i*32,a*32-8,32,32);
            }
        }
    }
    public class AL extends KeyAdapter
    {
        public void keyPressed(KeyEvent e)
        {
            
        }
        public void keyReleased(KeyEvent e)
        {
            
        }
    }
    public class Mouse extends MouseAdapter
    {
        
    }
    
}
