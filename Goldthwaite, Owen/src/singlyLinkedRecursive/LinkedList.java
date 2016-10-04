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
	    add(value, head);
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
        
		return "[" + toString(head) + "]";
    }
    
    private String toString(ListNode start)
    {

    	if(start == null)
    		return "";
    	
    	if(start.next == null)
    	{
    		System.out.println("ran");
    		return (String) start.value;
    	}
    		else
    	return start.value +", " + toString(start.next);

    	//return "";
    	// [(value), (value), (value)]
    }
    
    public void print (ListNode l)
    {
      if (l == null)
        return;
      else {
        System.out.println(l.value);
        print(l.next);
      };
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
