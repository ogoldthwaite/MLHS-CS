package simpleServer;

import java.util.Scanner;

public class SendChat implements Runnable
{
	private Thread t;
	private Scanner hostKey;
	private String nickName;
	
	public SendChat(Scanner scan)
	{
		hostKey = scan;	
		t = new Thread(this);
		t.start();	
	}
	
	public void run()
	{
		while( ! Thread.interrupted())
		{
		
		String text = hostKey.next();
		
//		if(text.startsWith("/nick"))
//		{
//			  nickName = text.substring("/nick ".length());
//			
//			  nickName = "bob";
//		}
		
		
		
		if(nickName.equals(""))
			System.out.println(text);
		else	
		    System.out.println(nickName + ": " + text);
		
		}
		
	}
	
	public void annihilate()
	{
		t.interrupt();
	}
	
	
	
	
}
