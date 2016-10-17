/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainingsetevaluator;
import java.util.*;

/**
 *
 * @author tom
 */
public class TrainingSetTSVString extends TSVString
{
    enum FieldName{ID ,TITLE, DESCRIPTION, INN, UTT};
    FieldName fieldName;
    public TrainingSetTSVString(String stringRead) // throws DataFormatException
    {
        super(stringRead);
    }
    
    public String getID()
    {
        return fields[fieldName.ID.ordinal()];
    }

    public String getTitle()
    {
        return fields[fieldName.TITLE.ordinal()];
    }

    public String getINN()
    {
        return fields[fieldName.INN.ordinal()];
    }

    public String getUTT()
    {
        return fields[fieldName.UTT.ordinal()];
    }

    public void evaluate(TreeSet<SynonymsCSVString> synonyms)
    {
        Iterator<SynonymsCSVString> synonIterator = synonyms.iterator();
        while (synonIterator.hasNext())
        {
            SynonymsCSVString synonymString = synonIterator.next();

        }

    }

}
