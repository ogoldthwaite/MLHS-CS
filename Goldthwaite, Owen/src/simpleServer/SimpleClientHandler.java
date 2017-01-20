package simpleServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleClientHandler implements Runnable 
{
	private Thread t;
	private Socket connectionToClient;
	private SimpleServer parentServer;
	private String nickName;
	
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
				//if(in.nextLine()) add something to check for a space
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
				String nickName = "";
				String msg = "";			
				int space = postProt.indexOf(" ");
				nickName = postProt.substring(0, space);
				msg = postProt.substring(space + 1);
				
				
				
				//TELL WHO SENT MSG AND IF NICK DOES NOT EXIST GIVE ERROR
				
				
				
				
				parentServer.whisper(msg, nickName);
				
			}
			else if(line.startsWith("TELL"))
			{
				parentServer.sendAll(nickName + ":" +postProt, this);
			}
			
			else if(line.startsWith("NICK"))
			{
				setNick(postProt);
			}
			else if(line.startsWith("DISC"))
			{
				parentServer.disconnect(this);
				parentServer.sendAll(this.getNick() + " Disconected", this);
				System.out.println("Client Disconnected");
			}
			else if(line.startsWith("LIST"))
			{
				ArrayList<String> nickList = parentServer.List();
				String toSend = "[";
				
				for(int i = 0; i < nickList.size() - 1; i++)
					toSend += nickList.get(i)+", ";
				
				toSend += nickList.get(nickList.size() - 1) + "]";
				send(toSend);
			}
		else
		{
			send("Dude that's not a command bro");
		}
		
	}
	
	public void setNick(String nick)
	{
		nickName = nick;
	}

	public String getNick()
	{
		return this.nickName;
	}
	
	public Socket getSocket()
	{
		return connectionToClient;
	}
	
	public void annihilate()
	{
		t.interrupt();
	}
}
