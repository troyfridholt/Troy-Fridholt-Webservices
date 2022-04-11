package com.example.demo;

import org.springframework.core.io.ClassPathResource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class csvFileReader {

	
	public orderBean processLine(String textLine) {
		orderBean ob = new orderBean();
		String [] columns = textLine.split(",");
		ob.setDate(columns[0]);
		ob.setRegion(columns[1]);
		ob.setFirstName(columns[2]);
		ob.setSurName(columns[3]);
		ob.setItem(columns[4]);
		ob.setUnits(columns[5]);
		ob.setUnitCost(columns[6]);
		ob.setTotalCost(columns[7]);
		
		
		return ob;
		
	}
	
	public ArrayList<orderBean> readFile (String filename) throws IOException{
		ArrayList<orderBean> orders = new ArrayList<orderBean>();
		
		var csvFile = new ClassPathResource(filename);
		Scanner myScanner = new Scanner(csvFile.getFile());
		while(myScanner.hasNext()) {
			String textLine = myScanner.nextLine();
			orderBean oneOrder = processLine(textLine);
			orders.add(oneOrder);
		}
		return orders;
	}
	
}
