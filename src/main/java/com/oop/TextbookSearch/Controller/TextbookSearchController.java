package com.oop.TextbookSearch.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.oop.TextbookSearch.Model.Textbook;

@Controller
public class TextbookSearchController {

    private Textbook textbook;

    public TextbookSearchController() {
    	
    }
    
    public TextbookSearchController(Textbook textbook) {
		this.textbook = textbook;
	}

    
    @RequestMapping(value="/")
    public String homePage() {
    	return "index";
    }
    
    public void invokeTextbookSearch(String title, String ISBN, String author, int yearPublished, String language){

    	
    }

    public void updateView(){
        
    }

}