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
        table = new ArrayList<Map.Entry<K, V>>(CAPACITY);
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean containsKey(Object key)
    {
    	int loc = findKey(key);
    	if(loc >= 0)
    		return true;
    	else 
    		return false;
    }
    
    public V put(K key, V value)
    {
    	V temp = get(key);
    	
    	Map.Entry<K, V> worldMap = new SimpleEntry<K, V>(key, value);
     	table.add(getFirstOpen(key), worldMap);

     	size++;
     	return temp;
		
    }
    
    public V get(Object key)
    {
    	V temp;
     	if(containsKey(key))
    		temp = table.get(findKey(key)).getValue();
     	else 
     		temp = null;
    	
    	return temp;
    }

    public V remove(Object key)
    {
        return null;
    }
    
    public Set<K> keySet()
    {
        return null;
    }
    
    public int findKey(Object key) //returns index of key
    {
    	int loc = key.hashCode() % CAPACITY;
        
    	while(table.get(loc) != null)
    	{
    		if(loc >= CAPACITY)
    			loc = 0;
    		
    		if(table.get(loc).getKey().equals(key))
    			return loc;
    		
    		loc++;
    	}
    		return -10;
    }
    
    private int getFirstOpen(Object key) //returns first spot with null or deleted entry
    {
    	int loc = key.hashCode() % CAPACITY;
    	
    	while(table.get(loc) != null || !(table.get(loc) instanceof DeletedEntry))
    	{
    		if(loc >= CAPACITY)
    			loc = 0;
    		
    		loc++;
    	}
    		return loc;
    }
    
}
