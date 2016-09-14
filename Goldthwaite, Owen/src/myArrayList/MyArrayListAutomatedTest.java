package myArrayList;

import junit.framework.TestCase;

public class MyArrayListAutomatedTest extends TestCase
{
    public void testConstructorsAndSizeMethod()
    {
        MyArrayList<Integer> mALDefault = new MyArrayList<Integer>();
        assertTrue(mALDefault.getA().length == 10);
        assertTrue(mALDefault.getSize() == 0);
        for(Object elem : mALDefault.getA())
            assertTrue(elem == null);
        
        MyArrayList<Integer> mAL25 = new MyArrayList<Integer>(25);
        assertTrue(mAL25.getA().length == 25);
        assertTrue(mAL25.size() == 0);
        for(Object elem : mAL25.getA())
            assertTrue(elem == null);
        
        mALDefault.setA(new Object[]{5, 1, 4, 1, 0, null, null, null, null, null});
        mALDefault.setSize(5);
        assertTrue(mALDefault.size() == 5);
    }
    
    public void testSizeIsntCountingNulls()
    {
        MyArrayList<Integer> mAL = new MyArrayList<Integer>();
        mAL.setA(new Object[]{5, 1, 4, 1, null, null, null, null, null, null});
        mAL.setSize(5);
        
        assertTrue(mAL.size() == 5);
    }
    
    public void testGetIndexValidityCheck()
    {
        MyArrayList<Integer> mAL = new MyArrayList<Integer>();
        mAL.setA(new Object[]{5, 3, null, null, null, null, null, null, null, null});
        mAL.setSize(2);
        
        int[] validIndexes = new int[]{0, 1};
        
        // all this has to do is not throw an exception
        for(int index : validIndexes)
            mAL.get(index);
        
        int[] invalidIndexes = new int[]{-1, -2, 2, 10, 11};
        for(int index : invalidIndexes)
        {
            try
            {
                mAL.get(index);
                assertTrue(false); // should have thrown IndexOutOfBoundsException
            }
            catch(IndexOutOfBoundsException e)
            {
                
            }
        }
    }
    
    public void testSetReturnsOldElement()
    {
        MyArrayList<Integer> mAL = new MyArrayList<Integer>();
        mAL.setA(new Object[]{5, 3, null, null, null, null, null, null, null, null});
        mAL.setSize(2);
        
        assertTrue(mAL.set(1, 7) == 3);
    }
    
    public void testTrimToSize()
    {
        MyArrayList<Integer> mAL = new MyArrayList<Integer>();
        mAL.setA(new Object[]{5, 3, null, null, null, null, null, null, null, null});
        mAL.setSize(2);
        
        mAL.trimToSize();
        
        assertTrue(mAL.getA().length == 2);
        assertTrue(mAL.getSize() == 2);
        assertTrue(mAL.getA()[0].equals(5) && mAL.getA()[1].equals(3));
    }
    
    public void testTrimOnlyTrimsOnExcessCapacity()
    {
        MyArrayList<Integer> mAL = new MyArrayList<Integer>(2);
        mAL.setA(new Object[]{5, 3});
        mAL.setSize(2);
        
        Object[] aBefore = mAL.getA();
        
        mAL.trimToSize();
        
        assertTrue(mAL.getA() == aBefore);
    }
    
    public void testAddIndexValidityCheck()
    {
        int[] invalidIndexesForEmptyAL = new int[]{-1, -2, 1, 2};
        for (int index : invalidIndexesForEmptyAL)
        {
            try
            {
                MyArrayList<Integer> mAL = new MyArrayList<Integer>();
                mAL.setA(new Object[]{null, null, null, null, null, null, null, null, null, null});
                mAL.setSize(0);
                mAL.add(index, 6);
                assertTrue(false); // should have thrown IndexOutOfBoundsException
            }
            catch (IndexOutOfBoundsException e)
            {

            }
        }
        
        MyArrayList<Integer> mAL = new MyArrayList<Integer>();
        
        int[] validIndexes = new int[]{0, 1, 2, 0, 1}; // order is important
        
        // all this has to do is not throw an exception
        for(int index : validIndexes)
            mAL.add(index, 6);
        

        int[] invalidIndexesForNonEmptyAL = new int[]{-1, -2, 6, 7};
        for(int index : invalidIndexesForNonEmptyAL)
        {
            try
            {
                mAL.setA(new Object[]{6, 6, 6, 6, 6, null, null, null, null, null});
                mAL.setSize(5);
                mAL.add(index, 6);
                assertTrue(false); // should have thrown IndexOutOfBoundsException
            }
            catch(IndexOutOfBoundsException e)
            {
                
            }
        }
    }
    
