package myArrayList;

import java.util.ArrayList;

public class MyArrayList<E>
{
	private Object[] a;
	private int size;
	

	public MyArrayList()
	{
	    a = new Object[10];
		size = 0;
	}

	public MyArrayList(int initialCapacity)
	{
		if (initialCapacity <= 0) // Replace this with the correct condition
			throw new IllegalArgumentException();
		a = new Object[initialCapacity];
	}

	public int size()
	{
		int count = 0;
		for(Object x : a)
		{
			count++;
		}
		
		return count;
	}

    public E get(int index)
	{
		if (true)
			throw new IndexOutOfBoundsException();

		// Note: You must cast the reference from the array to type E.
		// For example, to return element 6 from a: return (E) a[6];
		
		return null;
	}

	public E set(int index, E element)
	{
		if (true)
			throw new IndexOutOfBoundsException();
		
		return null;
	}

	public boolean contains(Object elem)
	{
		return false;
	}

	public void trimToSize()
	{

	}

	public void add(E elem)
	{

	}

	public void add(int index, E element)
	{
		if (true)
			throw new IndexOutOfBoundsException();
	}

	public E remove(int index)
	{
		if (true)
			throw new IndexOutOfBoundsException();
		
		return null;
	}

	public boolean remove(Object elem)
	{
		return false;
	}
	
	// start package access methods to facilitate automated testing
	// do not modify these methods
	
	Object[] getA()
	{
		return a;
	}
	
	void setA(Object[] newA)
	{
		a = newA;
	}
	
	int getSize()
	{
		return size;
	}
	
	void setSize(int newSize)
	{
		size = newSize;
	}
	
	// end package access methods to facilitate automated testing
}
