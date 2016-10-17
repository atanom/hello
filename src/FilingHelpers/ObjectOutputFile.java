/*
 * ObjectOutputFile.java
 *
 * Created on 31 October 2007, 18:40
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package FilingHelpers;
import java.io.*;
//import WordnetBuilder.wordNet.*;

/**
 *
 * @author richentm
 */
/** Class to write WordNet Object data to disc*/
public class ObjectOutputFile extends FilingHelper
{
    ObjectOutputStream out;
    /** Creates a new instance of ObjectOutputFile. Any file with the existing filename will be overwritten */
    public ObjectOutputFile(String filename)//throws ClassNotFoundException (?)
    {
        try
        {
            File outputFile = new File(defaultPath, filename);
            out = new ObjectOutputStream(new FileOutputStream(outputFile));
        }
            
//        try
//        {
//            this(defaultPath, filename, true);
//        }
//        catch (IOException e)
//        {
//            System.out.println(e.getMessage());
//        }
////	try
//	{
//	    out = new ObjectOutputStream(new FileOutputStream(filename));
//	    System.out.println("Writing object to file");
//	}
	catch(IOException e)
	{
	    System.err.println("IO error");
	}
    }
 
    /** Creates a new instance of OutputFile */
    public ObjectOutputFile(File outputDirectory, String filename, boolean overwrite) throws UnsupportedEncodingException, IOException
    {
        // TODO code application logic here

            File outputFile = new File(outputDirectory, filename);
            if ((!outputFile.exists()) || overwrite)
            {
                out = new ObjectOutputStream(new FileOutputStream(outputFile));
                System.out.println("Writing object to file");
            }
            else
            {
                String errorMessage = "Output file already exists";
                System.out.println(errorMessage);
                throw new IOException(errorMessage);
            }
    }
    
    public void writeObject(Object SerializableObject)
    {
//	if (SerializableObject instanceof NounSynset)
//        {
//            NounSynset thisSynset = (NounSynset) SerializableObject;
//            if ((thisSynset.size() == 1) && (thisSynset.containsWordForm("nose")))
//            {
//                short a = 1;
//            }
//        }
        try
    	{
	    out.writeObject(SerializableObject);
	}
	catch(IOException e)
	{
	    System.err.println("IO error");
	}
    }
    
    
    public void close()
    {
	try
	{
	    out.close();
	}
	catch(IOException e)
	{
	    System.err.println("IO error");
	}
   }

}
