package webget;

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
   This program demonstrates how to use a socket to communicate
   with a web server.
   
   This has been modified from the Big Java version.
*/
public class WebGet
{
    public static void main(String[] args)
    {
        String host = "www.greggsmith.com";
        String resource = "/";
        System.out.println("Getting " + resource + " from " + host);
        ArrayList<String> imgName = new ArrayList<String>();

        try
        {
            // Open socket
            final int HTTP_PORT = 80;
            Socket s = new Socket(host, HTTP_PORT);

            // Get streams
            InputStream instream = s.getInputStream();
            OutputStream outstream = s.getOutputStream();

            // Turn streams into scanners and writers
            Scanner in = new Scanner(instream);
            PrintWriter out = new PrintWriter(outstream);

            // Send command
            String command = "GET " + resource + " HTTP/1.1\n";
            command += "host: " + host + "\n\n";
            out.print(command);
            out.flush();

            // Read server response
            boolean foundHTMLEndTag = false;
            while (!foundHTMLEndTag)
            {
                String input = in.nextLine();
                System.out.println(input);
                
                int start = input.indexOf("img src=\"");
                int last = input.indexOf("\" class=");
                String addString = "";
                
                for(int i = start + 6; i <= last; i++)
                	addString += input.charAt(i);
                
                imgName.add(addString);
                
                
                
              //   System.out.println(start + " S");
             //   System.out.print(last +" L");
                

                //System.out.println(input.substring(start, last));
                	
                //imgName.add(input.substring(start, last));
                System.out.println(imgName);
                	                	              
                foundHTMLEndTag = input.toLowerCase().indexOf("</html>") != -1;
            }

            
            
            // Always close the socket at the end
            s.close();
            in.close();
        }
        catch (IOException e)
        {
            System.out.println("Connection failed");
        }
    }
}
