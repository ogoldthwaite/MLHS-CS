package huffman.encoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MessageFrequency 
{
	private Map<String, Integer> map;
	
	public MessageFrequency()
	{
		map = new HashMap<String, Integer>();
	}
	
	private void createMap(String msg)
	{
		for(int i = 0; i < msg.length(); i++)
		{
			String letter = msg.charAt(i)+"";
			if(map.containsKey(letter))
				map.put(letter, map.get(letter) + 1);
			else
				map.put(letter, 1);
		}
	
	}
	
	public PriorityQueue<FrequencyTreeNode> makeQueue(String msg)
	{
		createMap(msg);
		PriorityQueue<FrequencyTreeNode> qq = new PriorityQueue<FrequencyTreeNode>();
		
		for(int i = 0; i < msg.length(); i++)
		{	
			FrequencyTreeNode node = new FrequencyTreeNode(msg.charAt(i), map.get(msg.charAt(i)+""));
			qq.add(node);
		}
		
		return qq;
				
	}
	
	
	
	
	
	
}
