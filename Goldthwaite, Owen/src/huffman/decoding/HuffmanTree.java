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

			while(node != null)
			{
				if(encodedMessage.substring(i, i+1).equals(0))
					node = node.left;

				if(encodedMessage.substring(i, i+1).equals(1))
					node = node.right;

				i++;
			}

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
			node.letter = letter+"";
			return node;
		}

		if(encoding.substring(0,1).equals("0"))
			node.left = insert(letter, encoding.substring(1), node.left);

		if(encoding.substring(0, 1).equals("1"))
			node.right = insert(letter, encoding.substring(1), node.right);

		return node;

	}
}