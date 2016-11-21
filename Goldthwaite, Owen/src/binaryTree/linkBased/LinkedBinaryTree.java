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
        root = null;
        size = 0;
    }
    
    /** 
     * Returns the number of elements in this tree.
     * @return the number of elements in this tree
     */
    public int size()
    {
        return size;
    }
    
    public boolean contains(E element)
    {
        return contains(root, root.value);
    }
    
    private boolean contains(TreeNode<E> node, E element)
    {
    	if(node.value == null)
        	return false;
        
    	if(node.value.equals(element))
    		return true;
    	
        if(contains(node.left, node.left.value) || contains(node.right, node.right.value))
        	return true;
        	
        return false;
    }
    
    public abstract void add(E element);
    
    public List<E> levelOrder()
    {
        LinkedList<TreeNode<E>> nodes = new LinkedList<TreeNode<E>>();
        nodes.add(this.root);
        TreeNode<E> tempNode = new TreeNode<E>();
        
        for(int i = 0; i < size; i++)
        {
        	
        }
        	
        
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
