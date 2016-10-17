/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainingsetevaluator;

/**
 *
 * @author tom
 */
public abstract class CSVString extends SVString
{
//    String record;
//    String[] fields;

    /** Creates a new instance of prologString */
    public CSVString(String stringRead) // throws DataFormatException
    {
//	record = stringRead;
//        split();
        super(stringRead);
    }

    protected void split()// throws DataFormatException
    {
	fields = record.split(",");
    }
}
