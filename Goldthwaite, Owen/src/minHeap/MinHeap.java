package minHeap;

import binaryTree.arrayBased.ArrayBinaryTree;

public class MinHeap<E extends Comparable<? super E>> extends ArrayBinaryTree<E>
{
    public void add(E element)
    {
    	elements.add(element);
    	elements.sort(null);
    }
    
    public E remove()
    {
        E returnVal = elements.get(0);
        elements.remove(0);
        elements.sort(null);
        
        return returnVal;
    	
    }
    
    public E peek()
    {
      return elements.get(0);  
    }
    
    /**
     * Fixes a min-heap that is violated only by its root.
     * 
     * Preconditions: The (sub)heap rooted at nodeIndex adheres to the min-heap property except for the
     * element at nodeIndex itself.
     * 
     * Postcondition: The (sub)heap rooted at nodeIndex adheres to the min-heap property.
     */
    private void fixHeap(int nodeIndex)
    {
        
    	
    	
    }
}
