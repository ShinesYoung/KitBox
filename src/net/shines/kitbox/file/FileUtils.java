package net.shines.kitbox.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileUtils 
{
	public static String readStringFromFile(File inputFile)
	{
		byte[] bContent = FileUtils.readBytesFromFile(inputFile);
		if (bContent == null) {
			return null;
		}
		return new String(bContent, Charset.forName("UTF-8"));
	}
	
	public static byte[] readBytesFromFile(File inputFile)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(inputFile);
			byte[] bContent = new byte[fis.available()];
			fis.read(bContent);
			fis.close();
			
			return bContent;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (fis != null) {
				try { fis.close();} 
				catch (IOException e) {}
			}
		}
	}
	
	public static void writeToFile(File outputFile, String outputString)
	{
		if (outputString == null || outputString.equals("")) {
			return;
		}
		
		byte[] bContent = outputString.getBytes(Charset.forName("UTF-8"));
		// write the file content
		FileUtils.writeToFile(outputFile, bContent);
	}
	
	public static void writeToFile(File outputFile, byte[] bContent)
	{
		if (outputFile == null || outputFile.equals("")) {
			return;
		}
		
		if ( outputFile.exists() == false ) 
		{
			try {
				outputFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
		
		// write the file content
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outputFile);
			fos.write(bContent);
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) { 
				try { fos.close(); } 
				catch (IOException e) {} 
			}
		}
	}
	
	
}
