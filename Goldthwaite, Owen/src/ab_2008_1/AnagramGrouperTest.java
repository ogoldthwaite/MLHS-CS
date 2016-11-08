package ab_2008_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

public class AnagramGrouperTest extends TestCase
{
    public void testCreateKeyString()
    {
        String word = "poodle";
        String expectedKeyString = "deloop";
        String actualKeyString = AnagramGrouper.createKeyString(word);
        
        assertTrue(actualKeyString.equals(expectedKeyString));
        
        
        word = "looped";
        actualKeyString = AnagramGrouper.createKeyString(word);
        
        assertTrue(actualKeyString.equals(expectedKeyString));
    }

    public void testConstructor()
    {
        HashMap<String, HashSet<String>> expectedGroups = getExpectedGroups();
        
        List<String> words = getWordList();
        
        AnagramGrouper ag = new AnagramGrouper(words);
          
        assertTrue(ag.groups.equals(expectedGroups));
    }
    
    public void testFindLargestSets()
    {
        AnagramGrouper ag = new AnagramGrouper(new LinkedList<String>());
        ag.groups = getExpectedGroups();
        
        HashSet<HashSet<String>> expectedResult = new HashSet<HashSet<String>>();
        
        HashSet<String> set1 = new HashSet<String>();
        set1.add("introduces");
        set1.add("reductions");
        set1.add("discounter");
        expectedResult.add(set1);
        
        HashSet<String> set2 = new HashSet<String>();
        set2.add("retains");
        set2.add("retinas");
        set2.add("nastier");
        expectedResult.add(set2);
        
        HashSet<HashSet<String>> actualResult = ag.findLargestSets();
        
        assertTrue(actualResult.equals(expectedResult));
    }

    private List<String> getWordList()
    {
        List<String> words = new LinkedList<String>();
        words.add("ant");
        words.add("introduces");
        words.add("poodle");
        words.add("tan");
        words.add("looped");
        words.add("discounter");
        words.add("nastier");
        words.add("polled");
        words.add("retains");
        words.add("retinas");
        words.add("reductions");
        return words;
    }

    private HashMap<String, HashSet<String>> getExpectedGroups()
    {
        HashMap<String, HashSet<String>> expectedGroups = 
                new HashMap<String, HashSet<String>>();
        
        HashSet<String> deloopSet = new HashSet<String>();
        deloopSet.add("poodle");
        deloopSet.add("looped");
        expectedGroups.put("deloop", deloopSet);
        
        HashSet<String> dellopSet = new HashSet<String>();
        dellopSet.add("polled");
        expectedGroups.put("dellop", dellopSet);
        
        HashSet<String> antSet = new HashSet<String>();
        antSet.add("ant");
        antSet.add("tan");
        expectedGroups.put("ant", antSet);
        
        HashSet<String> cdeinorstuSet = new HashSet<String>();
        cdeinorstuSet.add("introduces");
        cdeinorstuSet.add("reductions");
        cdeinorstuSet.add("discounter");
        expectedGroups.put("cdeinorstu", cdeinorstuSet);
        
        HashSet<String> aeinrstSet = new HashSet<String>();
        aeinrstSet.add("retains");
        aeinrstSet.add("retinas");
        aeinrstSet.add("nastier");
        expectedGroups.put("aeinrst", aeinrstSet);
        return expectedGroups;
    }
}