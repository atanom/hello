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
public class SynonymsCSVString extends CSVString implements Comparable<SynonymsCSVString>
{
    enum FieldName{SUBCATEGORY, DUMMY, SYNONYMS};
    FieldName fieldName;
    TreeSet<String> synonyms;
    Iterator<String> synonIterator;
    public SynonymsCSVString(String stringRead) // throws DataFormatException
    {
        super(stringRead);
        synonyms = new TreeSet<String>();
        sortSynonyms();
        synonIterator = synonyms.iterator();
    }
    
    private void sortSynonyms()
    {
        synonyms.add(fields[fieldName.SUBCATEGORY.ordinal()]);
        for (int cntr = fieldName.SYNONYMS.ordinal(); cntr < fields.length; cntr++)
        {
            synonyms.add(fields[cntr]);
        }
    }
    
    public String toString()
    {
        return fields[fieldName.SUBCATEGORY.ordinal()];
    }
    
    public boolean equals(Object o)
    {
        if (o instanceof SynonymsCSVString)
        {
            SynonymsCSVString other = (SynonymsCSVString) o;
            return (fields[fieldName.SUBCATEGORY.ordinal()].equals(other.fields[fieldName.SUBCATEGORY.ordinal()]));
        }
        else
        {
            return false;
        }
    }
    
    public int compareTo(SynonymsCSVString o)
    {
        return (fields[fieldName.SUBCATEGORY.ordinal()].compareTo(o.fields[fieldName.SUBCATEGORY.ordinal()]));
    }
    
    public String nextSynonym()
    {
        if (synonIterator.hasNext())
        {
            return synonIterator.next();
        }
        else
        {
            synonIterator = synonyms.iterator();
            return null;
        }
    }
    
}
