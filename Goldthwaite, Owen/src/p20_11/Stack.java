package p20_11;

public class Stack<E>
{
    private Object[] stackAttack;
    private int size;
    
    public Stack()
    {
        stackAttack = new Object[10];
        size = 0;
    }
    
    public Stack(int initialCapacity)
    {
    	if (initialCapacity < 0)
			throw new IllegalArgumentException();
    	stackAttack = new Object[initialCapacity];
        size = 0;
    }

    public boolean isEmpty()
    {
        if(size == 0)
        	return true;
        else
        	return false; 	
    }
    
    public void push(E x)
    {
    	if(stackAttack.length == size)
    	{
    		Object[] stackCopy = new Object[stackAttack.length*2+1];
        	System.arraycopy(stackAttack, 0, stackCopy, 0, (stackAttack.length));
    	}
    	
    	stackAttack[stackAttack.length - 1] = x;
        size++;
    }
    
    public E pop()
    {
        if(!(isEmpty()))
        	throw new IllegalArgumentException();
    	
        E returnValue = (E) stackAttack[stackAttack.length - 1];

    	stackAttack[stackAttack.length - 1] = null;
    	size--;
    		return returnValue;
    			
    	
    }
    
    public E peek()
    {
        return (E) stackAttack[stackAttack.length - 1];
    }

    public String toString()
    {
    	String coolString = "[";
    	for(int i = 0; i < stackAttack.length; i++)
    	{
    		coolString += stackAttack[i];
    			if((!(i == stackAttack.length - 1)))
    				coolString += ", ";
    	}
    	return coolString + "]";
    		
    }
}