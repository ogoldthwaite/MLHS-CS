package ab_2008_1;

import java.util.*;

public class AnagramGrouper
{
	public AnagramGrouper(List<String> words)
	{
		groups = new HashMap<String, HashSet<String>>();
		ListIterator<String> itr = words.listIterator();
		//HashSet<String> tempSet = new HashSet<String>();
		String temp;
		
		while(itr.hasNext())
		{
			HashSet<String> tempSet = new HashSet<String>();
			temp = itr.next();
			tempSet.add(temp);
			
			for(int i = 0; i < words.size(); i++)
				if(createKeyString(temp).equals(createKeyString(words.get(i))))
					tempSet.add(words.get(i));
			
			groups.put(createKeyString(temp), tempSet);
					
		}

	}

	public HashSet<HashSet<String>> findLargestSets()
	{
	
		
		
		return null; 
	}
	
	// do not modify code below
	
	public HashMap<String, HashSet<String>> groups;

	public static String createKeyString(String s)
	{
	    char[] letters = s.toCharArray();
	    Arrays.sort(letters);
	    
	    String keyString = "";
	    for(char letter : letters)
	        keyString += letter;
	    
	    return keyString;
	}
}
