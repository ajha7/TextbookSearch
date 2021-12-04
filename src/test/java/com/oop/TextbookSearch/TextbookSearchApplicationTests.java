package com.oop.TextbookSearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.oop.TextbookSearch.Model.Parser;
import com.oop.TextbookSearch.Model.Textbook;

@SpringBootTest
class TextbookSearchApplicationTests {

	@Test
	void contextLoads() {
	}

	/*
	 * tests whether zlib parser gets top 3 results
	 * @result zlip parser takes top 3 results w/o errors
	 */
	@Test
	void testZlibParserTop3Results() {
		Parser parser = new Parser();
		Textbook textbook = new Textbook("Calculus");
		
		ArrayList<Textbook> textbooks = parser.getZlibTextbook(textbook);
		
		
		assertEquals("Calculus Made Easy", textbooks.get(0).getTitle());
		assertEquals("Thomas' Calculus", textbooks.get(1).getTitle());
		assertEquals("Calculus: Early Transcendentals 8th Edition (metric version)", textbooks.get(2).getTitle());
	}
	
	/*
	 * tests whether libgen parser gets top 3 results
	 * @result libgen parser takes top 3 results w/o errors
	 */
	@Test 
	void testLibgenParserTop3Results() {
		Parser parser = new Parser();
		Textbook textbook = new Textbook("Calculus");
		
		ArrayList<Textbook> textbooks = parser.getLibgenTextbook(textbook);
		assertEquals("Mathematical Problems in Image Processing: Partial Differential Equations And the Calculus of Variations [2nd ed.]\n"
				+ "9780387322001, 9780387445885, 0387322000", textbooks.get(0).getTitle());
		assertEquals("Introduction to Lambda calculus [free web version ed.]", textbooks.get(1).getTitle());
		assertEquals("Umbral calculus and Hopf algebras Proc Oklahoma\n"
				+ "0821850032, 9780821850039", textbooks.get(2).getTitle());
		
	}
	
	/*
	 * tests whether zlib parser gets empty results
	 * @result zlib parser returns exception, meaning empty results
	 */
	@Test
	void testZlibParserEmptyResults() {
		Parser parser = new Parser();
		Textbook textbook = new Textbook("ewerwer");
		
		try 
		{
			ArrayList<Textbook> textbooks = parser.getZlibTextbook(textbook);
			assertEquals("true", "false");
		}
		catch (org.openqa.selenium.NoSuchElementException e)
		{
			assertEquals("true", "true");
		}
	}
	
	/*
	 * tests whether libgen parser gets empty results
	 * @result libgen parser returns exception, meaning empty results
	 */
	@Test
	void testLibgenParserEmptyResults() {
		Parser parser = new Parser();
		Textbook textbook = new Textbook("ewerwer");
		
		try 
		{
			ArrayList<Textbook> textbooks = parser.getLibgenTextbook(textbook);
			assertEquals("true", "false");
		}
		catch (org.openqa.selenium.NoSuchElementException e)
		{
			assertEquals("true", "true");
		}
	}
	
	
}
