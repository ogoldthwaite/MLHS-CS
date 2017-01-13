package simpleServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleClientHandler implements Runnable
{
	private Thread t;
	private Socket connectionToClient;
	
	public SimpleClientHandler(Socket clientConnection)
	{
		connectionToClient = clientConnection;
		t = new Thread(this);
		t.start();
	}
	
	public void run()
	{
		try
		{
			Scanner in = new Scanner(connectionToClient.getInputStream());
			PrintWriter out = new PrintWriter(connectionToClient.getOutputStream());
			//Scanner scanKeyboard = new Scanner(System.in);
//			ReceiveChat rChat =  new ReceiveChat(in);
//			SendChat sChat = new SendChat(out, in);
						
			while( ! Thread.interrupted() )
			{
				//System.out.println(in.next);	
				//out.println(scanKeyboard.nextLine());    
				//out.flush();
			}
		}
		catch (IOException e)
		{
			
		}

	}
	
	public void annihilate()
	{
		t.interrupt();
	}
}
