package setExcersises;

import java.awt.Color;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SetStuffTester {

	public static void main(String[] args) 
	{
		String bob = "bob";
		System.out.println(bob.substring(0,1));
		//listWords();
		//colorPresent();
	}

	public static void listWords()
	{
		TreeSet<String> plant = new TreeSet<String>();
		Scanner scan = new Scanner(System.in);
		String acorns = scan.nextLine();
		String[] roots = acorns.split(" ");
		
		for(int i =0; i < roots.length; i++)
			plant.add(roots[i]);
		
		System.out.println(plant.size());
		System.out.println(plant);
	}
	
	public static void colorPresent()
	{
		HashSet<Color> rainbow = new HashSet<Color>();
		rainbow.add(Color.BLACK);
		rainbow.add(Color.BLUE);
		rainbow.add(Color.CYAN);
		rainbow.add(Color.DARK_GRAY);
		rainbow.add(Color.GRAY);
		rainbow.add(Color.GREEN);
		rainbow.add(Color.LIGHT_GRAY);
		rainbow.add(Color.MAGENTA);
		rainbow.add(Color.ORANGE);
		rainbow.add(Color.PINK);
		rainbow.add(Color.RED);
		rainbow.add(Color.WHITE);
		rainbow.add(Color.YELLOW);
		
		Scanner scan = new Scanner(System.in);
		float h = scan.nextFloat();
		float s = scan.nextFloat();
		float b = scan.nextFloat();
		
		Color coolColor = new Color(h, s, b);
		
		if(rainbow.contains(coolColor))
			System.out.println("Color present!");
		else
			System.out.println("Your color is in another castle!");
	}
	

}



/* R 21.1 - Hash and tree set
 * R 21.4 - Union: make a new set with values from sets A and B with the add method
 *          Intersection: Use contains to check against each set and then remove any value that does
 *          not appear in both sets.
 * R 21.5 - Union: Same way as above, hopefully. Intersection: Also same way as above, hopefully.
 * 			Wasn't sure what this question was asking
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

