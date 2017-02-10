package twentyQuestions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import binaryTree.linkBased.TreeNode;

import java.io.*;

public class Question 
{
	private TreeNode<String> root;
	
	public Question(String rootValue)
	{
		root = new TreeNode<String>();	
		root.value = rootValue;
	}
	
	public Question(String rootValue, String leftValue, String rightValue)
	{
		root = new TreeNode<String>();	
		root.value = rootValue;
		root.left = new TreeNode<String>();
		root.left.value = leftValue;
		root.right = new TreeNode<String>();
		root.right.value = rightValue;

	}

	public Question() throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("files/questionTree.txt"));
		
		root = makeTree(root, scan);
	}
	
	private TreeNode<String> makeTree(TreeNode<String> node, Scanner scan)
	{
		if(node == null)
		{
			node = new TreeNode<String>();
			node.value = scan.nextLine();
		}
		
		node.left = makeTree(node.left, scan);
		
		node.right = makeTree(node.right, scan);
		
		
		return null;
	}
	
	
	
	public void solve() throws FileNotFoundException
	{
		waitSec();
		System.out.println("Let's play a new game of twenty questions!");
		System.out.println();
		
		solve(root);
		saveToFile();
	}
	
	private void solve(TreeNode<String> node) throws FileNotFoundException
	{
		Scanner scan = new Scanner(System.in);
		
		boolean isLeaf = false;

		if(node.left == null && node.right == null)
			isLeaf = true;

		System.out.println(node.value +"?");
		String input = scan.nextLine();

		if(input.equals("Quit"))
		{
			System.out.println("Game Ended!");
			return;
			
		}

		if(input.startsWith("y") || input.startsWith("Y"))
		{
			if(isLeaf == true)
			{
				System.out.println("It is a " + node.value + "!");
				solve();
			}
			else
				solve(node.left);
		}

		if(input.startsWith("n") || input.startsWith("N"))
		{
			if(isLeaf == true)
			{
				node.right = new TreeNode<String>();
				node.right.value = node.value;
				System.out.println("What were you really thinking of?");
				System.out.print("A ");
				node.left = new TreeNode<String>();
				node.left.value = scan.nextLine();
				System.out.println("What distinguishes a " + node.right.value + " from a " + node.left.value +"?");
				System.out.print("A " + node.left.value + " :");
				node.value = scan.nextLine();
				solve();
			}
			else
				solve(node.right);
		}

	}
	
	public void saveToFile() throws FileNotFoundException
	{
		File saveFile = new File("files/questionTree.txt");
		PrintWriter out = new PrintWriter(saveFile);
		List<String> tree = preOrder();
		out.println(tree);		
		out.close();
		
	}
	
	public List<String> preOrder()
    {
    	List<String> stuff = new LinkedList<String>();
    	preOrder(root, stuff);
    	return stuff;
    }
    
    private void preOrder(TreeNode<String> node, List<String> elementsPreOrder)
    {
    	elementsPreOrder.add(node.value);
    	
    	if(node == null)
    		elementsPreOrder.add("-");
    	
    	if(node.left != null)
    		preOrder(node.left, elementsPreOrder);
    	
    	if(node.right != null)
    		preOrder(node.right, elementsPreOrder);
    }

	private void waitSec()
	{
		try
		{
		System.out.println();
		Thread.sleep(100);
		}
		catch(InterruptedException e)
		{
					
		}
				
	}
	
	
}
