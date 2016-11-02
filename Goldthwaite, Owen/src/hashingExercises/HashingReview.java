package hashingExercises;

public class HashingReview {

	public static void main(String[] args) 
	{
		verifyJimJoe();
		verifyHashTable();
		Student bob = new Student("Bob", "Smith", 420);
		Student bob2 = new Student("Jeff", "Smith", 420);
		
		System.out.println(bob.hashCode());
		System.out.println(bob2.hashCode());
		
		BankAccount jeff = new BankAccount("Jeff" , 420);
		BankAccount jeff2 = new BankAccount("Jeff", 420);
		
		System.out.println(jeff.hashCode());
		System.out.println(jeff2.hashCode());
	}

	public static void verifyJimJoe() //review 21.9
	{
		String jim = "Jim";
		String joe = "Joe";
		System.out.println(jim.hashCode());
		System.out.println(joe.hashCode());
	}
	
	public static void verifyHashTable() //review 21.10
	{
		String juliet = "Juliet";
		String sue = "Sue";
		String nina = "Nina";
		System.out.println(Math.abs(juliet.hashCode()) % 101); //Correct value = 79
		System.out.println(Math.abs(sue.hashCode()) % 101);    //Correct value = 65
		System.out.println(Math.abs(nina.hashCode()) % 101);   //Correct value = 70
	}
}
