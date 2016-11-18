package binaryTree.linkBased;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * A binary tree.
 */
public abstract class LinkedBinaryTree<E>
{
    protected TreeNode<E> root;
    protected int size;
    
    public LinkedBinaryTree()
    {
        
    }
    
    /** 
     * Returns the number of elements in this tree.
     * @return the number of elements in this tree
     */
    public int size()
    {
        
    }
    
    public boolean contains(E element)
    {
        
    }
    
    private boolean contains(TreeNode<E> node, E element)
    {
        
    }
    
    public abstract void add(E element);
    
    public List<E> levelOrder()
    {
        
    }
    
    public List<E> levelOrder(boolean includeNull)
    {
        
    }
    
    public List<E> inOrder()
    {
    	
    }
    
    private void inOrder(TreeNode<E> node, List<E> elementsInOrder)
    {
    	
    }
    
    public List<E> preOrder()
    {
    	
    }
    
    private void preOrder(TreeNode<E> node, List<E> elementsPreOrder)
    {
    	
    }
    
    public List<E> postOrder()
    {
    	
    }
    
    private void postOrder(TreeNode<E> node, List<E> elementsPostOrder)
    {
    	
    }
}
