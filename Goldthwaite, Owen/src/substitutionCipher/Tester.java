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

		Decode dankCode = new Decode(code);
		
		System.out.println(dankCode.getFreqMap());
		
//		PriorityQueue<FrequencyNode> qq = new PriorityQueue<FrequencyNode>();
		
//		qq = dankCode.makeQueue();
		
//		for(int i = qq.size(); i > 0; i--)
//			System.out.println(qq.peek().letter + " = " +qq.poll().frequency);
		
		scan.close();
	}

}
