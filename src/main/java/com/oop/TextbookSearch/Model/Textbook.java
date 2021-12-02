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
	
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param iSBN the iSBN to set
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @param yearPublished the yearPublished to set
	 */
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Override
	public String toString() {
		return "title: " + this.getTitle();
	}
}
