/*
 * OutputFile.java
 *
 * Created on 20 November 2007, 19:07
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
public class OutputFile extends FilingHelper
{
    private BufferedWriter out;

    /** Creates a new instance of OutputFile */
    public OutputFile(String filename) throws UnsupportedEncodingException, FileNotFoundException
    {
        this(defaultPath, filename);
//	// TODO code application logic here
//        try
//        {
//	    out = new BufferedWriter(
//		new OutputStreamWriter(
//		new FileOutputStream(filename),"UTF-8"));
//        }
//        catch (NullPointerException e)
//        {
//            System.out.println("No filename specified");
//            throw new FileNotFoundException();
//        }
//	
//	    System.out.println("File created: ".concat(filename));
    }
    
    public OutputFile(File localpath, String filename) throws UnsupportedEncodingException, FileNotFoundException
    {
	// TODO code application logic here
        try
        {
	    out = new BufferedWriter(
		new OutputStreamWriter(
		new FileOutputStream(new File(localpath, filename)),"UTF-8"));
        }
        catch (NullPointerException e)
        {
            System.out.println("No filename specified");
            throw new FileNotFoundException();
        }
	
	    System.out.println("File created: ".concat(filename));
    }
    
    
    public OutputFile(File outputDirectory, String filename, boolean overwrite) throws UnsupportedEncodingException, IOException
    {
        // TODO code application logic here

            File outputFile = new File(outputDirectory, filename);
            if ((!outputFile.exists()) || overwrite)
            {
                out = new BufferedWriter(
                new OutputStreamWriter(
                new FileOutputStream(outputFile),"UTF-8"));
                System.out.println("Writing data to file");
            }
            else
            {
                String errorMessage = "Output file already exists";
                System.out.println(errorMessage);
                throw new IOException(errorMessage);
            }
    }

	public void writeLine(String buffer)
	{
		try
		{
			out.write(buffer);
			out.newLine();
		}
		catch (IOException e)
		{
			System.err.println("IO error");
		}
		catch (NullPointerException e)
		{
			System.err.println("Data is Null string");
		}

	}
     
     public void writeField(String field)
    {
	try
    	{
	    out.write(field);
//	    writeFieldSeparator();
	}
	catch(IOException e)
	{
	    System.err.println("IO error");
	}
    }
     
     public void writeFieldSeparator()
    {
	try
    	{
	    out.write(",");
	}
	catch(IOException e)
	{
	    System.err.println("IO error");
	}
    }
     
     public void writeRecordSeparator()
    {
	try
    	{
	    out.newLine();
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
