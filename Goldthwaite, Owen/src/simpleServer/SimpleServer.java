package simpleServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleServer implements Runnable
{
	private Thread t;
	private List<SimpleClientHandler> clients;
	private int count;

	public SimpleServer()
	{
		clients = new LinkedList<SimpleClientHandler>();
		count = 1;
		t = new Thread(this);
		t.start();
	}

	public void run()
	{
		ServerSocket ss = null;
		
		try
		{
			ss = new ServerSocket(8888);
			ss.setSoTimeout(1000);
			System.out.println("Waiting for connections");
			int counttwo = 1;
			
			while( ! Thread.interrupted() )
			{
				try
				{
						Socket s = ss.accept();
        				System.out.println("Client connected");	
        				
        				clients.add(new SimpleClientHandler(s, this));
        				
        				clients.get(count - 1).setNick("Guest" + counttwo);
        				sendAll("CON " +clients.get(count - 1).getNick());
        				count++;
        				counttwo++;
				}
				catch(SocketTimeoutException e)
				{
					
				}
			}
			
			System.out.println("LOL WHAT");
			
		}
		catch (IOException e)
		{
			System.out.println("IOException - Server terminating");
		}
		finally
		{
			System.out.println("Terminating server");
			try
			{
				closeAll();
				ss.close();
			}
			catch (IOException e)
			{
				
			}
			finally
			{
				System.out.println("Server terminated");
			}
		}
	}
	
	
//	public int sendAll(String msg, SimpleClientHandler noSend)
//	{
//		for(int i = 0; i < clients.size(); i++)
//		{
//			if(!(clients.get(i).equals(noSend)))	
//				clients.get(i).send(msg);
//		}
//		
//		return 701;
//	}
	
	public int sendAll(String msg)
	{
		for(int i = 0; i < clients.size(); i++)
		{
				clients.get(i).send(msg);
		}
		
		return 701;
	}
	
	public ArrayList<String> List()
	{
		ArrayList<String> nList = new ArrayList<String>();
		
		for(int i = 0; i<clients.size(); i++)
			nList.add(clients.get(i).getNick());
		
		return nList;
	}
	
	public int whisper(String msg, String nickName)
	{
		int count = 0;

		try
		{

			while(! clients.get(count).getNick().equals(nickName) && count < clients.size())
			{
				count++;
			}
			clients.get(count).send("MSG " + msg);
			return 700;

		}
		catch(IndexOutOfBoundsException e)
		{
				System.out.println("600");
				return 600;
		}
	}
	
	public int checkNick(String nick)
	{
		for(int i = 0; i<clients.size(); i++)
			if(nick.equals(clients.get(i).getNick()))
				return 602;
		
		if(nick.contains(" "))
			return 502;
		
		return 702;
		
	}
	
	public int kick(String nick)
	{
		try
		{
			for(int i = 0; i <clients.size(); i++)
			{
				if(nick.equals(clients.get(i).getNick()))
				{
					disconnect(clients.get(i));
					clients.get(i).annihilate();
				}
			}
			return 420;
		}
		catch(IndexOutOfBoundsException e)
		{
			sendAll(nick +" could not be bodied!");
			return 1337;
		}
	}
	
	public int disconnect(SimpleClientHandler client)
	{
		try 
		{
			client.getSocket().close();
			clients.remove(client);
			count--;
			System.out.println("Client Disconnected!");
			return 703;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return 603;
		}
		
	}
	
	private void closeAll()
	{
		for(SimpleClientHandler sch : clients)
			sch.annihilate();
		clients.clear();
	}
	
	public void annihilate()
	{
		t.interrupt();
	}
}
