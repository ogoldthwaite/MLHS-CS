package binaryTree.linkBased;

public class TreeNode<E>
{
    public E value;
    public TreeNode<E> left, right;
    
    public String toString()
    {
        String asString = "value: " + this.value + " left: ";
        
        asString += this.left == null ? null : left.value;
        asString += " right: ";
        asString += this.right == null ? null : right.value;
        
        return asString;
    }
}
