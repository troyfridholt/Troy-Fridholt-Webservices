package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;

public class overallService {

	
	private ArrayList<orderBean> orders;
	
	public void readFile(String filename) throws IOException {
		csvFileReader cs = new csvFileReader();
		orders = cs.readFile(filename);
		
	}
	
	public String toJson() {
		String order = "";
	
		
		for (orderBean orderBean : orders) {
			order += orderBean.toJsonString() + ",";
		}
		if (order.length() > 2){
			order = order.substring(0, order.length() - 1);
		}
		System.out.println(order);
		order = "{ \"Customer Order\":  [" + order + "] }";
		
		return order;
		
	}
	
}
