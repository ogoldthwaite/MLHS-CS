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
		if (initialCapacity < 0) // Replace this with the correct condition
			throw new IllegalArgumentException();
		a = new Object[initialCapacity];
		size = 0;
	}

	public int size()
	{
		return size;	
	}

    public E get(int index)
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
        return (E) a[index];
		// Note: You must cast the reference from the array to type E.
		// For example, to return element 6 from a: return (E) a[6];
	}

	public E set(int index, E element)
	{	
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		
		Object temp = a[index];
		a[index]=element;
		
		return (E) temp;
	}

	public boolean contains(Object elem)
	{
		for(int i = 0; i<a.length;i++)
		{
			if (a[i].equals(elem))
				return true;
		}
		return false;
	}

	public void trimToSize()
	{
		//DO STUFF HERE
	}

	public void add(E elem)
	{
		//Object[] temparray = new Object[a.length];
	}

	public void add(int index, E element)
	{
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Object[] temparray = new Object[a.length];
		
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
