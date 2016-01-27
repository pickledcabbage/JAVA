/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Scanner;
public class InputThread extends Thread {
    String chat;
    boolean newChat;
    public InputThread()
    {
        newChat = false;
    }
    public void run()
    {
        Scanner keyboard = new Scanner(System.in);
        chat = "";
        while (true)
        {
            chat = keyboard.nextLine();
            //System.out.println(chat);
            newChat = true;
        }
    }
    public String getChat()
    {
        return chat;
    }
    public void resetChat()
    {
        newChat = false;
    }
    public boolean getNew()
    {
        return newChat;
    }
}
