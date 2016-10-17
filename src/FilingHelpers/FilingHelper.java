package FilingHelpers;
import java.io.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tom
 */
public abstract class FilingHelper 
{
    protected static File defaultPath;
    
    public FilingHelper()
    {
        
    }
    
    public static void setDefaultPath(File path)
    {
        defaultPath = path;
    }
    
    public static File defaultPath()
    {
        return defaultPath;
    }
    
    public abstract void close();

    
}