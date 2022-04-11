package com.example.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

public class htmlFileReader {
	
		public String readFile(String fileName ) throws FileNotFoundException, IOException 
		{
			var textFile = new ClassPathResource(fileName);
			String result = "";	
			
			try (Scanner myScanner = new Scanner(textFile.getFile())) {
				while(myScanner.hasNextLine())
				{
					result += myScanner.nextLine();
				}
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}

			return result;
		}

}
