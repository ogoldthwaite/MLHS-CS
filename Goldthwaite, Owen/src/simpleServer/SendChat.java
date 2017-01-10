package simpleServer;

import java.util.Scanner;

public class SendChat implements Runnable
{
	private Thread t;
	private Scanner hostKey;
	
	public SendChat(Scanner scan)
	{
		hostKey = scan;	
		t = new Thread(this);
		t.start();	
	}
	
	public void run()
	{
		System.out.println(hostKey.next());	
	}
	
	
	
	
}
