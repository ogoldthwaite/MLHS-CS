package ab_2009_4;

import java.util.*;

public class Person
{
    public static Set<Person> expandContactSet(Set<Person> people)
    {
        Set<Person> retSet = new HashSet<Person>();
        Set<Person> tempSet = new HashSet<Person>();
        Iterator<Person> itr = people.iterator();
       // Iterator<Person> itr2 = tempSet.iterator();
        
        while(itr.hasNext())
        {
        	tempSet = itr.next().getContacts();
        	
        	retSet.addAll(tempSet);
        	retSet.addAll(people);
        }
        
        return retSet;
    }
    
    public Set<Person> getNetwork(int dist)
    {
    	Set<Person> retSet = new HashSet<Person>();
    	Set<Person> tempSet = new HashSet<Person>();
    	tempSet = this.getContacts();
    	
    	for(int i = 1; i <= dist; i++)
    	{
    		retSet.addAll(tempSet);
    		tempSet = expandContactSet(tempSet);
    	}
   
    		retSet.remove(this);
    	
    	return retSet; 
    }
    
    // Do not modify any code below.
    
    private String name;
    private Set<Person> contacts;
    
    public Person(String name)
    {
        this.name = name;
        contacts = new HashSet<Person>();
    }
    
    public String getName()
    {
        return name;
    }
    
    public void addContact(Person newContact)
    {
        contacts.add(newContact);
    }
    
	public Set<Person> getContacts()
	{
		return contacts;
	}
	
	public String toString()
	{
	    return name;
	}
}
