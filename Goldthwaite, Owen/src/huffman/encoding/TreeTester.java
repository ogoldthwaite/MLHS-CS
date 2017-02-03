package huffman.encoding;

import java.util.Map;
import java.util.PriorityQueue;

public class TreeTester {

	public static void main(String[] args) 
	{
		MessageFrequency freq = new MessageFrequency();
		PriorityQueue<FrequencyTreeNode> bob = freq.makeQueue("hey there");
		System.out.println(bob.peek().letter);
		
		HuffmanTree spruce = new HuffmanTree(bob);
		  Map<Character, String> scheme = spruce.encodingScheme();
		  System.out.println(scheme);

	}

}
