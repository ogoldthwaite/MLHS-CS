package singlyLinkedRecursive;

import junit.framework.TestCase;

public class LinkedListTest extends TestCase
{
    public void testAdd()
    {
        java.util.LinkedList<Integer> oracle = new java.util.LinkedList<Integer>();
        LinkedList<Integer> underTest = new LinkedList<Integer>();
        
        String oracleAsString = oracle.toString();
        String underTestAsString = underTest.toString();
        
        assertTrue(oracleAsString.equals(underTestAsString));
        
        oracle.add(15);
        underTest.add(15);
        
        oracleAsString = oracle.toString();
        underTestAsString = underTest.toString();
         
        oracle.add(10);
        underTest.add(10);
        
        oracle.add(7);
        underTest.add(7);
        
        oracleAsString = oracle.toString();
        underTestAsString = underTest.toString();
        
        assertTrue(oracleAsString.equals(underTestAsString));
    }
}
