package hashingExercises;

public class Student 
{
	private String first;
	private String last;
	private int id;
	
	public Student(String firstName, String lastName, int identify)
	{
		first = firstName;
		last = lastName;
		id = identify;
	}
	
	public String getFirst()
	{
		return first;
	}
	
	public String getLast()
	{
		return last;
	}
	
	public int getID()
	{
		return id;
	}
	
	public boolean equals(Student pupil)
	{
		if(!(pupil instanceof Student))
			return false;
		
		if(first.equals(pupil.getFirst())
			&& last.equals(pupil.getLast())
			&& id == pupil.getID())
			return true;
		else
			return false;
		
	}
	
	public int hashCode()
	{
		final int HASH_MULT = 37;
		
		int hashNum  = new Integer(id).hashCode();
		hashNum = hashNum * HASH_MULT + new String(first).hashCode();
		hashNum = hashNum * HASH_MULT + new String(last).hashCode();
		
		return hashNum;
		
	}
	
	
}
