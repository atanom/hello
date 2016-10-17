/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package FilingHelpers;
import java.util.*;

/**
 *
 * @author richentm
 */
class TagPair implements Comparable<TagPair>
{
    private String clawsTag;
    private String[] pennTag;
    private float frequency;
    private String orthographicForm;

    TagPair(Map.Entry<String, Set<String>> entry, String wordForm)
    {
        clawsTag = entry.getKey();
        Set<String> pennTagSet = entry.getValue();
        finishConstruction(pennTagSet, wordForm);
    }
    
    TagPair(String key, Set<String> pennTagSet, String wordForm)
    {
        clawsTag = key;
        finishConstruction(pennTagSet, wordForm);
    }
    
    protected TagPair(String[] fields)
    {
        orthographicForm = fields[0];
        clawsTag = fields[1];
        frequency = Float.valueOf(fields[2]);
        pennTag = new String[fields.length - 3];
        for (short cntr = 3; cntr < fields.length; cntr++)
        {
            pennTag[cntr - 3] = fields[cntr];
        }
    }

    private void finishConstruction(Set<String> pennTagSet, String wordForm)
    {
        int pennTagSetSize = pennTagSet.size();
        pennTag = new String[pennTagSetSize];
        short cntr = 0;
        for (String pennTagElement : pennTagSet)
        {
            pennTag[cntr] = pennTagElement;
            cntr++;        
        }
        frequency = 0;
        orthographicForm = wordForm;
    }

    protected String clawsTag()
    {
        return clawsTag;
    }

    protected String[] pennTag()
    {
        return pennTag;
    }

    protected float frequency()
    {
        return frequency;
    }

    public boolean equals(Object o)
    {
        if (!(o instanceof TagPair))
        {
            return false;
        }
        TagPair other = (TagPair) o;
        if (!other.clawsTag.equals(this.clawsTag))
        {
            return false;
        }
        if (!other.orthographicForm.equals(this.orthographicForm))
        {
            return false;
        }
        if (other.pennTag.length != this.pennTag.length)
        {
            return false;
        }
        for (short cntr = 0; cntr < pennTag.length; cntr++)
        {
            if (!(other.pennTag[cntr].equals(this.pennTag[cntr])))
            {
                return false;
            }
        }
        return true;
    }

    public int compareTo(TagPair other)
    {
        if (this.orthographicForm.equals(other.orthographicForm))
        {
            if (this.clawsTag.equals(other.clawsTag))
            {
                if (this.pennTag.length != other.pennTag.length)
                {
                    return this.pennTag.length - other.pennTag.length;
                }
                for (short cntr = 0; cntr < pennTag.length; cntr++)
                {
                    if (!(other.pennTag[cntr].equals(this.pennTag[cntr])))
                    {
                        return this.pennTag[cntr].compareTo(other.pennTag[cntr]);
                    }
                }
                return 0;
            }
            return this.clawsTag.compareTo(other.clawsTag);
        }
        return this.orthographicForm.compareTo(other.orthographicForm);
    }
    
    protected void setInitialFrequency(float initialFrequency)
    {
        frequency = initialFrequency;
    }
    
    protected void merge(TagPair newTagPair)
    {
        frequency += newTagPair.frequency();
    }
    
    protected void write(OutputFile lexicographicFile)
    {
        lexicographicFile.writeField(orthographicForm);
        lexicographicFile.writeFieldSeparator();
        lexicographicFile.writeField(clawsTag);
        lexicographicFile.writeFieldSeparator();
        lexicographicFile.writeField(String.valueOf(frequency));
        for (String pennTagElement : pennTag)
        {
            lexicographicFile.writeFieldSeparator();
            lexicographicFile.writeField(pennTagElement);
        }
    }
    
    @Override
    public String toString()
    {
        return orthographicForm;
    }

    



}
