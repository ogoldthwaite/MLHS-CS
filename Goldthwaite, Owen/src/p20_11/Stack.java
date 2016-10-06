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
    	Object[] stackCopy = new Object[stackAttack.length*2+1];
    	if(stackAttack.length == size)
        	System.arraycopy(stackAttack, 0, stackCopy, 0, (stackAttack.length));
    	stackAttack[stackAttack.length - 1] = x;
        size++;
    }
    
    public E pop()
    {
        
    }
    
    public E peek()
    {
        
    }
}