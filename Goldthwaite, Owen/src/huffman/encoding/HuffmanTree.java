package huffman.encoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanTree
{
    private FrequencyTreeNode root;
    
    public HuffmanTree(PriorityQueue<FrequencyTreeNode> pq)
    {
        while(pq.size() > 1)
        {
        	FrequencyTreeNode rNode = pq.poll();
        	FrequencyTreeNode lNode = pq.poll();
        	FrequencyTreeNode node = new FrequencyTreeNode('-', rNode.frequency + lNode.frequency);
        	node.right = rNode;
        	node.left = lNode;
        			pq.add(node);
        }
    	
    	root = pq.poll();
    	
    }
    
    public String encodeLetter(char letter)
    {
    	String returnString = encodeLetter(letter, root);
    	
        return returnString;
    }
    
    private String encodeLetter(char letter, FrequencyTreeNode node)
    {
        
    	
    	
    	
    }
    
    // returns a map of characters to encodings
    public Map<Character, String> encodingScheme()
    {
        Map<Character, String> scheme = new HashMap<Character, String>();
        
        encodingScheme(root, "", scheme);
        
        return scheme;
        
    }
    
    private void encodingScheme(FrequencyTreeNode node, String route, Map<Character, String> scheme)
    {
        if(node.letter == '-')
        {
        	if(node.left != null)
        		encodingScheme(node.left, route + "0", scheme);
        	if(node.right != null)
        		encodingScheme(node.right, route + "1", scheme);
        }
        
        if(node.letter != '-')
        	scheme.put(node.letter, route);
    }
}
