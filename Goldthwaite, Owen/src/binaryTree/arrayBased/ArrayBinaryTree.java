package binaryTree.arrayBased;

import java.util.ArrayList;
import java.util.List;

/**
 * A complete binary tree.
 * 
 * Note: This is NOT a binary search tree. The elements are stored
 * unordered. This data structure is used only for practice with
 * tree terminology and traversals.
 */
public class ArrayBinaryTree<E>
{
    protected ArrayList<E> elements;
    
    public ArrayBinaryTree(ArrayList<E> stuff)
    {
       // this.elements = new ArrayList<E>();
    	this.elements = stuff;
    }
    
    /** 
     * Returns the number of elements in this tree.
     * @return the number of elements in this tree
     */
    public int size()
    {
        return this.elements.size();
    }
    
    // Although this method is not interesting for an arbitrary complete binary tree
    // stored as an array, it is necessary to test the traversals.
    public void add(E element)
    {
        this.elements.add(element);
    }
    
    protected final static int getParentIndex(int childIndex)
    {
        return (childIndex + 1) / 2 - 1;
    }
    
    protected final static int getChildIndex(int parentIndex, boolean left)
    {
        return 2 * parentIndex + (left ? 1 : 2);
    }
    
    public List<E> levelOrder()
    {
    	return elements;	
    }
    
    public List<E> inOrder()
    {
    	List<E> elementsInOrd = new ArrayList<E>();
    	inOrder(0, elementsInOrd);
    	return elementsInOrd;
    }
    
    private void inOrder(int index, List<E> elementsInOrd)
    {
    	if(index >= size())
    		return;
    	
    	inOrder(getChildIndex(index, true), elementsInOrd);
    	
    	elementsInOrd.add(elements.get(index));
    	
    	inOrder(getChildIndex(index, false), elementsInOrd);
    	
    }
    /*
     * Note: The repeated code in the traversal methods below has been kept to show
     * the simplicity of each method individually. For most applications no more than
     * 1 of these methods will be pres
     * ent.
     */
    
    public List<E> preOrder()
    {
    	List<E> elementsPreOrd = new ArrayList<E>();
    	preOrder(0, elementsPreOrd);
    	return elementsPreOrd;
    }
    
    private void preOrder(int index, List<E> elementsPreOrd)
    {
    	if(index >= size())
    		return;
    	
    	elementsPreOrd.add(elements.get(index));
    	
    	preOrder(getChildIndex(index, true), elementsPreOrd);
    	 
    	preOrder(getChildIndex(index, false), elementsPreOrd);
    }
  
    
    public List<E> postOrder()
    {
        List<E> elementsPostOrd = new ArrayList<E>();
        postOrder(0, elementsPostOrd);
        return elementsPostOrd;
    }
    
    private void postOrder(int index, List<E> elementsPostOrd)
    {
    	if(index >= size())
    		return;
    	
    	postOrder(getChildIndex(index, true), elementsPostOrd);
    	
    	postOrder(getChildIndex(index, false), elementsPostOrd);
    	
    	elementsPostOrd.add(elements.get(index));
    }
  
}
