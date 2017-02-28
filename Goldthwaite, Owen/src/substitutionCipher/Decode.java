package substitutionCipher;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import huffman.encoding.FrequencyTreeNode;

public class Decode 
{
	private String code;
	private String saveCode;
	private Map<String, Double> map;
	private int msgSize;
	
	public Decode(String codeStuff)
	{
		this.code = codeStuff;
		this.saveCode = codeStuff;
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
	
	public List<MapNode> makeFreqMap()
	{
		createMap(code);
		Map<String, Double> dMap = new HashMap<String, Double>();
		List<MapNode> freqs = new LinkedList<MapNode>();
		Set<MapNode> freqSet = new TreeSet<MapNode>();
		Set temp =  map.keySet();
		Iterator itr = temp.iterator();
		
		for(int i = 0; i < temp.size(); i++)
		{
			String key = (String) itr.next();
			dMap.put(key, (map.get(key)/msgSize));
			freqs.add(new MapNode(key+"", dMap.get(key)));	
		}			
		Collections.sort(freqs);
		
		return freqs;
	}
	
	public String editMsg()
	{
		Scanner scan = new Scanner(System.in);
		
		
		
		code = swapLetter(scan.nextLine();,scan.nextLine()) //Change all these things to chars in the swapLetter method
		
		
		return ;	
	}
	
	private String swapLetter(char toSwap, char swapLet)
	{
		char[] codeArray = new char[code.length()];
		String newCode = "";
		
		for(int k = 0; k < code.length(); k++)
			codeArray[k] = code.charAt(k);
		
		for(int i = 0; i < codeArray.length; i++)
		{
			if(codeArray[i] == toSwap)
				codeArray[i] = swapLet;
			
			newCode += codeArray[i];
		}

		return newCode;
	}

	
}
