/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.*;
/**
 *
 * @author Dima
 */
public class Client {
    public static void main (String [] args)
    {
        if (args.length == 1)
            try{
                Socket socket = new Socket("localhost", 4445);
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println(args[0]);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("The following reply was recieved from Server: "+bufferedReader.readLine());
            }
        catch (Exception e)
        {
            System.out.println("exception in listenSocket " + e);
        }
        else
        {
            System.err.println("Usage: Client <server> <name>");
        }
    }
}
