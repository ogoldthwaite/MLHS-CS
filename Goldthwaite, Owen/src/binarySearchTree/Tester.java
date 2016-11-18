package binarySearchTree;

import java.util.List;

import junit.framework.TestCase;

public class Tester extends TestCase
{
    private BinarySearchTree<Integer> tree;
    
    public void setUp()
    {
        tree = new BinarySearchTree<Integer>();
        
        tree.add(8);
        
        tree.add(3);
        tree.add(10);
        
        tree.add(1);
        tree.add(6);
        tree.add(14);
        
        tree.add(4);
        tree.add(7);
        tree.add(13);
        
        check(9, "[8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13, null, null, null, null, null, null, null]");
    }
    
    public void tearDown()
    {
        tree = null;
    }
    
    public void testAdd()
    {
        // setUp() already tests add
    }
    
    public void testAddDuplicates()
    {
        tree.add(1);
        check(10, "[8, 3, 10, 1, 6, null, 14, null, 1, 4, 7, 13, null, null, null, null, null, null, null, null, null]");
        
        tree.add(8);
        check(11, "[8, 3, 10, 1, 6, 8, 14, null, 1, 4, 7, null, null, 13, null, null, null, null, null, null, null, null, null]");
    }
    
    public void testRemoveLeaf()
    {
        tree.remove(1);
        check(8, "[8, 3, 10, null, 6, null, 14, 4, 7, 13, null, null, null, null, null, null, null]");
    }
    
    public void testRemoveWith1Child()
    {
        tree.remove(14);
        check(8, "[8, 3, 10, 1, 6, null, 13, null, null, 4, 7, null, null, null, null, null, null]");
    }
    
    public void testRemoveWith2Children()
    {
        tree.remove(8);
        check(8, "[10, 3, 14, 1, 6, 13, null, null, null, 4, 7, null, null, null, null, null, null]");
    }
    
    public void testContains()
    {
        int[] values = new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13};
        for(int value : values)
            assertTrue(tree.contains(value));
        
        int[] notValues = new int[]{0, 2, 9, 11, 12, 15};
        for(int notValue : notValues)
            assertTrue(!tree.contains(notValue));
    }
    
    private void check(int size, String expectedLevelOrder)
    {
        assertTrue(size == tree.size());
        List<Integer> levelOrder = tree.levelOrder();
        assertTrue(expectedLevelOrder.equals(levelOrder.toString()));
    }
}
