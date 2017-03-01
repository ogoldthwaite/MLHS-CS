package substitutionCipher;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner scan = new Scanner(new File("files/subCipher.txt"));
		String code = "";
		
		while(scan.hasNext())
			code += scan.nextLine();

		Decode dankCode = new Decode(code.toLowerCase());
		
		System.out.println(dankCode.makeFreqMap());
		
		dankCode.editMsg();
		
		scan.close();
	}

}
