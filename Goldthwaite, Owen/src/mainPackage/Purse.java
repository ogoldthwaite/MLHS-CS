package mainPackage;

import java.util.ArrayList;

public class Purse 
{
  private ArrayList<String> coins = new ArrayList <String>();

	public Purse()
	{
		
	}
	public ArrayList<String> getCoins()
	{
		return coins;
	}
	public void clearPurse()
	{
		coins.clear();
	}
	public void addCoin(String coinname)
	{
	    coins.add(coinname);
	}
	public String toString()
	{
		String coinnames ="Purse-";
		for(int h=0; h<=coins.size()-1; h++)
	     {
	    	coinnames = coinnames + coins.get(h) + ", ";
	     }
		return coinnames;
	}
	public void reverse()
	{
	    ArrayList<String> coinsreverse = new ArrayList <String>();
		for(int j=coins.size()-1; j>=0; j--)
		   coinsreverse.add(coins.get(j));
		
		coins=coinsreverse;

	}
    public void transfer(Purse other)
    {
    	ArrayList<String> purseother = other.coins;
    	for(int u=0; u<=purseother.size()-1; u++)
    	{
    		coins.add(purseother.get(u));    		
    	}
    	other.clearPurse();
    }
    public boolean sameContents(Purse other)
    {
    	ArrayList<String> dankcoins = coins;
    	ArrayList<String> purseother = other.getCoins();
    	for(int u=0; u<=purseother.size()-1; u++)
    	{
    		System.out.println(dankcoins.get(u));
    		if (purseother.get(u).equals(dankcoins.get(u)))
    			System.out.println("Worked");
    	}
    	
    	
    	return false;
    	
    }
	
	
}
