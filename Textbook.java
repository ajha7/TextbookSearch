package com.oop.TextbookSearch.Model;

public class Textbook 
{
	private String title; 
	private String ISBN; 
	private String author; 
	private int yearPublished; 
	private String language; 
	
	public Textbook(String title, String author) 
	{
		this.title = title; 
		this.author = author; 
	}
	
	public Textbook() 
	{
		
	}
	
	public String getTitle() {
		
		return this.title; 
	}
	
	public String getISBN() {
		
		return this.ISBN; 
	}
	
	public String getAuthor() {
		
		return this.author; 
	}
	
	public int getYearPublished() {
		
		return this.yearPublished;
	}
	
	public String getLanguage() {
		
		return this.language; 
	}
}
