package com.oop.TextbookSearch.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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

    
    /*
     * Brings up home page at "/"
     */
    @RequestMapping(value="/")
    public String homePage(Model model) {	
    	model.addAttribute("textbookObj", new Textbook());
    	return "index";
    }
    
    /*
     * Brings up result page at "/search" with textbook results 
     */
    @PostMapping(value="/search")
    public String resultsPage(Model model, @ModelAttribute("textbookObj") Textbook textbookObj) {
    	
    	HashMap<String, ArrayList<Textbook>> textbooks = invokeTextbookSearch(textbookObj);	
    	
    	try {	
			Thread.sleep(1000);		//sleep for processing time
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	model.addAttribute("listOfWebsites",WebsiteCollection.getWebsites());	//pass list of websites to frontned
    	model.addAttribute("textbooks", textbooks);		//pass textbooks to frontend 
    	return "results";	
    }
    
    /*
     * calls Model to search for textbooks online
     * @param Textbook textbook
     * @return information about potential textbooks found online
     */
    private HashMap<String, ArrayList<Textbook>> invokeTextbookSearch(Textbook textbook){
    	WebsiteCollection websiteCollection = WebsiteCollection.getInstance();
    	return websiteCollection.getTextbookWebsiteInfo(textbook);
    }

}