package simpleServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleClientHandler implements Runnable 
{
	private Thread ta;
	private Socket connectionToClient;
	private SimpleServer parentServer;
	private String nickName;
	
	public SimpleClientHandler(Socket clientConnection, SimpleServer dankServer)
	{
		connectionToClient = clientConnection;
		parentServer = dankServer;
		ta = new Thread(this);
		ta.start();
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
	
				int numCode = parentServer.whisper(this.nickName +": " + msg, nickName);
				
				send(numCode+"");
				
			}
			else if(line.startsWith("TELL"))
			{
				int numCode = parentServer.sendAll("TLL " + nickName + ":" +postProt);
				send(numCode+"");
			}
			
			else if(line.startsWith("NICK"))
			{
				setNick(postProt);
			}
			else if(line.startsWith("DISC"))
			{
				send("703");
				int numCode = parentServer.disconnect(this);
				annihilate();
				parentServer.sendAll("DSC " + this.getNick());
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
				
				send("704");
			}
		else
		{
			send("666");
		}
		
	}
	
	public void setNick(String nick)
	{
		int numCode = parentServer.checkNick(nick);
		
		if(numCode != 702)
			System.out.println(numCode);
		else if(numCode == 702)
		{
			parentServer.sendAll("NIC " +this.getNick() +" " + nick);
			nickName = nick;
		}
		
		send(numCode+"");
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
		ta.interrupt();
	}
}
