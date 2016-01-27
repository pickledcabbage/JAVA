/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package socketwithobjectprj;

import java.util.ArrayList;

/**
 *
 * @author Dima
 */
public class Database {
    ArrayList<Player> Players;
    public Database()
    {
        Players = new ArrayList<Player>();
    }
    public void movePlayer(int number, int direction)
    {
        if (direction == 1)
        {
            Players.get(number).setX(Players.get(number).getX()+Players.get(number).getMoveSpeed());
        }
        else if (direction == 3)
        {
            Players.get(number).setX(Players.get(number).getX()-Players.get(number).getMoveSpeed());
        }
        else if (direction == 2)
        {
            Players.get(number).setY(Players.get(number).getY()-Players.get(number).getMoveSpeed());
        }
        else if (direction == 4)
        {
            Players.get(number).setY(Players.get(number).getY()+Players.get(number).getMoveSpeed());
        }
    }
    public int[][] getPlayerLocations()
    {
        int length = Players.size();
        int[][] temp = new int[length][3];
        for (int i = 0; i < length; i++)
        {
            temp[i][0] = Players.get(i).getX();
            temp[i][1] = Players.get(i).getY();
            temp[i][2] = Players.get(i).getType();
        }
        return temp;
    }
    public void addPlayer()
    {
        int temp = 1;
        if (Players.size() == 0)
        {
            temp = 2;
        }
        Players.add(new Player(Players.size()));
        Players.get(Players.size()-1).setType(temp);
    }
}
