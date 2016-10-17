/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NLPExceptions;

/**
 *
 * @author richentm
 */
public class NLPException extends Exception
{
    private Object thrower;
    public NLPException()
    {
//        short a = 1;
    }
    
    public NLPException(String message)
    {
        super(message);
    }
    
    public NLPException(Object thisThrower)
    {
        thrower = thisThrower;
    }
    
    
}

