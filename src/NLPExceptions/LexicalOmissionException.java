/*
 * LexicalOmissionException.java
 *
 * Created on 16 March 2008, 19:05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package NLPExceptions;

/**
 *
 * @author richentm
 */
public class LexicalOmissionException extends NLPException
{
    private String lexicalOmission;
    
    /** Creates a new instance of LexicalOmissionException */
    public LexicalOmissionException()
    {
//	lexicalOmission = null;
    }
    
    /** Creates a new instance of LexicalOmissionException */
    public LexicalOmissionException(String thisLexicalOmission)
    {
	lexicalOmission = thisLexicalOmission;
    }
    
    
    public String lexicalOmission()
    {
	return lexicalOmission;
    }
}
