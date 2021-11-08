package com.oop.TextbookSearch.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.oop.TextbookSearch.Model.Textbook;
import com.oop.TextbookSearch.Model.WebsiteCollection;

import org.springframework.ui.Model;

@Controller
public class TextbookSearchController {

    private Textbook textbook;

    public TextbookSearchController() {
    	
    }
    
    public TextbookSearchController(Textbook textbook) {
		this.textbook = textbook;
	}

    
    @RequestMapping(value="/")
    public String homePage(Model model) {	
    	model.addAttribute("textbookObj", new Textbook());
    	return "index";
    }
    
    @PostMapping(value="/search")
    public String resultsPage(Model model, @ModelAttribute("textbookObj") Textbook textbookObj) {
    	ArrayList<String> links = invokeTextbookSearch(textbook);
    	try {	
			Thread.sleep(1000);		//sleep so Parser has time to parse and display results to web page
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	model.addAttribute("links", links);
    	return "results";
    }
    
    private ArrayList<String> invokeTextbookSearch(Textbook textbook){
    	WebsiteCollection websiteCollection = new WebsiteCollection();
    	return websiteCollection.getTextbookWebsites(textbook);
    }
    
    /*
    private void invokeTextbookSearch(String title, String ISBN, String author, int yearPublished, String language){

    	
    }
	*/

}