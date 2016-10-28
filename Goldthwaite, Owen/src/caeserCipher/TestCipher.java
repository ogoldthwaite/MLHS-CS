package caeserCipher;

import java.util.Scanner;

public class TestCipher {

	public static void main(String[] args) 
	{
		Decode codedCode = new Decode("IFMMP");
		//Hello
		//IFMMP
		System.out.println(codedCode.breakCode());
	}

}
