/*
 * ObjectInputFile.java
 *
 * Created on 28 November 2007, 15:00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package FilingHelpers;
import java.io.*;

/**
 *
 * @author richentm
 */
/** Class to read WordNet Object data from disc*/
public class ObjectInputFile extends FilingHelper
{
    ObjectInputStream in;
    /** Creates a new instance of ObjectInputFile */
    public ObjectInputFile(String filename)
    {
        this(defaultPath, filename);
//	try
//	{
//	    in = new ObjectInputStream(new FileInputStream(filename));
//	    System.out.println("Reading object from file: ".concat(filename));
//	}
//        catch (IOException e)
//        {
//            System.out.println("Failed to open input file");
//            System.out.println(e.getMessage());
//        }
    }

    public ObjectInputFile(File inputDirectory, String filename)
    {
	try
	{
            File inputFile = new File(inputDirectory, filename);
	    in = new ObjectInputStream(new FileInputStream(inputFile));
	    System.out.println("Reading object from file: ".concat(filename));
	}
        catch (IOException e)
        {
            System.out.println("Failed to open input file");
            System.out.println(e.getMessage());
        }
    }

    public Object readObject() throws IOException, ClassNotFoundException
    {
	Object SerializableObject;
//	try
//        {
            SerializableObject = in.readObject();
//        }
//        catch (InvalidClassException e)
//        {
//            throw new ClassNotFoundException();
//        }
	
	return SerializableObject;
    }
    
    
    public void close()
    {
	try
	{
	    in.close();
	}
	catch(IOException e)
	{
	    System.err.println("IO error");
	}
   }

}
