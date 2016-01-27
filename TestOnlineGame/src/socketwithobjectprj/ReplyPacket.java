
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
public class ReplyPacket implements Serializable {
    int[][] data;
    public ReplyPacket(int[][] info)
    {
        data = info;
    }
    public int[][] getInfo()
    {
        return data;
    }
}
