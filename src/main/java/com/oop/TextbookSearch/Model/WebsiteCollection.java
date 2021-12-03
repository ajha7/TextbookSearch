package com.oop.TextbookSearch.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// class holds a collection of the websites to parse and is the connection to the Controller


public class WebsiteCollection {
	private static WebsiteCollection instance = null;
	int websiteCount = 2; 
	private final static ArrayList<String> websites = new ArrayList<>( Arrays.asList("Zlib", "Libgen"));	//first letter of website is capital to preserve camel casing of Parser methods
	//private final static ArrayList<String> links = new ArrayList<>(Arrays.asList("https://1lib.us/", "https://libgen.is/")); 
	private WebsiteCollection() {}
	
	//Singleton design pattern so only one instance of the class can be created
	public static WebsiteCollection getInstance() {
		if (instance == null) {
			instance = new WebsiteCollection();
		}
		return instance;
	}
	
	
	public static ArrayList<String> getWebsites() {
		return websites; 
	}
	
	/*
	 * Retrieves the links which contain the desired textbook
	 * @param Textbook textbook 
	 * @return a list of the top 3 results for each website which potentially has the textbook
	 */
	public HashMap<String, ArrayList<Textbook>> getTextbookWebsiteInfo(Textbook textbook) {
			//populate textbookWebsites with Parser method results 
			//iterate through the websiteList to invoke Parser methods			
			HashMap<String, ArrayList<Textbook>> textbookWebsitesMap = new HashMap<>();
			Parser parser = new Parser();
			
			for (int i = 0; i < websites.size(); i++) {
				ArrayList<Textbook> textbooks = new ArrayList<>(); 
				try {
					//using reflection to call parser methods
					Class<?> c = Class.forName("com.oop.TextbookSearch.Model.Parser");
					String methodName = "get" + websites.get(i) + "Textbook";
				
					Method method = c.getDeclaredMethod(methodName, new Class[] {Textbook.class});
					
					method.invoke(parser, textbook);	//invokes the get*someWebsite*method 
					
					textbooks = parser.getTextbooks();	//retrieves the textbooks accumulated from the website
				} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
					e.printStackTrace();
		
					textbooks = parser.getTextbooks();	//retrieves the textbooks accumulated from the website in case an error is thrown
					System.out.println(e.getCause());
				}
				
				textbookWebsitesMap.put(websites.get(i), (ArrayList<Textbook>) textbooks.clone());	//stores the textbooks accumulated from the website into a map
				parser.clearTextbooks();	//clears the textbooks for the current website so the next website can populate an empty arraylist
			}
			
			return textbookWebsitesMap;
	}
	
}
