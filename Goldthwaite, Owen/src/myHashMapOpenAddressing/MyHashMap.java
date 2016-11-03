package myHashMapOpenAddressing;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.AbstractMap.SimpleEntry;

/**
 * An academic map that does not support null keys or values and makes no guarantees about run time.
 */
public class MyHashMap<K, V>
{
	private ArrayList<Map.Entry<K, V>> table;
	private int size; // number of mappings

	private static final int CAPACITY = 100; // number of positions in table

	public MyHashMap()
    {
        table = new ArrayList<Map.Entry<K, V>>();
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean containsKey(Object key)
    {
    	int loc = key.hashCode() % CAPACITY;
    
    	while(table.get(loc) != null)
    	{
    		if(loc >= CAPACITY)
    			loc = 0;
    		
    		if(table.get(loc).getKey().equals(key))
    			return true;
    		
    		loc++;
    	}
    		return false;
   
    
    }
    
    public V put(K key, V value)
    {
    	int loc = key.hashCode() % 100;
    	
    	
    	
    	return null;
    }
    
    public V get(Object key)
    {
        return null;
    }

    public V remove(Object key)
    {
        return null;
    }
    
    public Set<K> keySet()
    {
        return null;
    }
}
