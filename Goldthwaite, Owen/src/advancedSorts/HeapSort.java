package advancedSorts;

import java.util.Comparator;

public class HeapSort
{
	public static <T> void sort(T[] a, Comparator<T> c)
	{
		//c.compare(element1, element2); How you compare stuff!
		
		
		
		
		
	}
	
	private static void swap(Object[] x, int i, int j)
	{
		Object temp = x[i];
		x[i] = x[j];
		x[j] = temp;
	}

	 protected final static int getParentIndex(int childIndex)
	    {
	        return (childIndex + 1) / 2 - 1;
	    }
	    
	 protected final static int getChildIndex(int parentIndex, boolean left)
	    {
	        return 2 * parentIndex + (left ? 1 : 2);
	    }



}
