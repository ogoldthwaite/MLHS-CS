package hashingExercises;

public class BankAccount 
{
	private String owner;
	private int value;
	;
	
	public BankAccount(String name, int money)
	{
		owner = name;
		value = money;
	}
	
	public String getOwner()
	{
		return owner;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public boolean equals(BankAccount account)
	{
		if(!(account instanceof BankAccount))
		return false;
		
		if(owner.equals(account.getOwner())
				&& value == account.getValue())
			return true;
		else
			return false;
	}

	public int hashCode()
	{
		final int HASH_MULT = 46;
		
		int hashNum  = new Integer(value).hashCode();
		hashNum = hashNum * HASH_MULT + new String(owner).hashCode();
		
		return hashNum;
	}
	
	
}
