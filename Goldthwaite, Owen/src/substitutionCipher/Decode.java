package substitutionCipher;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import huffman.encoding.FrequencyTreeNode;

public class Decode 
{
	private String code;
	private Map<String, Integer> map;
	
	public Decode(String codeStuff)
	{
		this.code = codeStuff;
		this.map = new HashMap<String, Integer>();
		createMap(code);
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
	
	public Map<String, Double> updateMap(String msg)
	{
		createMap(msg);
		Map<String, Double> freqMap = new HashMap<String, Double>();
		
		for(int i = 0; i < map.size(); i++)
		{
			String letter = msg.charAt(i)+"";
			
			//divide freq in first map by total so you get a decimal value
		
		}
		
		return map;	
	}
	
	public Map<String, Double> getFreqMap()
	{
		return map;
	}
	
	
}
