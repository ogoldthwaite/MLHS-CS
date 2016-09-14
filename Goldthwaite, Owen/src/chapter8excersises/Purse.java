package chapter8excersises;

import java.util.ArrayList;

public class Purse 
{
  private ArrayList<String> coins;

	public Purse()
	{
		coins = new ArrayList <String>();
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
	public double purseValue()
	{
		ArrayList<String> coinvaluer=coins; double value=0;
		final double PENNY = .01; final double NICKEL = .05; 
		final double DIME = .1;   final double QUARTER = .25; 
		for(int u=0; u<=coinvaluer.size()-1; u++)
 	    {
 		   if ((coinvaluer.get(u).equals("Penny"))) {value+=PENNY;}
 		   if ((coinvaluer.get(u).equals("Nickel"))) {value+=NICKEL;}
 		   if ((coinvaluer.get(u).equals("Dime"))) {value+=DIME;}
 		   if ((coinvaluer.get(u).equals("Quarter"))) {value+=QUARTER;}
 	    }	
		return value;
	}
	public String toString()
	{
		String coinnames ="Purse- ";
		for(int h=0; h<=coins.size()-1; h++)
	     {
	    	coinnames = coinnames + coins.get(h) + "  ";
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
    	boolean tester=true;
    	ArrayList<String> dankcoins = coins;
    	ArrayList<String> purseother = other.getCoins();
    	if (dankcoins.size()==purseother.size())
        {
    	   for(int u=0; u<=purseother.size()-1; u++)
    	   {
    		   if (!(purseother.get(u).equals(dankcoins.get(u))))
    			   tester=false;
    	   }
        }
    	   else 
    		 tester=false;
    	return tester;
    }
    public boolean sameCoins(Purse other)
    {
    	boolean tester=false;
    	ArrayList<String> purseother = other.getCoins();
    	ArrayList<String> dankcoins = coins;
    	if (dankcoins.size()==purseother.size())
        {
    		if (this.purseValue()==other.purseValue())
    			tester=true;
        }
    	else tester=false;
    	  return tester;
    }
	
	
}
