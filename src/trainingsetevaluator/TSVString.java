/*
 * prologString.java
 *
 * Created on 09 November 2007, 15:46
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package trainingsetevaluator;
//import WordnetBuilder.*;
import NLPExceptions.DataFormatException;
import java.util.*;

/**
 *
 * @author richentm
 */
public abstract class TSVString extends SVString
{
//    String record;
//    String[] fields;

    /** Creates a new instance of prologString */
    public TSVString(String stringRead) // throws DataFormatException
    {
//	record = stringRead;
//        split();
        super(stringRead);
    }

    protected void split()// throws DataFormatException
    {
	fields = record.split("\t");
    }
       
}

    
    