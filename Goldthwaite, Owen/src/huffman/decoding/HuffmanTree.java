package huffman.decoding;

public class HuffmanTree
{
	private TreeNode root;

	public String decodeMessage(String encodedMessage)
	{
		String msg = "";
		TreeNode node = root;
		int i = 0;
		

		for(int k = 0; k < encodedMessage.length(); k++)
		{

			while(node.left != null && node.right != null && i < encodedMessage.length())
			{
				if(encodedMessage.substring(i, i+1).equals("0"))
					node = node.left;

				if(encodedMessage.substring(i, i+1).equals("1"))
					node = node.right;

				i++;
			}
			
			if(node.letter != null)
				msg += node.letter;
			
			node = root;
		}

		return msg;

	}

	public void insert(char letter, String encoding)
	{
		root = insert(letter, encoding, root);
	}

	// returns new root
	private static TreeNode insert(char letter, String encoding, TreeNode node)
	{

		if(encoding.length() == 0)
		{
			return new TreeNode(letter + "");
//			node.letter = letter+"";
//			return node;
		}

		if(node == null)
			node = new TreeNode(null);
		
		if(encoding.substring(0,1).equals("0"))
			node.left = insert(letter, encoding.substring(1), node.left);

		if(encoding.substring(0, 1).equals("1"))
			node.right = insert(letter, encoding.substring(1), node.right);

		return node;

	}
}