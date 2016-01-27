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
    boolean fromClient;
    RequestPacket request;
    ReplyPacket reply;
    int playerNumber;
    public Message()
    {
        fromClient = true;
        playerNumber = -1;
    }
    public Message(int number)
    {
        playerNumber = number;
    }
    public int getPlayNumb()
    {
        return playerNumber;
    }
    public boolean getDirection()
    {
        return fromClient;
    }
    public void setDirection(boolean direction)
    {
        fromClient = direction;
    }
    public void setRequest(int f, int s, int t)
    {
        request = new RequestPacket(f,s,t);
    }
    public RequestPacket getRequest()
    {
        return request;
    }
    public void setReply(int[][] arr)
    {
        reply = new ReplyPacket(arr);
    }
    public ReplyPacket getReply()
    {
        return reply;
    }
}
