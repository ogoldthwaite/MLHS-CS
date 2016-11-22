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
        List<E> nodes = new LinkedList<E>();
        Queue<TreeNode<E>> nodeQ = new LinkedList<TreeNode<E>>();
        TreeNode<E> tempNode = new TreeNode<E>();
        
        TreeNode<E> nodeNull = new TreeNode<E>();
        nodeNull.value = null;
        
        nodeQ.offer(this.root);
           
        while(nodeQ.size() != 0)
        {
        	tempNode = nodeQ.peek();
        	
        	System.out.println(tempNode);
        	
        	if(tempNode == null)
        		nodes.add(null);
        	else
        		nodes.add(nodeQ.poll().value);
        	
        	System.out.println(nodes.toString());
        	System.out.println(nodeQ.size());
        	
//        	nodeQ.offer(tempNode.left);
//        	nodeQ.offer(tempNode.right);

          if(tempNode.left != null)
        	nodeQ.offer(tempNode.left);
          if(tempNode.right != null)
        	nodeQ.offer(tempNode.right);
        }
		System.out.println(nodes.toString());
        
        return nodes;
        	
        
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
