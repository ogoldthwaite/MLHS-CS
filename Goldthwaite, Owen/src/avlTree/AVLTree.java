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
    	
    	return (AVLTreeNode<E>) super.add(node, element);
    }
    
    protected TreeNode<E> remove(TreeNode<E> node, E element)
    {
        
    }
    
    private void updateHeight(AVLTreeNode<E> node)
    {
    	AVLTreeNode<E> lNode = (AVLTreeNode<E>) node.left;
    	AVLTreeNode<E> rNode = (AVLTreeNode<E>) node.right;
    	
    	if(lNode.height >= rNode.height && lNode != null)
    		node.height = lNode.height;
    			
    	if(lNode.height <= rNode.height && rNode != null)
			node.height = rNode.height;
    			
    }
    
    private int balanceFactor(AVLTreeNode<E> node)
    {
        
    }

    // returns the reference that whatever previously pointed at node should now point
    private AVLTreeNode<E> rebalance(AVLTreeNode<E> node)
    {
        
    }
	
    // returns the value to which the pointer previously pointing to node
    // should now point
    protected AVLTreeNode<E> rotateRight(TreeNode<E> node)
    {
        
    }
    
    protected AVLTreeNode<E> rotateLeft(TreeNode<E> node)
    {
        
    }
}