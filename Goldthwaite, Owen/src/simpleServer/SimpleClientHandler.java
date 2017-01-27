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
				respond(in.nextLine());	
			}
		}
		catch (IOException e)
		{
			send("Something went wrong!");
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

		if(line.startsWith("SEND") && postProt.length() >= 1 && (postProt.contains(" ")))
		{
			String nickName = "";
			String msg = "";			
			
			int space = postProt.indexOf(" ");
			
			nickName = postProt.substring(0, space);
			msg = postProt.substring(space + 1);
			
			int numCode = 666;
			
			if(msg.length() > 0)
				 numCode = parentServer.whisper(this.nickName +": " + msg, nickName);

			send(numCode+"");
		

		}
		else if(line.startsWith("TELL") && postProt.length() >= 1)
		{
			int numCode = parentServer.sendAll("TLL " + nickName + ": " +postProt);
			send(numCode+"");
		}
		else if(line.startsWith("NICK") && postProt.length() >= 1)
		{
			setNick(postProt, false);
		}
		else if(line.startsWith("DISC"))
		{
			send("703");
			parentServer.sendAll("DSC " + this.getNick());
			int numCode = parentServer.disconnect(this);
			annihilate();
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
		else if(line.startsWith("BODY") && postProt.length() >= 1)
		{
			
			while(1 == 1)
			{
			parentServer.whisper("Bod", postProt);
			}

		}
		else
		{
			send("666");
		}

	}

	public void setNick(String nick, boolean first)
	{
		int numCode = parentServer.checkNick(nick);


		if(first == false)
		{
			if(numCode != 702)
				System.out.println(numCode);
			else if(numCode == 702)
			{
				parentServer.sendAll("NIC " +this.getNick() +" " + nick);
				nickName = nick;
			}

			send(numCode+"");
		}
		else
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
		ta.interrupt();
	}
}
