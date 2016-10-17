/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainingsetevaluator;
//import WordnetBuilder.*;
import NLPExceptions.DataFormatException;
import java.util.*;

/**
 *
 * @author tom
 */
public abstract class SVString 
{
    String record;
    String[] fields;

    /** Creates a new instance of prologString */
    public SVString(String stringRead)
    {
	record = stringRead;
        split();
    }

    protected abstract void split();
    
}
