package myArrayList;

import java.util.ArrayList;
import java.util.Arrays;

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
		for(int i = 0; i<size;i++)
		{
			if (a[i].equals(elem) && !(elem.equals(null)))
				return true;
		}
		return false;
	}

	public void trimToSize()
	{
		if(size < a.length)
		{
			Object[] temparray = new Object[size];
			for(int i = 0; i < temparray.length; i++)
				temparray[i]=a[i];
		a=temparray;
		}
		
	}

	public void add(E elem)
	{
		add(size, elem);
	}

	public void add(int index, E element)
	{
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		if (a.length==0)
		{
			Object[] temparray = new Object[1];
			a=temparray;
		}
		if (size == a.length)
		{
			Object[] temparray = new Object[a.length*2];
			for(int i = 0; i <a.length; i++)
				temparray[i]=a[i];
			 a=temparray; 
 		}
		
		for (int i = size; i > index; i--)
		{			
			a[i] = a[i-1];
		}
		a[index] = element;
		size++;
		
		
	}
	
	public E remove(int index)
	{
		if (index < 0 || index >= a.length)
			throw new IndexOutOfBoundsException();
		Object temp;
		for (int i = index; i <= size-1; i++)
		{
			a[i]= a[i+1];
		}
		temp = a[size-1];
		a[size - 1] = null;
		size--;
		
		return (E) temp;
	}

	public boolean remove(Object elem)
	{
		for(int i = 0; i<a.length; i++)
		{
			if(a[i].equals(elem) && !(a[i].equals(null)))
			{
				remove(i);
				return true;
			}
		}
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
