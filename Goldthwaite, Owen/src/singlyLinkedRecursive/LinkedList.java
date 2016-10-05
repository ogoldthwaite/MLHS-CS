package singlyLinkedRecursive;

import java.util.ArrayList;

public class LinkedList<E>
{
    // does not use a dummy head node
	private ListNode head;

	public LinkedList()
	{
	    head = null;
	}	
	
	/**
	 * Adds the specified value to the end of this list
	 * @param value the value to add
	 */
	public void add(E value)
	{
	    head = add(value, head);
	}
	
	/**
	 * Adds the specified value to the end of the list starting at start
	 * @param value the value to add
	 * @param start the head of the (sub)list
	 * @return the node to which the reference pointing to start should point
	 */
	private ListNode add(E value, ListNode start)
	{
		if(start == null)
	    {
			System.out.println("ran!");
			ListNode addNode = new ListNode(value);
			start = addNode;
	    }
		else 
	    	start.next = add(value, start.next);

		return start;
	}
	
	/**
	 * Removes the first occurrence of the specified value from this list.
	 * Has no effect if the specified value is not in this list.
	 * @param value the value to be removed.
	 */
	public void remove(E value)
	{
	    head = remove(value, head);
	}
	
	/**
	 * Removes the first occurrence of the specified value in the (sub)list
	 * starting at start. Has no effect if the specified value in not in the (sub)list.
	 * @param value the value to be removed
	 * @param start the head of the (sub)list
	 * @return the node (or null) to which the reference previously pointing at start should point
	 */
	private ListNode remove(E value, ListNode start)
	{
       if(start == null)
    	   return null;
    		
       if(start.value.equals(value))
    		return start.next;
	
	    start.next = remove(value, start.next);
	}
	
	public boolean contains(E value)
	{
	    return contains(value, head);
	}
	
	private boolean contains(E value, ListNode start)
	{
	    if(start == null)
	    	return false;
	    
	    if(start.value.equals(value))
	    	return true;
	    
		return contains(value, start.next);
		
	}
	
	public String toString()
    {
        
		return "[" + toString(head) + "]";
    }
    
    private String toString(ListNode start)
    {

    	if(start == null)
    		return "";
    	
    	String coolString = start.value.toString();
    	
    	if(start.next != null)
    	{
    		coolString +=", ";
    	}
    	
    		coolString += toString(start.next);

    			return coolString;
    	//return "";
    	// [(value), (value), (value)]
    }
    
	public ArrayList<E> reverse(ListNode start)
	{
		// if(start == null) //dont know if this is right base case
		 
		
		return null;
	}
    
	private class ListNode
	{
	    public ListNode next;
	    public E value;
	    
	    public ListNode(E value)
	    {
	        next = null;
	        this.value = value;
	    }
	}
}
