package myHashMapOpenAddressing;

import java.util.HashMap;

import junit.framework.TestCase;

public class MyHashMapTester<K, V> extends TestCase
{
	public void testContains()
	{
	MyHashMap<String, Integer> myMap = new MyHashMap<String, Integer>();
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	
	
	//myMap.put("a", 5);
	map.put("a", 1);
	System.out.println(map);
	System.out.println(myMap);
	System.out.println(map);
	
	
	myMap.put("a", 1);
	map.put("a", 1);
	
	assertTrue(myMap.containsKey("a") == true);
	assertTrue(map.containsKey("a") == true);
	}
	
	
	
	
}
