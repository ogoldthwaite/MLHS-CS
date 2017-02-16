package substitutionCipher;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import huffman.encoding.FrequencyTreeNode;

public class Decode 
{
	private String code;
	private Map<String, Double> map;
	private int msgSize;
	
	public Decode(String codeStuff)
	{
		this.code = codeStuff;
		this.msgSize = code.length();
		this.map = new HashMap<String, Double>();
	}
	
	private void createMap(String msg)
	{
		for(int i = 0; i < msg.length(); i++)
		{
			String letter = msg.charAt(i)+"";
			if(map.containsKey(letter))
				map.put(letter, map.get(letter) + 1.0);
			else
				map.put(letter, 1.0);
		}	
	}
	
	public Map<String, Double> makeFreqMap()
	{
		createMap(code);
		Map<String, Double> dMap = new HashMap<String, Double>();
		Set temp =  map.keySet();
		Iterator itr = temp.iterator();
		
		for(int i = 0; i < temp.size(); i++)
		{
			String key = (String) itr.next();
			dMap.put(key, (map.get(key)/msgSize));
		}
		
		return dMap;
	}
	 //Remove spaces
	
	public Map<String, Double> getCountMap()
	{
		return map;
	}
	
	
}
