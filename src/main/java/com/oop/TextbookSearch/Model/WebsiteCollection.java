package com.oop.TextbookSearch.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class WebsiteCollection {
	private static WebsiteCollection instance = null;
	int websiteCount = 2; 
	private final static ArrayList<String> websites = new ArrayList<>( Arrays.asList("Zlib", "Libgen"));	//first letter of website is capital to preserve camel casing of Parser methods
	
	private WebsiteCollection() {}
	
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
	 * @return a list of the links which have the textook
	 */
	public HashMap<String, ArrayList<Textbook>> getTextbookWebsiteInfo(Textbook textbook) {
			//populate textbookWebsites with Parser method results 
			//iterate through the websiteList to invoke Parser methods			
			HashMap<String, ArrayList<Textbook>> textbookWebsites = new HashMap<>();
			Parser parser = new Parser();
			
			
			for (int i = 0; i < websites.size(); i++) {
				ArrayList<Textbook> textbooks = new ArrayList<>(); 
				try {
					//using reflection to call parser methods
					Class<?> c = Class.forName("com.oop.TextbookSearch.Model.Parser");
					String methodName = "get" + websites.get(i) + "Textbook";
					//System.out.println(methodName);
					Method method = c.getDeclaredMethod(methodName, new Class[] {Textbook.class});
					//System.out.println(method.toString());
					textbooks = (ArrayList<Textbook>) method.invoke(parser, textbook);
					System.out.println(textbooks.toString());
				} catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
					e.printStackTrace();
					System.out.println(e.getCause());
				}
				textbookWebsites.put(websites.get(i), textbooks);
				//parser.getZLibTextbook(textbook);
			}
			
			return textbookWebsites;
	}
	
}
