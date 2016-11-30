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
    
//    public boolean remove(E element)
//    {
//        
//    }
//    
//    /**
//     * @param node the root of the subtree from which to remove the element
//     * @param element the element to be removed
//     * @return the value to which the pointer previously pointing to node should point
//     */
//    protected TreeNode<E> remove(TreeNode<E> node, E element)
//    {
//        
//    }
//    
//    public E min()
//    {
//        
//    }
//    
//    private TreeNode<E> min(TreeNode<E> node)
//    {
//        
//    }
//    
//    public E max()
//    {
//        
//    }
//    
//    protected TreeNode<E> rotateRight(TreeNode<E> node)
//    {
//        
//    }
//    
//    protected TreeNode<E> rotateLeft(TreeNode<E> node)
//    {
//        
//    }
//    
//    protected TreeNode<E> rotateRightLeft(TreeNode<E> node)
//    {
//        
//    }
//    
//    protected TreeNode<E> rotateLeftRight(TreeNode<E> node)
//    {
//        
//    }
	}