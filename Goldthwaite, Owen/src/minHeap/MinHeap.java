package minHeap;

import binaryTree.arrayBased.ArrayBinaryTree;

public class MinHeap<E extends Comparable<? super E>> extends ArrayBinaryTree<E>
{
	public void add(E element)
	{
		elements.add(element);
		int index = elements.size() - 1;
		int parentIndex = getParentIndex(index);  	

		//System.out.println(elements);

		while((parentIndex >= 0) && elements.get(index).compareTo(elements.get(parentIndex)) < 0)
		{
			//System.out.println(elements);
			E temp = elements.get(index);
			elements.set(index, elements.get(parentIndex));
			elements.set(parentIndex, temp);
			index = getParentIndex(index);
		}	

		// elements.sort(null);

	}

	public E remove()
	{	
		E returnVal = elements.get(0);
		elements.remove(0);
		fixHeap(0);

		return returnVal;

	}

	public E peek()
	{
		// System.out.println(elements);
		return elements.get(0);  
	}

	/**
	 * Fixes a min-heap that is violated only by its root.
	 * 
	 * Preconditions: The (sub)heap rooted at nodeIndex adheres to the min-heap property except for the
	 * element at nodeIndex itself.
	 * 
	 * Postcondition: The (sub)heap rooted at nodeIndex adheres to the min-heap property.
	 */
	private void fixHeap(int nodeIndex)
	{
		int leftChildIndex = getChildIndex(nodeIndex, true);
		int rightChildIndex = getChildIndex(nodeIndex, false);
		//E min = elements.get(nodeIndex);
		//int minIndex = nodeIndex;

		if(elements.size() != 0)
		{
			E min = elements.get(nodeIndex);
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
