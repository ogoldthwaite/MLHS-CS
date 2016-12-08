package binarySearchTree;

import binaryTree.linkBased.LinkedBinaryTree;
import binaryTree.linkBased.TreeNode;

public class BinarySearchTree<E extends Comparable<? super E>> extends LinkedBinaryTree<E>
{
	// provides access to the root for testing
	TreeNode<E> getRoot()
	{
		return this.root;
	}

	// provides access to the root for testing
	void setRoot(TreeNode<E> newRoot)
	{
		this.root = newRoot;
	}

	public boolean contains(E element)
	{
		return contains(this.root, element);
	}

	private boolean contains(TreeNode<E> node, E element) //rewrite this stuff. Hopefully I remember
	{
		if(node == null)
			return false;

		if(node.value.equals(element))
			return true;

		if(contains(node.left, element) || contains(node.right, element))
			return true;

		return false;
	}

	@Override
	public void add(E element)
	{
		root = add(getRoot(), element);
		size++;
	}

	protected TreeNode<E> constructNewNode(E element)
	{
		TreeNode<E> newNode = new TreeNode<E>();
		newNode.value = element;

		return newNode;
	}

	/**
	 * @param node the root of the subtree to which to add the element
	 * @param element the element to be added
	 * @return the value to which the pointer previously pointing to node should point
	 */
	protected TreeNode<E> add(TreeNode<E> node, E element)
	{	
		if(node == null)
			return constructNewNode(element);

		if(element.compareTo(node.value) < 0)
			node.left = add(node.left, element);
		else
			node.right = add(node.right, element);

		return node;
	}

	public boolean remove(E element)
	{
		boolean stuff = contains(element);
		remove(getRoot(), element);
		size--;
		return stuff;
		
		
	}

	/**
	 * @param node the root of the subtree from which to remove the element
	 * @param element the element to be removed
	 * @return the value to which the pointer previously pointing to node should point
	 */
	protected TreeNode<E> remove(TreeNode<E> node, E element)
	{
		if(node == null)
			return null;

		if(element.compareTo(node.value) < 0)
			node.left = remove(node.left, element);
		else if(element.compareTo(node.value) > 0)
			node.right = remove(node.right, element);
		else
		{
			if(node.left == null)
			{
				if(node.right != null)
				{
					return node.right;
				}
				  else
					return null;
					
			}
			else if(node.right == null)
			{
					return node.left;
			}
			else //Two Children
			{
				TreeNode<E> swapNode = node.right;
				E storeVal = node.value;
				
				while(swapNode.left != null)
				{
					swapNode = swapNode.left;
				}
								
				node.value = swapNode.value;
				swapNode.value = storeVal;		
				 
				node.right = remove(node.right, element);
			}
			
		}
		return node;
	}
    
	public E min()
	{
		return min(getRoot()).value;
	}

	private TreeNode<E> min(TreeNode<E> node)
	{
		if(node.left != null)  
			min(node.left);
		
		return node;
	}
    
    public E max()
    {
    	TreeNode<E> tempNode = new TreeNode<E>();
    	tempNode = getRoot();
    	
    	while(tempNode.right != null)
    		tempNode = tempNode.right;
    	
    	return tempNode.value;
    }
    
    protected TreeNode<E> rotateRight(TreeNode<E> node)
    {
    	TreeNode<E> tempNode = new TreeNode<E>();
    	TreeNode<E> pastRoot = new TreeNode<E>();
    	pastRoot = node;
    	tempNode = node.left.right; 
    	
    	node = node.left;
    	node.right = pastRoot;
    	node.right.left = tempNode;
    	
    	return node;
    }
    
    protected TreeNode<E> rotateLeft(TreeNode<E> node)
    {
    	TreeNode<E> tempNode = new TreeNode<E>();
    	TreeNode<E> pastRoot = new TreeNode<E>();
    	pastRoot = node;
    	tempNode = node.right.left; 
    	
    	node = node.right;
    	node.left = pastRoot;
    	node.left.right = tempNode;
    	
    	return node;
    }
    
    protected TreeNode<E> rotateRightLeft(TreeNode<E> node)
    {	
    	node.right = rotateRight(node.right);
       return rotateLeft(node);
    }
    
    protected TreeNode<E> rotateLeftRight(TreeNode<E> node)
    {
    	node.left = rotateLeft(node.left);
        return rotateRight(node);
    }
	}