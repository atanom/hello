/*
 * Main.java
 *
 * Created on 26 October 2007, 10:54
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
public class InputFile extends FilingHelper
{
    private BufferedReader in;
    private String buffer;

    public InputFile(String filename) throws UnsupportedEncodingException, IOException
    {
        this(defaultPath, filename);
	// TODO code application logic here
//	try
//        {
//            in = new BufferedReader(
//                    new InputStreamReader(
//                    new FileInputStream(filename), "UTF-8"));
//            System.out.println("File found: ".concat(filename));
//        }
//        catch (IOException e)
//        {
//            System.out.println("Failed to open input file");
//            System.out.println(e.getMessage());
//        }
    }

    public InputFile(File inputDirectory, String filename) throws UnsupportedEncodingException, IOException
    {
	// TODO code application logic here
        try
        {
            File inputFile = new File(inputDirectory, filename);
            in = new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(inputFile), "UTF-8"));
            System.out.println("File found");
        }
        catch (IOException e)
        {
            System.out.println("Failed to open input file");
            System.out.println(e.getMessage());
            System.out.println(filename);
            throw e;
        }
    }

    public String readLine()
    {
//	String buffer;
	try
    	{
	    buffer = in.readLine();
	    return buffer;
	}
	catch(IOException e)
	{
	    System.err.println("IO error");
	    return null;
	}
    }

    public String readSentence()
    {
	String sentence = "";
//	if (buffer != null)
//	{
//	    sentence += buffer;
//	}
	if ((buffer == null) || (buffer == ""))
	{
	    try
	    {
		buffer = in.readLine();
	    }
	    catch(IOException e)
	    {
		System.err.println("IO error");
		return null;
	    }
	}
	while (buffer != null)
	{
	   if (buffer.contains("."))
	   {
	       sentence += (buffer.substring(0, buffer.indexOf('.') + 1));
	       if (buffer.length() >= buffer.indexOf('.') + 3)
	       {
		   buffer = buffer.substring(buffer.indexOf('.') + 2); //space after full stop
	       }
	       else
	       {
		   buffer = "";
	       }
	       return sentence;
	   }
	   sentence += buffer;
	   sentence += " "; //no spaces at line ends in corpus data
	   try
	   {
	       buffer = in.readLine();
	   }
	   catch(IOException e)
	   {
	       System.err.println("IO error");
	       return null;
	   }
	}
	return null; //end of file without full stop
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


