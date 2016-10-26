package caeserCipher;

import java.util.Scanner;

public class TestCipher {

	public static void main(String[] args) 
	{
		Decode codedCode = new Decode("Hey I am Bob z");
		System.out.println(codedCode.breakCode());
	}

}
