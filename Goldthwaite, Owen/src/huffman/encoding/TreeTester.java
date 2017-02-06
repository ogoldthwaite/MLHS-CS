package huffman.encoding;

import java.util.Map;
import java.util.PriorityQueue;

public class TreeTester {

	public static void main(String[] args) 
	{
		MessageFrequency freq = new MessageFrequency();
		PriorityQueue<FrequencyTreeNode> bob = freq.makeQueue("yo_yo_what_up");
		
		HuffmanTree spruce = new HuffmanTree(bob);
		  Map<Character, String> scheme = spruce.encodingScheme();
		  System.out.println(scheme);
		  
		  System.out.println(spruce.encodeLetter('h', scheme));
		  
		  System.out.println(makeMessage("yo_yo_what_up", scheme));
	}

	
	public static String makeMessage(String msg,  Map<Character, String> scheme)
	{
		String toReturn = "";
		
		for(int i = 0; i < msg.length(); i++)
			toReturn += scheme.get(msg.charAt(i));
		
		return toReturn;
	}
	
}
