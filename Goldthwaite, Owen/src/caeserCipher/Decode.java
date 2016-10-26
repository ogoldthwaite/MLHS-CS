package caeserCipher;
import java.util.*;
import java.io.*;

public class Decode 
{	
	private String toDecode;

	public Decode(String code)
	{
		toDecode = code;
		
		try {
			Scanner scan = new Scanner(new File("/users/share/dict/words"));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}

	public String[] breakCode()
	{
		String[] codeArray = toDecode.split(" ");




	}

	private boolean compareToDict(String toTest)
	{
		try {
			Scanner scan = new Scanner(new File("/users/share/dict/words"));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}



	}

}
