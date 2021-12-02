package com.oop.TextbookSearch.Model;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parser {
	
	public ArrayList<Textbook> getLibgenTextbook(Textbook textbook) {
		String textbookTitle = textbook.getTitle();
		ArrayList<Textbook> textbooks = new ArrayList<>();
		//Document doc = Jsoup.connect("https://1lib.us/").get();
		//Elements element = doc.select("searchFieldx");

		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://libgen.is/";
		driver.get(baseUrl);
		//driver.findElement(By.id("searchFieldx"));
		
		//parse further for textbook in next milestone 
		
		return textbooks;
	}
	
	public ArrayList<Textbook> getZlibTextbook(Textbook textbook) {
		String textbookTitle = textbook.getTitle();
		
		System.out.println(textbook.getTitle());
		System.setProperty("webdriver.chrome.driver","chromedriver");	
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://1lib.us/";
		ArrayList<Textbook> textbooks = new ArrayList<>();
		try {
			driver.get(baseUrl);
			driver.findElement(By.id("searchFieldx")).sendKeys(textbookTitle); //enter textbook in search bar
			driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div/div[1]/form/div[1]/div/div[2]/div/button")).click(); //click search
			
			
			for (int i = 1; i <= 3; i++)
			{
				By by = By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div/div[2]/div[" + (i * 2) +  "]/div/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3/a"); //retrieve results
				String title = driver.findElement(by).getText();
				
				Textbook parsedTextbook = new Textbook();
				parsedTextbook.setTitle(title); 
				textbooks.add(parsedTextbook);
			}
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		
		return textbooks;
	}

}
