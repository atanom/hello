/*
 * duplicateRelationException.java
 *
 * Created on 16 January 2008, 17:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package NLPExceptions;

/**
 *
 * @author richentm
 */
public class DuplicateRelationException extends NLPException
{
    
    /** Creates a new instance of duplicateRelationException */
    public DuplicateRelationException()
    {
        short a = 1;
    }
    
    public DuplicateRelationException(String message)
    {
        super(message);
    }
    
}
