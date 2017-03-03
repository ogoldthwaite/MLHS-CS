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
	private List<MapNode> freqs;
	private Map<String, Double> map;
	private Map<String, String> keyMap;
	private int msgSize;

	public Decode(String codeStuff)
	{
		this.code = codeStuff;
		this.saveCode = codeStuff;
		this.msgSize = code.length();
		freqs = new LinkedList<MapNode>();
		this.keyMap = new HashMap<String, String>();
		this.map = new HashMap<String, Double>();
		makeKeyMap();
	}

	private void createMap(String msg)
	{
		for(int i = 0; i < msg.length(); i++)
		{
			{
				String letter = msg.charAt(i)+"";
				if(map.containsKey(letter))
					map.put(letter, map.get(letter) + 1.0);
				else
					map.put(letter, 1.0);
			}

		}	
	}

	public List<MapNode> makeFreqMap()
	{	
		createMap(code);
		Map<String, Double> dMap = new HashMap<String, Double>();
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

		System.out.println("Do you want to change everything to most frequent letters?");
		if(yesNo());
		{
			loadMostFreq();
			code = swapAll();
			System.out.println(code);
		}

		while(again)
		{
			System.out.println("Enter letter you want to change followed by the letter you want to swap it with!");

			code = swapLetter(scan.nextLine().charAt(0)+"" , scan.nextLine().toUpperCase().charAt(0)+""); //Change all these things to chars in the swapLetter method

			System.out.println(code);
			saveToFile();
			again = yesNo();
		}
		scan.close();
		return code;
	}

	private String swapLetter(String toSwap, String swapLet)
	{
		char[] codeArray = new char[code.length()];
		String newCode = "";
		keyMap.put(toSwap+"",swapLet.toLowerCase());

		for(int k = 0; k < code.length(); k++)
			codeArray[k] = code.charAt(k);

		for(int i = 0; i < codeArray.length; i++)
		{
			if(codeArray[i] == toSwap.charAt(0))
				codeArray[i] = swapLet.charAt(0);

			newCode += codeArray[i];
		}

		System.out.println(keyMap);
		return newCode;
	}

	public void loadMostFreq()
	{
		String mostFreqLets = "EARIOTNSLCUDPMHGBFYWKVXZJC";
		int count = 0;

		for(int i = 0; i < freqs.size(); i++)
		{
			if(Character.isLetter(freqs.get(i).letter.charAt(0)))
			{
				keyMap.put(freqs.get(i).letter, mostFreqLets.charAt(count)+"".toLowerCase());
				count++;
				//System.out.println(keyMap);
			}
		}

	}

	public String swapAll()
	{
		char[] codeArray = new char[code.length()];
		String newCode = "";

		for(int k = 0; k < code.length(); k++)
			codeArray[k] = code.charAt(k);

		for(int i = 0; i < code.length(); i++)
		{
			if(keyMap.containsKey(code.charAt(i)+""))
			{
				codeArray[i] = keyMap.get(code.charAt(i)+"").charAt(0);
	
			}
			newCode += codeArray[i];
		}
										//MAke sure set method thing works!!
		System.out.println(keyMap);
		System.out.println(newCode);
		return newCode;
	}

	private void saveToFile() throws FileNotFoundException 
	{
		File saveFile = new File("files/brokenCode.txt");
		PrintWriter out = new PrintWriter(saveFile);
		String toPrint = "";
		int count = 0;

		for(int i = 0; i < code.length(); i++)
		{
			toPrint += code.charAt(i);

			if(toPrint.length() >= 60)
			{
				out.println(toPrint);
				out.flush();
				toPrint = "";
			}
		}

		out.print(toPrint);
		out.flush();

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

	private void makeKeyMap()
	{
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for(int i = 0; i < alphabet.length(); i++)
			keyMap.put(alphabet.charAt(i)+"", alphabet.charAt(i)+"");
	}

}

