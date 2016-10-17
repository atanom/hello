/*
 * UnexpectedXMLFormatException.java
 *
 * Created on 15 November 2007, 12:13
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package NLPExceptions;

/**
 *
 * @author richentm
 */
public class UnexpectedXMLFormatException extends NLPException
{
    
    private String unexpectedElement;
    private String expectedElement;
    private boolean unexpectedggElement;
    /** Creates a new instance of UnexpectedXMLFormatException */
    public UnexpectedXMLFormatException()
    {
        unexpectedElement = null;
        expectedElement = null;
        unexpectedggElement = false;
    }
    
    /** Creates a new instance of UnexpectedXMLFormatException */
    public UnexpectedXMLFormatException(String thisUnexpectedElement, String thisExpectedElement)
    {
        unexpectedElement = thisUnexpectedElement;
        expectedElement = thisExpectedElement;
        unexpectedggElement = false;
    }
    
    /** Creates a new instance of UnexpectedXMLFormatException */
    public UnexpectedXMLFormatException(boolean thisUnexpectedggElement)
    {
        unexpectedggElement = thisUnexpectedggElement;
    }
    
    public boolean unexpectedggElement()
    {
        return unexpectedggElement;
    }
    
}
