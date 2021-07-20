import java.io.IOException;
import za.ac.tut.file.*;

public class FrontEnd
{
	public static void main(String[] args)
	{
		FileManager fileManager = new FileManager();
		try
		{			
			String[] readPersons = fileManager.readFile("c:\\data\\person.txt");
			
			for(String record : readPersons)
			{
				System.out.println(record);
			
			}
			
			String[] records = {"veli#baloyi#25#male","Veronica#jampies#28#female","Pauline#Ndou#21#female"};
			fileManager.writeToFile(records, "c:\\data\\person.txt");
		}
		catch(IOException er)
		{
			System.out.println("Error occured " + er.toString());
		}
		
	}

}