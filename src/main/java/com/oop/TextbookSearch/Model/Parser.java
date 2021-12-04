package com.oop.TextbookSearch.Model;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parser {
	
	private final ArrayList<Textbook> textbooks = new ArrayList<>();
	
	/*
	 * parses zlib website for top 3 results from textbook search
	 * @param Textbook textbook 
	 * @return a list of the top 3 textbook results
	 */
	public ArrayList<Textbook> getZlibTextbook(Textbook textbook) {
		String textbookTitle = textbook.getTitle();
		
		System.setProperty("webdriver.chrome.driver","chromedriver");	
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://1lib.us/";

		try {
			driver.get(baseUrl);
			driver.findElement(By.id("searchFieldx")).sendKeys(textbookTitle); //enter textbook in search bar
			driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div/div[1]/form/div[1]/div/div[2]/div/button")).click(); //click search
			
			for (int i = 1; i <= 3; i++)
			{
				By by = By.xpath("/html/body/table/tbody/tr[2]/td/div/div/div/div[2]/div[" + (i * 2) +  "]/div/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3/a"); //retrieve results, throws an exception if no result found
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
	
	/*
	 * parses libgen website for top 3 results from textbook search
	 * @param Textbook textbook 
	 * @return a list of the top 3 textbook results
	 */
	public ArrayList<Textbook> getLibgenTextbook(Textbook textbook) {
		String textbookTitle = textbook.getTitle();
		
		System.setProperty("webdriver.chrome.driver","chromedriver");	
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://libgen.is/";
		driver.get(baseUrl);
		try {	
			driver.findElement(By.id("searchform")).sendKeys(textbookTitle); //enter textbook in search bar
			driver.findElement(By.xpath("/html/body/table/tbody[2]/tr/td[2]/form/input[2]")).click();	//click search
			
			for (int i = 2; i <= 4; i++)
			{
				String titleId = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[" + i + "]/td[1]")).getText(); //retrieve results, throws an exception if no result found
				String title = driver.findElement(By.id(titleId)).getText();
				
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
	
	
	/*
	 * returns accumulated textbooks from website parsing
	 * @return arraylist holding accumulated textbooks 
	 */
	public ArrayList<Textbook> getTextbooks() {
		return textbooks;
	}
	
	/*
	 * clears the arraylist holding the textbooks from the website parsing
	 * 
	 */
	public void clearTextbooks() {
		textbooks.clear();
	}

}
