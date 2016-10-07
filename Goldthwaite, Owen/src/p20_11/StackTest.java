package p20_11;

import junit.framework.TestCase;

public class StackTest extends TestCase
{
	private Stack<Integer> myStack;
	private java.util.Stack<Integer> realStack;
	
	public void setUp()
	{
		
		for(int i = 0; i<5; i++)
		{
			myStack.push(i);
			realStack.push(i);
		}

	}
	
	public void testPeek()
	{
		int myTestInt = myStack.peek();
		int testInt = realStack.peek();
		
		assertTrue(myTestInt == testInt);
		
	}
	
	public void testPush()
	{
		for(int i = 5; i<10; i++)
		{
			myStack.push(i);
			realStack.push(i);
		}
	String myTestString = myStack.toString();
	String testString = myStack.toString();
	
	assertTrue(myTestString.equals(testString));
	
	
	}
	
	public void testPop()
	{
		
		
		
	}

}