    public void testAddWhenCapacityZero()
    {
        MyArrayList<Integer> mAL = new MyArrayList<Integer>(0);
        mAL.setA(new Object[0]);
        mAL.setSize(0);
        
        mAL.add(5);
        
        assertTrue(mAL.getA().length > 0);
        assertTrue(mAL.getSize() == 1);
        assertTrue(mAL.getA()[0].equals(5));
    }
    
    public void testAddWhenAtCapacity()
    {
        MyArrayList<Integer> mAL = new MyArrayList<Integer>(3);
        mAL.setA(new Object[]{5, 3, 6});
        mAL.setSize(3);
        
        mAL.add(2, 5);
        
        assertTrue(mAL.getA().length > 3);
        assertTrue(mAL.getSize() == 4);
    }
    
    public void testAddAtPositions()
    {
        MyArrayList<Integer> mAL = new MyArrayList<Integer>();
        mAL.setA(new Object[10]);
        mAL.setSize(0);
        
        mAL.add(5); // [5]
        assertTrue(mAL.getA()[0].equals(5));
        assertTrue(mAL.getSize() == 1);
        
        mAL.add(0, 4); // [4, 5]
        assertTrue(mAL.getA()[0].equals(4));
        assertTrue(mAL.getA()[1].equals(5));
        assertTrue(mAL.getSize() == 2);
        
        mAL.add(1, 3); // [4, 3, 5]
        assertTrue(mAL.getA()[0].equals(4));
        assertTrue(mAL.getA()[1].equals(3));
        assertTrue(mAL.getA()[2].equals(5));
        assertTrue(mAL.getSize() == 3);
        
        mAL.add(1, 6); // [4, 6, 3, 5]
        assertTrue(mAL.getA()[0].equals(4));
        assertTrue(mAL.getA()[1].equals(6));
        assertTrue(mAL.getA()[2].equals(3));
        assertTrue(mAL.getA()[3].equals(5));
        assertTrue(mAL.getSize() == 4);
        
        mAL.add(4, 9); // [4, 6, 3, 5, 9]
        assertTrue(mAL.getA()[0].equals(4));
        assertTrue(mAL.getA()[1].equals(6));
        assertTrue(mAL.getA()[2].equals(3));
        assertTrue(mAL.getA()[3].equals(5));
        assertTrue(mAL.getA()[4].equals(9));
        assertTrue(mAL.getSize() == 5);
    }
    
    public void testRemove()
    {
        MyArrayList<Integer> mAL = new MyArrayList<Integer>();
        mAL.setA(new Object[]{6, 7, 8, 9, 10, null, null, null, null, null});
        mAL.setSize(5);
        
        mAL.remove(0); // [7, 8, 9, 10]
        assertTrue(mAL.getSize() == 4);
        assertTrue(mAL.getA()[0].equals(7));
        assertTrue(mAL.getA()[1].equals(8));
        assertTrue(mAL.getA()[2].equals(9));
        assertTrue(mAL.getA()[3].equals(10));
        
        mAL.remove(3); // [7, 8, 9]
        assertTrue(mAL.getSize() == 3);
        assertTrue(mAL.getA()[0].equals(7));
        assertTrue(mAL.getA()[1].equals(8));
        assertTrue(mAL.getA()[2].equals(9));
        
        mAL.remove(1); // [7, 9]
        assertTrue(mAL.getSize() == 2);
        assertTrue(mAL.getA()[0].equals(7));
        assertTrue(mAL.getA()[1].equals(9));
    }
    
    public void testRemoveDoesNotLeakMemory()
    {
        MyArrayList<Integer> mAL = new MyArrayList<Integer>();
        mAL.setA(new Object[]{6, 7, 8, 9, 10, null, null, null, null, null});
        mAL.setSize(5);
        
        mAL.remove(0); // [7, 8, 9, 10]
        assertTrue(mAL.getA().length < 5 || mAL.getA()[4] == null);
        
        mAL.remove(3); // [7, 8, 9]
        assertTrue(mAL.getA().length < 4 || mAL.getA()[3] == null);
        
        mAL.remove(1); // [7, 9]
        assertTrue(mAL.getA().length < 3 || mAL.getA()[2] == null);
    }
}
