package substitutionCipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import huffman.encoding.FrequencyTreeNode;

public class Decode 
{
	private String code;
	private String saveCode;
	private Map<String, Double> map;
	private Map<String, String> keyMap;
	private int msgSize;

	public Decode(String codeStuff)
	{
		this.code = codeStuff;
		this.saveCode = codeStuff;
		this.msgSize = code.length();
		this.keyMap = new HashMap<String, String>();
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

	public String editMsg() throws FileNotFoundException
	{
		Scanner scan = new Scanner(System.in);
		boolean again = true;
		File saveFile = new File("files/brokenCode.txt");
		PrintWriter out = new PrintWriter(saveFile);

		while(again)
		{

			System.out.println("Enter letter you want to change followed by the letter you want to swap it with!");

			code = swapLetter(scan.nextLine().charAt(0) ,scan.nextLine().toUpperCase().charAt(0)); //Change all these things to chars in the swapLetter method

			System.out.println(code);
			out.print(code);
			out.flush();
			again = yesNo();
		}
		
		
		return code;	
	}

	private String swapLetter(char toSwap, char swapLet)
	{
		char[] codeArray = new char[code.length()];
		String newCode = "";
		keyMap.put(swapLet+"", toSwap+"");

		for(int k = 0; k < code.length(); k++)
			codeArray[k] = code.charAt(k);

		for(int i = 0; i < codeArray.length; i++)
		{
			if(codeArray[i] == toSwap)
				codeArray[i] = swapLet;

			newCode += codeArray[i];
		}
		
		System.out.println(keyMap);
		return newCode;
	}

	private boolean yesNo()
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("Perform Action Again? Y/N");
		boolean again = true;

		if(scan.nextLine().startsWith("Y") || scan.nextLine().startsWith("y"))
			return true;
		else
			return false;
	}

}

