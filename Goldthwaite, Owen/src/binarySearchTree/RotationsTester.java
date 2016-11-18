package binarySearchTree;

import java.util.List;

import junit.framework.TestCase;

public class RotationsTester extends TestCase
{
    private BinarySearchTree<Integer> tree;
    
    public void setUp()
    {
        tree = new BinarySearchTree<Integer>();
    }
    
    public void tearDown()
    {
        tree = null;
    }
    
    public void testRightRotation()
    {
        tree.add(13);
        
        tree.add(7);
        tree.add(15);
        
        tree.add(5);
        tree.add(10);
        
        tree.add(3);
        
        check(6, "[13, 7, 15, 5, 10, null, null, 3, null, null, null, null, null]");
        
        tree.setRoot(tree.rotateRight(tree.getRoot()));
        
        check(6, "[7, 5, 13, 3, null, 10, 15, null, null, null, null, null, null]");
    }
    
    public void testLeftRotation()
    {
        tree.add(5);
        
        tree.add(3);
        tree.add(10);
        
        tree.add(7);
        tree.add(13);
        
        tree.add(15);
        
        check(6, "[5, 3, 10, null, null, 7, 13, null, null, null, 15, null, null]");
        
        tree.setRoot(tree.rotateLeft(tree.getRoot()));
        
        check(6, "[10, 5, 13, 3, 7, null, 15, null, null, null, null, null, null]");
    }
    
    public void testRightLeftRotation()
    {
        tree.add(5);
        
        tree.add(3);
        tree.add(13);
        
        tree.add(10);
        tree.add(15);
        
        tree.add(7);
        
        check(6, "[5, 3, 13, null, null, 10, 15, 7, null, null, null, null, null]");
        
        tree.setRoot(tree.rotateRightLeft(tree.getRoot()));
        
        check(6, "[10, 5, 13, 3, 7, null, 15, null, null, null, null, null, null]");
    }

    public void testLeftRightRotation()
    {
        tree.add(13);
        
        tree.add(5);
        tree.add(15);
        
        tree.add(3);
        tree.add(7);
        
        tree.add(10);
        
        check(6, "[13, 5, 15, 3, 7, null, null, null, null, null, 10, null, null]");
        
        tree.setRoot(tree.rotateLeftRight(tree.getRoot()));
        
        check(6, "[7, 5, 13, 3, null, 10, 15, null, null, null, null, null, null]");
    }
    
    private void check(int size, String expectedLevelOrder)
    {
//        assertTrue(size == tree.size()); // TODO: replace
        List<Integer> levelOrder = tree.levelOrder();
        assertTrue(expectedLevelOrder.equals(levelOrder.toString()));
    }
}
