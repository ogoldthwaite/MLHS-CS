package caeserCipher;
import java.util.*;
import java.io.*;

public class Decode 
{	
	private String toDecode;

	public Decode(String code)
	{
		toDecode = code;
	}

	public String breakCode()
	{
		String answer = toDecode;
		String storeCode = toDecode;
		int maxValid = validWordCount(storeCode);
		
		for(int i = 0; i < 27; i++)
		{

			if(validWordCount(toDecode) > maxValid)
			{
				answer = toDecode;
				maxValid = validWordCount(toDecode);
			}
			
			shift();
		}

		toDecode = storeCode; //toDecode back to original

		return answer;
	}

	private int validWordCount(String toTest) //returns the number of how many words are English words in a given string
	{
		int validWordCount = 0;

		String[] words = toTest.split(" ");

		for(int i = 0; i < words.length; i++)
		{
			if(compareToDict(words[i]))
				validWordCount++;
		}

		return validWordCount;
	}


	private void shift()
	{
		String[] codePieces = toDecode.split(""); 
		int[] pieceVals = getPieceValues(codePieces);

		for(int i = 0; i < pieceVals.length; i++)
		{
			if(pieceVals[i] == 420)
			{  
				//empty on purpose	
			}
			else 
			{
				pieceVals[i] = pieceVals[i] + 1;
				if(pieceVals[i] > 25)
					pieceVals[i] = pieceVals[i] % 26;
			}

		}
		codePieces = getCharValues(pieceVals);
		String coolString = "";
		for(int k = 0; k < codePieces.length; k++)
			coolString += codePieces[k];

		toDecode = coolString;	
	}

	private boolean compareToDict(String toTest) //returns true if toTest is a word, false otherwise
	{
		HashSet<String> dictionary =  new HashSet<String>();

		try {
			//Scanner scan = new Scanner(new File("/users/Owen/Documents/Dict/"));
			Scanner scan = new Scanner(new File("/usr/share/dict/words"));

			while(scan.hasNextLine())
				dictionary.add(scan.nextLine());
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}

		if(dictionary.contains(toTest))
			return true;
		else
			return false;

	}


	private int[] getPieceValues(String[] pieces)  //used in shift method
	{
		int[] pieceVals = new int[pieces.length];

		for(int i = 0; i < pieces.length; i++)
		{
			if (pieces[i].equalsIgnoreCase("a"))
				pieceVals[i] = 0;
			else if (pieces[i].equalsIgnoreCase("b"))
				pieceVals[i] = 1;
			else if (pieces[i].equalsIgnoreCase("c"))
				pieceVals[i] = 2;
			else if (pieces[i].equalsIgnoreCase("d"))
				pieceVals[i] = 3;
			else if (pieces[i].equalsIgnoreCase("e"))
				pieceVals[i] = 4;
			else if (pieces[i].equalsIgnoreCase("f"))
				pieceVals[i] = 5;
			else if (pieces[i].equalsIgnoreCase("g"))
				pieceVals[i] = 6;
			else if (pieces[i].equalsIgnoreCase("h"))
				pieceVals[i] = 7;
			else if (pieces[i].equalsIgnoreCase("i"))
				pieceVals[i] = 8;
			else if (pieces[i].equalsIgnoreCase("j"))
				pieceVals[i] = 9;
			else if (pieces[i].equalsIgnoreCase("k"))
				pieceVals[i] = 10;
			else if (pieces[i].equalsIgnoreCase("l"))
				pieceVals[i] = 11;
			else if (pieces[i].equalsIgnoreCase("m"))
				pieceVals[i] = 12;
			else if (pieces[i].equalsIgnoreCase("n"))
				pieceVals[i] = 13;
			else if (pieces[i].equalsIgnoreCase("o"))
				pieceVals[i] = 14;
			else if (pieces[i].equalsIgnoreCase("p"))
				pieceVals[i] = 15;
			else if (pieces[i].equalsIgnoreCase("q"))
				pieceVals[i] = 16;
			else if (pieces[i].equalsIgnoreCase("r"))
				pieceVals[i] = 17;
			else if (pieces[i].equalsIgnoreCase("s"))
				pieceVals[i] = 18;
			else if (pieces[i].equalsIgnoreCase("t"))
				pieceVals[i] = 19;
			else if (pieces[i].equalsIgnoreCase("u"))
				pieceVals[i] = 20;
			else if (pieces[i].equalsIgnoreCase("v"))
				pieceVals[i] = 21;
			else if (pieces[i].equalsIgnoreCase("w"))
				pieceVals[i] = 22;
			else if (pieces[i].equalsIgnoreCase("x"))
				pieceVals[i] = 23;
			else if (pieces[i].equalsIgnoreCase("y"))
				pieceVals[i] = 24;
			else if (pieces[i].equalsIgnoreCase("z"))
				pieceVals[i] = 25;
			else if (pieces[i].equals(" "))
				pieceVals[i] = 420;
		}
		return pieceVals;
	}

	private String[] getCharValues(int[] pieces)   //Used in shift method
	{
		String[] pieceChars = new String[pieces.length];

		for(int i = 0; i < pieces.length; i++)
		{
			if(pieces[i] == 0)
				pieceChars[i] = "a";
			else if(pieces[i] == 1)
				pieceChars[i] = "b";
			else if(pieces[i] == 2)
				pieceChars[i] = "c";
			else if(pieces[i] == 3)
				pieceChars[i] = "d";
			else if(pieces[i] == 4)
				pieceChars[i] = "e";
			else if(pieces[i] == 5)
				pieceChars[i] = "f";
			else if(pieces[i] == 6)
				pieceChars[i] = "g";
			else if(pieces[i] == 7)
				pieceChars[i] = "h";
			else if(pieces[i] == 8)
				pieceChars[i] = "i";
			else if(pieces[i] == 9)
				pieceChars[i] = "j";
			else if(pieces[i] == 10)
				pieceChars[i] = "k";
			else if(pieces[i] == 11)
				pieceChars[i] = "l";
			else if(pieces[i] == 12)
				pieceChars[i] = "m";
			else if(pieces[i] == 13)
				pieceChars[i] = "n";
			else if(pieces[i] == 14)
				pieceChars[i] = "o";
			else if(pieces[i] == 15)
				pieceChars[i] = "p";
			else if(pieces[i] == 16)
				pieceChars[i] = "q";
			else if(pieces[i] == 17)
				pieceChars[i] = "r";
			else if(pieces[i] == 18)
				pieceChars[i] = "s";
			else if(pieces[i] == 19)
				pieceChars[i] = "t";
			else if(pieces[i] == 20)
				pieceChars[i] = "u";
			else if(pieces[i] == 21)
				pieceChars[i] = "v";
			else if(pieces[i] == 22)
				pieceChars[i] = "w";
			else if(pieces[i] == 23)
				pieceChars[i] = "x";
			else if(pieces[i] == 24)
				pieceChars[i] = "y";
			else if(pieces[i] == 25)
				pieceChars[i] = "z";
			else if(pieces[i] == 420)
				pieceChars[i] = " ";

		}
		return pieceChars;
	}

}
