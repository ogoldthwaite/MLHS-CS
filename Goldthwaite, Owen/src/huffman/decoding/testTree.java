package huffman.decoding;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testTree {

	public static void main(String[] args) throws FileNotFoundException 
	{
		HuffmanTree oak = new HuffmanTree();
		Scanner scan = new Scanner(new File("files/scheme.txt"));
		Scanner cool = new Scanner(new File("files/encoded.txt"));
		String code = scan.nextLine();
		
		while(scan.hasNext())
		{
			String scheme = scan.nextLine();
			System.out.println(scheme);
			oak.insert(scheme.charAt(0), scheme.substring(1));
		}
		
		System.out.println(code);
		
		System.out.println(oak.decodeMessage(code));

	}

}
