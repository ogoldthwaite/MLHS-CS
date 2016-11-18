package binaryTree.linkBased;

public class TestableLinkedBinaryTree<E> extends LinkedBinaryTree<E>
{
    public void setRoot(TreeNode<E> newRoot)
    {
        this.root = newRoot;
    }
    
    public void setSize(int newSize)
    {
        this.size = newSize;
    }
    
    @Override
    public void add(E element)
    {
        throw new UnsupportedOperationException();
    }
}
