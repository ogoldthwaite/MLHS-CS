package twentyQuestions;

import java.util.Scanner;

public class Question 
{
	private TreeNode root;
	
	public Question(String rootValue)
	{
		root = new TreeNode(rootValue);	
	}
	
	public Question(String rootValue, String leftValue, String rightValue)
	{
		root = new TreeNode(rootValue);	
		root.left = new TreeNode(leftValue);
		root.right = new TreeNode(rightValue);

	}
	
	public void solve()
	{
		solve(root);
	}
	
	private void solve(TreeNode node)
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
				node.right = new TreeNode(node.value);
				System.out.println("What were you really thinking of?");
				node.left = new TreeNode(scan.nextLine());
				System.out.println("What distinguishes a " + node.right.value + " from a " + node.left.value +"?");
				System.out.print("A " + node.left.value + " :");
				node.value = scan.nextLine();
				solve(root);
			}
			else
				solve(node.right);

		}





	}

	
}
