package huffman.decoding;

public class HuffmanTree
{
    private TreeNode root;
    
    public String decodeMessage(String encodedMessage)
    {
        String msg = "";
    	
    	for(int i = 0; i < encodedMessage.length(); i++)
        {
        	if(encodedMessage.substring(i, i+1).equals(0))
        		root = root.left;
        	
        	if(encodedMessage.substring(i, i+1).equals(1))
        		root = root.right;
        	
        	
        	
        	
        }
    	
    	
    	
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
    	
    		if(encoding.substring(0,1).equals(0))
    			node = node.left;
    			
    		if(encoding.substring(0, 1).equals(1))
    			node = node.right;
    		
    		return insert(letter, encoding.substring(1), node);
    		
    }
}