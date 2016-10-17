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

    public void searchTitle(String onetCategory, TreeMap<String, String> synonymSubCategories)
    {
        TreeMap<String, String> matches = new TreeMap<String, String>();
        Set<String> synonymSet = synonymSubCategories.keySet();
        Iterator<String> synonIterator = synonymSet.iterator();
        while (synonIterator.hasNext())
        {
            String synonym = synonIterator.next();
            if (fields[fieldName.TITLE.ordinal()].contains(synonym))
            {
                String subCategory = synonymSubCategories.get(synonym);
                matches.put(synonym, subCategory);
            }
        }
        displayMatches(onetCategory, matches);
    }
    
    private void displayMatches(String onetCategory, TreeMap<String, String> matches)
    {
        switch (matches.size())
        {
            case 0:
            {
//                System.out.println("Unmatched: revert to onet category + " + onetCategory);
//                System.out.println("Training Set UTT = " + fields[fieldName.UTT.ordinal()]);
                break;
                
            }
            case 1:
            {
                String synonym = matches.firstKey();
                String subCategory = matches.get((synonym));
                if (subCategory.equalsIgnoreCase(onetCategory))
                {
                    System.out.println("Synonym " + synonym + " maps to to onet category " + onetCategory);
                    System.out.println("Training Set UTT = " + fields[fieldName.UTT.ordinal()]);
                }
                if (!(subCategory.equalsIgnoreCase(fields[fieldName.UTT.ordinal()])))
                {
                    System.out.println("\"Synonym " + synonym + " does not match training Set UTT");
                    System.out.println("Training Set UTT = " + fields[fieldName.UTT.ordinal()]);
                }
                break;
            }
            case 2:
            {
                boolean oneOfTwoIsOnet = false;
                Set<String> synonymSet = matches.keySet();
                Iterator<String> synonIterator = synonymSet.iterator();
                while (synonIterator.hasNext())
                {
                    String synonym = synonIterator.next();
                    String subCategory = matches.get((synonym));
                    if (subCategory.equalsIgnoreCase(onetCategory))
                    {
                        oneOfTwoIsOnet = true;
                    }
                }
                if (oneOfTwoIsOnet)
                {
                    synonIterator = synonymSet.iterator();
                    while (synonIterator.hasNext())
                    {
                        String synonym = synonIterator.next();
                        String subCategory = matches.get((synonym));
                        if (!subCategory.equalsIgnoreCase(onetCategory))
                        {
                            System.out.println("Synonym " + synonym + " maps to to UTT category " + subCategory);
                            if (!(subCategory.equalsIgnoreCase(fields[fieldName.UTT.ordinal()])))
                            {
//                                System.out.println("Synonym " + synonym + " does not match training Set UTT");
                                System.out.println("Training Set UTT = " + fields[fieldName.UTT.ordinal()]);
                            }
                        }
                    }
                }
                else
                {
                    System.out.println("Match ambiguity");
                    synonIterator = synonymSet.iterator();
                    while (synonIterator.hasNext())
                    {
                        String synonym = synonIterator.next();
                        String subCategory = matches.get((synonym));
                        System.out.println("Synonym " + synonym + " maps to to UTT category " + subCategory);
                        if (!(subCategory.equalsIgnoreCase(fields[fieldName.UTT.ordinal()])))
                        {
                            System.out.println("\"Synonym " + synonym + " does not match training Set UTT");
                            System.out.println("Training Set UTT = " + fields[fieldName.UTT.ordinal()]);
                            if (!(subCategory.equalsIgnoreCase(fields[fieldName.UTT.ordinal()])))
                            {
                                System.out.println("\"Synonym " + synonym + " does not match training Set UTT");
                                System.out.println("Training Set UTT = " + fields[fieldName.UTT.ordinal()]);
                            }
                        }
                    }
                }
                break;
            }
            default:
            {
                System.out.println("Match ambiguity");
                Set<String> synonymSet = matches.keySet();
                Iterator<String> synonIterator = synonymSet.iterator();
                while (synonIterator.hasNext())
                {
                    String synonym = synonIterator.next();
                    String subCategory = matches.get((synonym));
                    if (subCategory.equalsIgnoreCase(onetCategory))
                    {
                        System.out.println("Synonym " + synonym + " maps to to onet category " + onetCategory);
                        System.out.println("Training Set UTT = " + fields[fieldName.UTT.ordinal()]);
                    }
                    else
                    {
                        System.out.println("Synonym " + synonym + " maps to to UTT category " + subCategory);
                        System.out.println("Training Set UTT = " + fields[fieldName.UTT.ordinal()]);
                    }
                }
            }
        }
    }

}
