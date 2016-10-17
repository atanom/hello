/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NLPExceptions;
//import WordnetBuilder.wordNet.*;
/**
 *
 * @author Tom
 */
public class Paradox extends NLPException
{
    private static int paradoxCount = 0;
    
    public Paradox()
    {
        paradoxCount++;
    }
    
    public static int paradoxCount()
    {
        return paradoxCount;
    }
    
    /**
     * static field paradoxCount is reset to 0
     */public static void reset()
    {
        paradoxCount = 0;
    }
    
    

}
