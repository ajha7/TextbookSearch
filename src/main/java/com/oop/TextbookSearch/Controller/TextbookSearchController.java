package com.oop.TextbookSearch.Controller;

import java.util.ArrayList;
import java.util.HashMap;

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
    	
    	HashMap<String, ArrayList<Textbook>> textbooks = invokeTextbookSearch(textbookObj);
    	try {	
			Thread.sleep(1000);		//sleep so Parser has time to parse and display results to web page
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	model.addAttribute("listOfWebsites", WebsiteCollection.getWebsites());
    	model.addAttribute("textbooks", textbooks);
    	return "results";
    }
    
    private HashMap<String, ArrayList<Textbook>> invokeTextbookSearch(Textbook textbook){
    	WebsiteCollection websiteCollection = WebsiteCollection.getInstance();
    	return websiteCollection.getTextbookWebsiteInfo(textbook);
    }
    
    /*
    private void invokeTextbookSearch(String title, String ISBN, String author, int yearPublished, String language){

    	
    }
	*/

}