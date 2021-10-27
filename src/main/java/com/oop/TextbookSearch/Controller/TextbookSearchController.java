package com.oop.TextbookSearch.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TextbookSearchController {

    private Textbook textbook;

    public Controller(Textbook textbook) {
		this.textbook = textbook;
	}

    public void invokeTextbookSearch(String title, String ISBN, String author, int yearPublished, String language){
    }

    public void updateView(){
    }

}
