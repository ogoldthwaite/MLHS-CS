package myLinkedList;

import java.util.LinkedList;

import junit.framework.TestCase;

public class MyLinkedListTest extends TestCase
{
    private LinkedList<Integer> realLinkedList;
    private MyLinkedList<Integer> myLinkedList;
    
    public void setUp()
    {
        realLinkedList = new LinkedList<Integer>();
        myLinkedList = new MyLinkedList<Integer>();
        for(int x = 10; x >= 1; x--)
        {
            realLinkedList.add(x);
            myLinkedList.add(x);
        }
        assertTrue(realLinkedList.toString().equals(myLinkedList.toString()));
    }

    public void tearDown()
    {
        realLinkedList = null;
        myLinkedList = null;
    }
    
    public void testAdd()
    {
        realLinkedList.add(4, 7);
        myLinkedList.add(4, 7);
        assertTrue(realLinkedList.toString().equals(myLinkedList.toString()));
        
        realLinkedList.addFirst(3);
        myLinkedList.addFirst(3);
        assertTrue(realLinkedList.toString().equals(myLinkedList.toString()));
        
        realLinkedList.addLast(17);
        myLinkedList.addLast(17);
        assertTrue(realLinkedList.toString().equals(myLinkedList.toString()));
        
        // TODO: test invalid adds
    }
    
    public void testRemove()
    {
        realLinkedList.remove();
        myLinkedList.remove();
        assertTrue(realLinkedList.toString().equals(myLinkedList.toString()));
        
        realLinkedList.remove(3);
        myLinkedList.remove(3);
        assertTrue(realLinkedList.toString().equals(myLinkedList.toString()));
        
        realLinkedList.removeFirst();
        myLinkedList.removeFirst();
        assertTrue(realLinkedList.toString().equals(myLinkedList.toString()));
        
        realLinkedList.removeLast();
        myLinkedList.removeLast();
        assertTrue(realLinkedList.toString().equals(myLinkedList.toString()));
        
        // TODO: test invalid removes
    }
    
    public void testGet()
    {
        for(int i = 0; i < realLinkedList.size(); i++)
            assertTrue(realLinkedList.get(i).equals(myLinkedList.get(i)));
        
        for(int i = realLinkedList.size() - 1; i >= 0; i--)
            assertTrue(realLinkedList.get(i).equals(myLinkedList.get(i)));
        
        // TODO: test invalid gets
    }
}
