package com.oop.TextbookSearch.Model;

import java.util.ArrayList;
import java.util.HashMap;

public class WebsiteCollection {
	private static WebsiteCollection instance = null;
	/*private final static HashMap<String, > websiteList = new HashMap<>(
				("https://libgen.is/", getLibgenTextbook())
				"https://z-lib.org/"
			);*/
	
	private WebsiteCollection() {}
	
	public static WebsiteCollection getInstance() {
		if (instance == null) {
			instance = new WebsiteCollection();
		}
		return instance;
	}
	
	/*
	 * Retrieves the links which contain the desired textbook
	 * @param Textbook textbook 
	 * @return a list of the links which have the textook
	 */
	public ArrayList<String> getTextbookWebsites(Textbook textbook) {
			//populate textbookWebsites with Parser method results 
			//iterate through the websiteList to invoke Parser methods
			ArrayList<String> textbookWebsites = new ArrayList<>();
			
			return textbookWebsites;
	}
	
}
