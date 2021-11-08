package com.oop.TextbookSearch.Model;
import java.io.IOException;

import javax.lang.model.element.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Elements;
import org.jsoup.select.Document;

public class Parser {

	public Textbook getLibgenTextbook(Textbook textbook) {
		Textbook libgenTextbook = new Textbook();
		return libgenTextbook;
	}
	
	public Textbook getZLibTextbook(Textbook textbook) {
		Textbook zlibTextbook = new Textbook();
		return zlibTextbook;
	}

	public static void main(String[]args){
        Document d = null;
        try{
            d = Jsoup.connect("http://libgen.li/").get();
            String title = d.title();
            System.out.println("Heading : " + title);

            Elements link = d.select("a[href]");

            for(Elements link : links){
                System.out.println("\nLink : "+ link.attr("href"));
                System.out.println("Heading : " + link.text());

            }


        }catch (IOException e){
            e.printStackTrace();
        }



}
