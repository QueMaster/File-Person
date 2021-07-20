
package za.ac.tut.file;
import java.io.*;
public class FileManager
{

	private File file;
	
	public void openFile(String path)
	{
		file = new File(path);
	}
	
	public int numberOfRecords(String strFile) throws IOException
	{
		int countRows = 0;
		//Open the file to read
		openFile(strFile);
		//Read the content of the file
		FileReader fileReader = new FileReader(file);
		//Buffered Reader to read the content into memory
		BufferedReader buffer = new BufferedReader(fileReader);
		//Read each record
		String record = buffer.readLine();
		while(record != null)  // determine end of file using null value
		{
		   countRows++;
		   record = buffer.readLine();
		}
		//close the buffer
		buffer.close();
		//Close the stream 
		fileReader.close();
		return countRows;
	}
	
	public String[] readFile(String strFile) throws IOException
	{
		String[] strPersons = new String[numberOfRecords(strFile)]; //resize the arr
		//open the file to read
		openFile(strFile);
		//Open the stream to read
		FileReader fileReader = new FileReader(file);
		//Open the buffer to read the content of a file
		BufferedReader buffer = new BufferedReader(fileReader);
		//Read the record
		String record = buffer.readLine();
		//index of the array
		int index = 0;
		while(record != null)
		{ 
		 //Store each record to the array
		  strPersons[index] = record;
		  //read next record
		  record = buffer.readLine();
		  //increment the index by 1
		  index++;
		}
		//Close the buffer
		buffer.close();
		//close stream
		fileReader.close();
		return strPersons;	
	}
	
	public void writeToFile(String[] records, String strFile) throws IOException
	{
		//open the file to writeToFile
		openFile(strFile);
		//Open the output stream
		FileWriter fileWriter = new FileWriter(file); // none appendable - remove ee
		//Buffer to write to a file
		BufferedWriter buffer = new BufferedWriter(fileWriter);
		//for each from the string array of records
		for(String strRecord : records)
		{
			buffer.write(strRecord);
			//Move to the next line
			buffer.newLine();
		}
		//close the buffer
		buffer.close();
		//close stream
		fileWriter.close();
	}
	
	public void printToFile(String[] records, String strFile) throws IOException
	{
		//open the file to writeToFile
		openFile(strFile);
		//Open the output stream
		FileWriter fileWriter = new FileWriter(file, true); // appendable 
		//Buffer to write to a file
		PrintWriter buffer = new PrintWriter(fileWriter);
		//for each from the string array of records
		for(String strRecord : records)
		{
			//Write a record and move to the next line
			buffer.println(strRecord);
			
		}
		//close the buffer
		buffer.close();
		//close stream
		fileWriter.close();
	}
}