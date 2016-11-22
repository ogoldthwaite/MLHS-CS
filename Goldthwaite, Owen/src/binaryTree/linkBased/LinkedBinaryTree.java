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
        LinkedList<TreeNode<E>> nodes = new LinkedList<TreeNode<E>>();
        Queue<TreeNode<E>> nodeQ = new LinkedList<TreeNode<E>>();
        TreeNode<E> NodeL = new TreeNode<E>();
        TreeNode<E> NodeR = new TreeNode<E>();
        
        nodeQ.offer(this.root);
        NodeL = root.left;
        NodeR = root.right;
        
        while(nodeQ.size() != 0)
        {
        	//Add something from queue to list, add it's kids to the queue.
        	
        	nodeQ.offer(NodeL);
        	nodeQ.offer(NodeR);
        	
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
