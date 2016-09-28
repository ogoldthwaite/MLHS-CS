package singlyLinkedRecursive;

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
	    
	}
	
	/**
	 * Adds the specified value to the end of the list starting at start
	 * @param value the value to add
	 * @param start the head of the (sub)list
	 * @return the node to which the reference pointing to start should point
	 */
	private ListNode add(E value, ListNode start)
	{
	    
		
	}
	
	/**
	 * Removes the first occurrence of the specified value from this list.
	 * Has no effect if the specified value is not in this list.
	 * @param value the value to be removed.
	 */
//	public void remove(E value)
//	{
//	    
//	}
	
	/**
	 * Removes the first occurrence of the specified value in the (sub)list
	 * starting at start. Has no effect if the specified value in not in the (sub)list.
	 * @param value the value to be removed
	 * @param start the head of the (sub)list
	 * @return the node (or null) to which the reference previously pointing at start should point
	 */
//	private ListNode remove(E value, ListNode start)
//	{
//	    
//	}
	
//	public boolean contains(E value)
//	{
//	    
//	}
//	
//	private boolean contains(E value, ListNode start)
//	{
//	    
//	}
	
	public String toString()
    {
        String returnString = "[";
		returnString = returnString + toString(head);
        
		return returnString;
    }
    
    private String toString(ListNode start)
    {
    	if(start == null)
		{
			
		}
    	
    	return null;
    	//[(value), (value), (value)]
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
