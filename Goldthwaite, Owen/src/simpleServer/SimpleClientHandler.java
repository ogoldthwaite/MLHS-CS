package simpleServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleClientHandler implements Runnable 
{
	private Thread t;
	private Socket connectionToClient;
	private SimpleServer parentServer;
	
	public SimpleClientHandler(Socket clientConnection, SimpleServer dankServer)
	{
		connectionToClient = clientConnection;
		parentServer = dankServer;
		t = new Thread(this);
		t.start();
	}
	
	public void run()
	{
		try
		{
			Scanner in = new Scanner(connectionToClient.getInputStream());
			respond(in.nextLine());
						
			while( ! Thread.interrupted() )
			{
				respond(in.nextLine());	
			}
		}
		catch (IOException e)
		{
			
		}

	}
	
	public void send(String msg)
	{
		PrintWriter out;
		try 
		{
			out = new PrintWriter(connectionToClient.getOutputStream());
			out.println(msg);
			out.flush();
		} 
		catch (IOException e) 
		{
			;
		}
	}
	
	private void respond(String line)
	{
		String postProt = "";
		
		if(line.length() > 5)
		   postProt = line.substring(5);
		
		if(line.startsWith("SEND"))
		{
			
		}
		else if(line.startsWith("TELL"))
		{
			parentServer.sendAll(postProt, this);
		}
		
		else if(line.startsWith("NICK"))
		{
			
		}
		else if(line.startsWith("DISC"))
		{
			
		}
		else if(line.startsWith("LIST"))
		{
			
		}
		else
		{
			send("Dude that's not a command bro");
		}
		
	}
	
	
	public void annihilate()
	{
		t.interrupt();
	}
}
