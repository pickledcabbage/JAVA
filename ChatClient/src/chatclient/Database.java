/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author Dima
 */
public class Database {
    ArrayList<String> mailboxes;
    boolean[] mail;
    public Database()
    {
        mailboxes = new ArrayList<String>();
        mail = new boolean[100];
    }
    public void distribute(int numb, String c, String user)
    {
        if (c != null)
        {
            for (int i = 0; i < mailboxes.size(); i++)
            {
                if (numb!=i)
                {
                    mailboxes.set(i, "["+user+"]: "+c);
                }
            
            }
        }
        
        //System.out.println("Nice");
    }
    public String recieve(int numb)
    {
        if (numb<mailboxes.size())
        {
            String temp = mailboxes.get(numb);
            mailboxes.set(numb,null);
            return temp;
        }
        else
            return null;
    }
    public boolean isMail(int numb)
    {
        return (mailboxes.get(numb)!=null);
    }
    public void addBox()
    {
        mailboxes.add(null);
    }
}
