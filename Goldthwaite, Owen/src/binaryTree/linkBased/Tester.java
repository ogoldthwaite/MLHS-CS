package binaryTree.linkBased;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class Tester extends TestCase
{
    private TestableLinkedBinaryTree<Integer> tree;
    
    public void setUp()
    {
        List<TreeNode<Integer>> nodes = new ArrayList<TreeNode<Integer>>();
        for(int i = 0; i <= 11; i++)
        {
            TreeNode<Integer> node = new TreeNode<Integer>();
            node.value = i;
            nodes.add(node);
        }
        
        // level 0
        
        nodes.get(2).left = nodes.get(7);
        nodes.get(2).right = nodes.get(5);
        
        
        // level 1
        
        nodes.get(7).left = nodes.get(3);
        nodes.get(7).right = nodes.get(6);
        
        nodes.get(5).right = nodes.get(9);
        
        
        // level 2
        nodes.get(6).left = nodes.get(1);
        nodes.get(6).right = nodes.get(11);
        
        nodes.get(9).left = nodes.get(4);
        
        
        tree = new TestableLinkedBinaryTree<Integer>();
        tree.setRoot(nodes.get(2));
        tree.setSize(9);
    }
    
    public void tearDown()
    {
        tree = null;
    }
    
    public void testLevelOrder()
    {
        assertTrue(9 == tree.size());
        List<Integer> levelOrder = tree.levelOrder();
        assertTrue(levelOrder.toString().equals("[2, 7, 5, 3, 6, null, 9, null, null, 1, 11, 4, null, null, null, null, null, null, null]"));
    }
    
    public void testPreOrder()
    {
        assertTrue(9 == tree.size());
        List<Integer> preOrder = tree.preOrder();
        assertTrue(preOrder.toString().equals("[2, 7, 3, 6, 1, 11, 5, 9, 4]"));
    }
    
    public void testPostOrder()
    {
        assertTrue(9 == tree.size());
        List<Integer> postOrder = tree.postOrder();
        assertTrue(postOrder.toString().equals("[3, 1, 11, 6, 7, 4, 9, 5, 2]"));
    }
    
    public void testInOrder()
    {
        assertTrue(9 == tree.size());
        List<Integer> inOrder = tree.inOrder();
        assertTrue(inOrder.toString().equals("[3, 7, 1, 6, 11, 2, 5, 4, 9]"));
    }
}
