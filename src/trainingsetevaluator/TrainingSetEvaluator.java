/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainingsetevaluator;
import FilingHelpers.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author tom
 */
public class TrainingSetEvaluator 
{
    File directory;
    TreeSet<SynonymsCSVString> synonyms;
    TreeMap<String, String> synonymSubCategories;
    
    public TrainingSetEvaluator(String pathname)
    {
        directory = new File(pathname);
        synonyms = new TreeSet<SynonymsCSVString>();
        synonymSubCategories = new TreeMap<String, String>();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        String pathname;
        String synonymFilespec;
        String trainingFilespec;
        if (args.length < 3)
        {
            System.out.println("Not enough areguments");
        }
        else
        {
            pathname = args[0];
            synonymFilespec = args[1];
            trainingFilespec = args[2];
            TrainingSetEvaluator evaluator = new TrainingSetEvaluator(pathname);
            try
            {
                evaluator.loadSynonyms(synonymFilespec);
                evaluator.loadData(trainingFilespec);
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
            
        }
    }
    
    private void loadData(String filespec) throws UnsupportedEncodingException, IOException
    {
        InputFile in = new InputFile(directory, filespec);
        String stringRead = in.readLine(); // ignore header line
        stringRead = in.readLine();
        while (stringRead != null)
        {
            TrainingSetTSVString tSVString = new TrainingSetTSVString(stringRead);
            stringRead = in.readLine();
        }
    }
    
    private void loadSynonyms(String filespec) throws UnsupportedEncodingException, IOException
    {
        InputFile in = new InputFile(directory, filespec);
        String stringRead = in.readLine(); // ignore header line
        stringRead = in.readLine();
        while (stringRead != null)
        {
            SynonymsCSVString cSVString = new SynonymsCSVString(stringRead);
            synonyms.add(cSVString);
            String synonym = cSVString.nextSynonym();
            while (synonym != null)
            {
                synonymSubCategories.put(synonym, cSVString.toString());
                synonym = cSVString.nextSynonym();
            }
            stringRead = in.readLine();
        }
        Set<String> synonymSet = synonymSubCategories.keySet();
        Iterator<String> synonIterator = synonymSet.iterator();
        while (synonIterator.hasNext())
        {
            String synonym = synonIterator.next();
            String subCategory = synonymSubCategories.get(synonym);
            System.out.println(synonym + ": " + subCategory);
        }
        TreeMap<String, String> synonymSubCategories;
    }
}
