package binaryTree.linkBased;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        return contains(this.root, element);
    }
    
    private boolean contains(TreeNode<E> node, E element)
    {
    	if(node == null)
        	return false;

    	if(node.value.equals(element))
    		return true;
    	
        if(contains(node.left, element) || contains(node.right, element))
        	return true;
        	
        return false;
    }
    
    public abstract void add(E element);
    
    public List<E> levelOrder()
    {
       return levelOrder(true);     	    
    }
    
    public List<E> levelOrder(boolean includeNull)
    {      
    	List<E> nodes = new LinkedList<E>();
    	Queue<TreeNode<E>> nodeQ = new LinkedList<TreeNode<E>>();
    	TreeNode<E> tempNode = new TreeNode<E>();

    	nodeQ.offer(this.root);

    	while(nodeQ.size() != 0)
    	{
    		tempNode = nodeQ.poll();

    		if(includeNull)
    		{
    			if(tempNode == null)
    				nodes.add(null);
    			else
    			{
    				nodes.add(tempNode.value);
    				nodeQ.offer(tempNode.left);
    				nodeQ.offer(tempNode.right);
    			}
    		}
    		else
    		{
    			nodes.add(tempNode.value);
    			if(tempNode.left != null)
    				nodeQ.offer(tempNode.left);
    			if(tempNode.left != null)
    				nodeQ.offer(tempNode.right);
    		}
    	}
    	return nodes;       	    
    }
    
    public List<E> inOrder()
    {
    	List<E> stuff = new LinkedList<E>();
    	inOrder(root, stuff);
    	return stuff;
    }
    
    private void inOrder(TreeNode<E> node, List<E> elementsInOrder)
    {
    	if(node.left != null)
    		inOrder(node.left, elementsInOrder);
    	
    	elementsInOrder.add(node.value);
    	
    	if(node.right != null)
    		inOrder(node.right, elementsInOrder);
    }
    
    public List<E> preOrder()
    {
    	List<E> stuff = new LinkedList<E>();
    	preOrder(root, stuff);
    	return stuff;
    }
    
    private void preOrder(TreeNode<E> node, List<E> elementsPreOrder)
    {
    	elementsPreOrder.add(node.value);
    	
    	if(node.left != null)
    		preOrder(node.left, elementsPreOrder);
    	
    	if(node.right != null)
    		preOrder(node.right, elementsPreOrder);
    }
    
    public List<E> postOrder()
    {
    	List<E> stuff = new LinkedList<E>();
    	postOrder(root, stuff);
    	return stuff;
    }
    
    private void postOrder(TreeNode<E> node, List<E> elementsPostOrder)
    {
    	if(node.left != null)
    		postOrder(node.left, elementsPostOrder);
    	
    	if(node.right != null)
    		postOrder(node.right, elementsPostOrder);
    	
    	elementsPostOrder.add(node.value);
    }
}
