/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketwithobjectprj;

import java.io.Serializable;

/**
 *
 * @author Dima
 */
public class Message implements Serializable {
    private static final long erialVersionID = -2723363051271966964L;
    Integer firstNumber = null;
    Integer secondNumber = null;
    Integer result = null;
    public Message (Integer firstNumber, Integer secondNumber)
    {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }
    public Integer getFirstNumber()
    {
        return firstNumber;
    }
    public Integer getSecondNumber()
    {
        return secondNumber;
    }
    public void setResult(Integer result)
    {
        this.result = result;
    }
    public Integer getResult()
    {
        return result;
    }
}
