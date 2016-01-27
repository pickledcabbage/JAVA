

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package socketwithobjectprj;

import java.io.Serializable;

/**
 *
 * @author Dima
 */
public class Message implements Serializable {
    private static final long serialVersionID = -2723363051271966964L;
    String chat;
    int id;
    boolean blank;
    public Message()
    {
        blank = true;
    }
    public Message(String mes)
    {
        chat = mes;
        id = 100;
        blank = mes==null;
    }
    public Message(int i)
    {
        chat = "";
        id = i;
        blank = false;
    }
    public Message(String mes, int i)
    {
        chat = mes;
        id = i;
        blank = false;
    }
    public String getChat()
    {
        return chat;
    }
    public int getID()
    {
        return id;
    }
    public boolean isBlank()
    {
        return blank;
    }
}
