package binaryTree.arrayBased;

import java.util.ArrayList;

public class TestStuff {

	public static void main(String[] args) 
	{
		ArrayList<Integer> bob = new ArrayList<Integer>();
		bob.add(1);
		bob.add(2);
		bob.add(3);
		bob.add(4);
		bob.add(5);
		bob.add(6);
		bob.add(7);
		
		ArrayBinaryTree bobster = new ArrayBinaryTree(bob);
		System.out.println(bobster.levelOrder());
		System.out.println(bobster.inOrder());
		System.out.println(bobster.preOrder());
		System.out.println(bobster.postOrder());

	}

}
