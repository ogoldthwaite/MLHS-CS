package advancedSorts;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapSort
{
	private static int heapSize = 0;
	private static ArrayList<Integer> elements;
	
	public static <T> void sort(T[] a, Comparator<T> c)
	{
		//c.compare(element1, element2); How you compare stuff!
		//elements = a;
		for(int i = 1; i < a.length; i++)
		{
			int pIndex = getParentIndex(i);
			int k = i;
			
		while(c.compare(a[k], a[pIndex]) > 0 && pIndex > -1)
		{
			if (c.compare(a[k], a[pIndex]) > 0)
			{
				swap(a, k, pIndex);
				k = pIndex;
				pIndex = getParentIndex(k); //change this k I think
			}
		}
			
			heapSize++;
		}
		
		System.out.println(a);
		
		
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

	 private void fixHeap(int nodeIndex)
		{
			int leftChildIndex = getChildIndex(nodeIndex, true);
			int rightChildIndex = getChildIndex(nodeIndex, false);
			//E min = elements.get(nodeIndex);
			//int minIndex = nodeIndex;

			
			if(elements.size() != 0)
			{
				int min = elements.get(nodeIndex);
				int minIndex = nodeIndex;
				
				if(leftChildIndex < elements.size())
				{
					fixHeap(leftChildIndex);
					if(elements.get(leftChildIndex).compareTo(min) < 0)
					{
						min = elements.get(leftChildIndex);
						minIndex = leftChildIndex;
					}
				}

				if(rightChildIndex < elements.size())
				{
					fixHeap(rightChildIndex);
					if(elements.get(rightChildIndex).compareTo(min) < 0)
					{
						min = elements.get(rightChildIndex);
						minIndex = rightChildIndex;
					}

				}	
					if(minIndex != nodeIndex)
					{	
						elements.set(minIndex, elements.get(nodeIndex));
						elements.set(nodeIndex, min);
					} 
			} 	
		}

}
