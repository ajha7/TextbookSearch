package com.oop.TextbookSearch.Model;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parser {

	public Textbook getLibgenTextbook(Textbook textbook) {
		Textbook libgenTextbook = new Textbook();
		
		//Document doc = Jsoup.connect("https://1lib.us/").get();
		//Elements element = doc.select("searchFieldx");

		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://libgen.is/";
		driver.get(baseUrl);
		driver.findElement(By.id("searchFieldx"));
				
		//parse further for textbook in next milestone 
		
		return libgenTextbook;
	}
	
	public Textbook getZLibTextbook(Textbook textbook) {
		Textbook zlibTextbook = new Textbook();
		
		//Document doc = Jsoup.connect("https://1lib.us/").get();
		//Elements element = doc.select("searchFieldx");

		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://1lib.us/";
		driver.get(baseUrl);
		driver.findElement(By.id("searchFieldx"));
		
		//parse further for textbook in next milestone
		return zlibTextbook;
	}

}
