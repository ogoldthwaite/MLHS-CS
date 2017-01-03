package advancedSorts;

import java.util.Comparator;
import java.util.Random;

/**
 * Used to test each of the sort methods provided on a
 * Integer[] of random numbers.
 */
public class Test
{
	public static void main(String[] args)
	{
		testSortInteger(2);
	}
	
    /**
     * Tests the specified sort method on an array of
     * 10 random Integer objects such that each element e is:
     * 0 <= e < 100.
     * 
     * Displays the array before and after sorting using
     * the specified algorithm.
     * 
     * algorithm:
     *      0 - java.util.Arrays.sort()
     *      1 - QuickSort.sort()
     *      2 - HeapSort.sort()
     * 
     * @param algorithm the algorithm to be used for the sort, as described above.
     */
    public static void testSortInteger(int algorithm)
    {
        Integer[] a = new Integer[10];
     
        Random rand = new Random();
        for(int i = 0; i < a.length; i++)
            a[i] = rand.nextInt(100);
        
        Comparator<Integer> c = new IntegerComparator();
        
        System.out.print("a[]: ");
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        
        switch(algorithm)
        {
            case 0:
                System.out.println("java.util.Arrays.sort(a, c)");
                java.util.Arrays.sort(a, c);
                break;
                
            case 1:
                System.out.println("QuickSort.sort(a, c, 0, a.length - 1)");
                QuickSort.sort(a, c, 0, a.length - 1);
                break;
                
            case 2:
                System.out.println("HeapSort.sort(a, c)");
                HeapSort.sort(a, c);
                break;
        }
        
        System.out.print("a[]: ");
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
        System.out.println();
    }
}
