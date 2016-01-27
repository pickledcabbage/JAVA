
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package socketwithobjectprj;

/**
 *
 * @author Dima
 */
public class RequestPacket implements Serializable {
    int firstRequest;
    int secondRequest;
    int thirdRequest;
    public RequestPacket()
    {
        
    }
    public RequestPacket(int f, int s, int t)
    {
        firstRequest = f;
        secondRequest = s;
        thirdRequest = t;
    }
    public int getFirst()
    {
        return firstRequest;
    }
    public int getSecond()
    {
        return secondRequest;
    }
    public int getThird()
    {
        return thirdRequest;
    }
}
