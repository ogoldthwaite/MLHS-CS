package recursiveFileDirectory;

import java.io.File;

public class DirectoryTraverse {

	public static void main(String[] args) 
	{
		String path = "/users/ogoldthwaite/downloads";
		File coolFile = new File(path);
		
		printDirectory(coolFile);

	}

	public static void printDirectory(File coolFile)	
	{

		if (coolFile.isDirectory())
		{
			File files[]; 	
			files = coolFile.listFiles();
			
			for(int i = 0; i < files.length; i++)
			{
				printDirectory(files[i]);
			}
			
		}
		else System.out.println(coolFile.getName());
	}

}
