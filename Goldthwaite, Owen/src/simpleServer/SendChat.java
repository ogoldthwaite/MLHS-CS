package simpleServer;

import java.io.PrintWriter;
import java.util.Scanner;

public class SendChat implements Runnable
{
	private Thread t;
	private PrintWriter write;
	private Scanner scan;
	private String nickName;
	
	public SendChat(PrintWriter out, Scanner scantastic)
	{
		write = out;
		scan = scantastic;
		t = new Thread(this);
		t.start();	
	}
	
	public void run()
	{
		while( ! Thread.interrupted())
		{
			String text = scan.next();
					
			write.println(text);
			write.flush();
			
			//System.out.println(text);
		}
	
	}
	
	public void annihilate()
	{
		t.interrupt();
	}
	
	
	
	
}
