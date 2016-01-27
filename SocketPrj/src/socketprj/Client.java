/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Dima
 */
public class Client {
    public static void main (String [] args) throws UnknownHostException, IOException
    {
        //String name = args[0];
        String name = "user #1";
        Socket socket = new Socket("localhost", 4446);
        BufferedReader bufferedReaderFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader bufferedReaderFromCommandPrompt = new java.io.BufferedReader(new InputStreamReader(System.in));
        printWriter.println(name);
        while(true)
        {
            String readerInput = bufferedReaderFromCommandPrompt.readLine();
            printWriter.println(name +": " + readerInput);
            System.out.println(bufferedReaderFromClient.readLine());
        }
        
    }
}
