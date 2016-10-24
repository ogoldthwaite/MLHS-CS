package recursiveFileDirectory;

import java.io.File;

public class DirectoryTraverse {

	public static void main(String[] args) 
	{
		String path = "/users/ogoldthwaite/documents";
		printDirectory(path);

	}

	public static void printDirectory(String path)	
	{
		File coolFile = new File(path);

		if (coolFile.isDirectory())
		{
			File files[]; 	
			files = coolFile.listFiles();
			for(int i = 0; i < files.length; i++)
			{
				printDirectory(files[i].getName());
			}
			
		}
		else System.out.println(coolFile.getName());
	}

}
