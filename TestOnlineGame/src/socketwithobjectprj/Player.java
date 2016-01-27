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
public class Player {
    int x;
    int y;
    int type;
    int MOVE_SPEED = 10;
    int mapNumber;
    public Player(int number)
    {
        mapNumber = number;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setX(int newx)
    {
        x = newx;
    }
    public void setY(int newy)
    {
        y = newy;
    }
    public int getMoveSpeed()
    {
        return MOVE_SPEED;
    }
    public int getType()
    {
        return type;
    }
    public void setType(int t)
    {
        type = t;
    }
}
