package minHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

public class Tester extends TestCase
{
    private MinHeap<Integer> heap;
    
    public void setUp()
    {
        heap = new MinHeap<Integer>();
    }
    
    public void tearDown()
    {
        heap = null;
    }
    
    public void testAddThenPeekAndRemove()
    {
        List<Integer> valuesInOrder = new ArrayList<Integer>();
        valuesInOrder.add((int)(Math.random() * 10000));
        for(int i = 1; i < 1000; i++)
        {
            int next = valuesInOrder.get(i - 1) + (int)(Math.random() * 1000);
            valuesInOrder.add(next);
        }
        
        List<Integer> valuesInRandomOrder = new ArrayList<Integer>(valuesInOrder);
        Collections.shuffle(valuesInRandomOrder);
        
        for(Integer value : valuesInRandomOrder)
            heap.add(value);
        
        for(Integer value: valuesInOrder)
        {
           // assertTrue(value.equals(heap.peek()));
            assertTrue(value.equals(heap.remove()));
        }
    }
}
