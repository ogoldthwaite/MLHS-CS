package avlTree;

import binarySearchTree.BinarySearchTree;
import binaryTree.linkBased.TreeNode;

public class AVLTree<E extends Comparable<? super E>> extends BinarySearchTree<E>
{
    protected AVLTreeNode<E> constructNewNode(E element)
    {
    	AVLTreeNode<E> newNode = new AVLTreeNode<E>();
		newNode.value = element;

		return newNode;
    }
    
    protected AVLTreeNode<E> add(TreeNode<E> node, E element)
    {	
    	AVLTreeNode<E> tempNode = constructNewNode(super.add(node, element).value);
    	return rebalance((AVLTreeNode<E>) tempNode);
    			
    }
    
//    protected TreeNode<E> remove(TreeNode<E> node, E element)
//    {
//        
//    }
    
    private void updateHeight(AVLTreeNode<E> node)
    {
    	AVLTreeNode<E> lNode = (AVLTreeNode<E>) node.left;
    	AVLTreeNode<E> rNode = (AVLTreeNode<E>) node.right;   	
    	
    	if(lNode == null && rNode == null)
    		node.height = 0;
    	else
    	{
    		if(rNode == null || rNode.height <= lNode.height)// && lNode != null)
    		node.height = lNode.height + 1;
    			
    		if(lNode == null || lNode.height <= rNode.height)// && rNode != null)
			node.height = rNode.height + 1;
    	}		
    }
    
    private int balanceFactor(AVLTreeNode<E> node)
    {
    	int lHeight = 0;
    	int rHeight = 0;
    	AVLTreeNode<E> lNode = (AVLTreeNode<E>) node.left;
    	AVLTreeNode<E> rNode = (AVLTreeNode<E>) node.right;

    	if(lNode != null)
    		lHeight = lNode.height + 1;

    	if(rNode != null)
    		rHeight = rNode.height + 1;

    	return rHeight - lHeight;

    }

    // returns the reference that whatever previously pointed at node should now point
    private AVLTreeNode<E> rebalance(AVLTreeNode<E> node)
    {
    	updateHeight(node);
    	AVLTreeNode<E> lNode = (AVLTreeNode<E>) node.left;
    	AVLTreeNode<E> rNode = (AVLTreeNode<E>) node.right;
    	int balFact = balanceFactor(node);
    	
    	if(balFact <= -2)
    		if(-1 == balanceFactor(lNode))
    			rotateRight(node);
    		else if(1 == balanceFactor(rNode))
    		{
    			node.left = rotateLeft(node.left);
    			rotateRight(node);
    		}	
    	
    	
    	if(balFact >= 2)
    		if(1 == balanceFactor(rNode))
    			rotateLeft(node);
    		else if(-1 == balanceFactor(rNode))
    		{
    			node.right = rotateRight(node.right);
    			rotateLeft(node);
    		}	
    	updateHeight(node);
    	return node;
    }
	
    // returns the value to which the pointer previously pointing to node
    // should now point
    protected AVLTreeNode<E> rotateRight(TreeNode<E> node)
    {
    	AVLTreeNode<E> coolNode = (AVLTreeNode<E>) super.rotateRight(node);
    	updateHeight(coolNode);
    	updateHeight((AVLTreeNode<E>) node);
    	
    	return coolNode;
    }
    
    protected AVLTreeNode<E> rotateLeft(TreeNode<E> node)
    {
        AVLTreeNode<E> superCoolNode = (AVLTreeNode<E>) super.rotateLeft(node);
        updateHeight(superCoolNode);
        updateHeight((AVLTreeNode<E>) node);
	
        return superCoolNode;
    }
}