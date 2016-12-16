package avlTree;

import java.util.List;

import junit.framework.TestCase;

public class Tester extends TestCase
{
    private AVLTree<Integer> tree;
    
    public void setUp()
    {
        tree = new AVLTree<Integer>();
    }
    
    public void tearDown()
    {
        tree = null;
    }
    
    public void testAddSimple()
    {
        addToTree(new int[]{13, 7, 15});
        check(3, "[13, 7, 15, null, null, null, null]");
    }
    
    public void testAddWithRightRotationToRebalance()
    {
        addToTree(new int[]{7, 5, 9, 3, 6});
        check(5, "[7, 5, 9, 3, 6, null, null, null, null, null, null]");
        
        tree.add(1);
        check(6, "[5, 3, 7, 1, null, 6, 9, null, null, null, null, null, null]");
    }
    
    public void testAddWithLeftRotationToBalance()
    {
        addToTree(new int[]{7, 5, 9, 3, 6, 11});
        check(6, "[7, 5, 9, 3, 6, null, 11, null, null, null, null, null, null]");
        
        tree.add(12);
        check(7, "[7, 5, 11, 3, 6, 9, 12, null, null, null, null, null, null, null, null]");
    }
    
    public void testAddWithRightLeftRotationToBalance()
    {
        addToTree(new int[]{7, 5, 9, 3, 6, 11});
        check(6, "[7, 5, 9, 3, 6, null, 11, null, null, null, null, null, null]");
        
        tree.add(10);
        check(7, "[7, 5, 10, 3, 6, 9, 11, null, null, null, null, null, null, null, null]");
    }
    
    public void testAddWithLeftRightRotationToBalance()
    {
        addToTree(new int[]{7, 5, 9, 3, 11});
        check(5, "[7, 5, 9, 3, null, null, 11, null, null, null, null]");
        
        tree.add(4);
       check(6, "[7, 4, 9, 3, 5, null, 11, null, null, null, null, null, null]");
    }
    
    public void testAddWithRebalanceAtRoot()
    {
        addToTree(new int[]{7, 5, 3});
        check(3, "[5, 3, 7, null, null, null, null]");
    }
    
    public void testRemoveWithRightLeftRotationToBalance()
    {
        addToTree(new int[]{10, 5, 15, 3, 13, 17, 11});
        check(7, "[10, 5, 15, 3, null, 13, 17, null, null, 11, null, null, null, null, null]");
        
        tree.remove(3);
        check(6, "[13, 10, 15, 5, 11, null, 17, null, null, null, null, null, null]");
    }
    
    private void addToTree(int[] values)
    {
        for(int value : values)
            tree.add(value);
    }
    
    private void check(int size, String expectedLevelOrder)
    {
        assertTrue(size == tree.size());
        List<Integer> levelOrder = tree.levelOrder();
        assertTrue(expectedLevelOrder.equals(levelOrder.toString()));
    }
}
