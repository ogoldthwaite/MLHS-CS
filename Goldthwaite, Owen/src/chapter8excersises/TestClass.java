package chapter8excersises;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class TestClass {

	public static void main(String[] args) 
	{
     	int[] values = new int[3]; values[0]=5; values[1]=8; values[2]=10;
		double max=0;
	for (int x : values)
	   {
		if (x > max) max =x;
	   }
	System.out.println(max);
	}

}
