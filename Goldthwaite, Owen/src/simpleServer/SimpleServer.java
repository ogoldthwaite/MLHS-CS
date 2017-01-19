package simpleServer;

import java.io.*;
import java.net.*;
import java.util.*;

public class SimpleServer implements Runnable
{
	private Thread t;
	private List<SimpleClientHandler> clients;

	public SimpleServer()
	{
		clients = new LinkedList<SimpleClientHandler>();
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
			int count = 1;
			
			while( ! Thread.interrupted() )
			{
				try
				{
						Socket s = ss.accept();
        				System.out.println("Client connected");
        				clients.add(new SimpleClientHandler(s, this));
        				clients.get(count - 1).setNick("Guest" + count);
        				count++;
				}
				catch(SocketTimeoutException e)
				{
					
				}
			}
			
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
	
	
	public void sendAll(String msg, SimpleClientHandler noSend)
	{
		for(int i = 0; i < clients.size(); i++)
		{
			if(!(clients.get(i).equals(noSend)))	
				clients.get(i).send(msg);
		}
	}
	
	public ArrayList<String> List()
	{
		ArrayList<String> nList = new ArrayList<String>();
		
		for(int i = 0; i<clients.size(); i++)
			nList.add(clients.get(i).getNick());
		
		return nList;
	}
	
	public void disconnect(SimpleClientHandler client)
	{
		try 
		{
			client.getSocket().close();
			clients.remove(client);
			client.annihilate();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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
