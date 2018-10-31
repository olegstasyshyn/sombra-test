package com.sprhib.controller;

import com.sprhib.model.Author;
import com.sprhib.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import java.util.List;

@Controller
@RequestMapping(value = "/author")
public class AuthorController{

	@Autowired
	private AuthorService authorService;


	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView addAuthorPage() {
		ModelAndView modelAndView = new ModelAndView("add-author-form");
		modelAndView.addObject("author", new Author());
		return modelAndView;
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addingAuthor(@ModelAttribute("author") Author author) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		authorService.addAuthor(author);
		
		String message = "Author was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfAuthors() {
		ModelAndView modelAndView = new ModelAndView("list-of-authors");
		
		List<Author> authors = authorService.getAuthors();
		modelAndView.addObject("authors", authors);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editAuthorPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-author-form");
		Author author = authorService.getAuthor(id);
		modelAndView.addObject("author",author);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingAuthor(@ModelAttribute Author author, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");

		authorService.updateAuthor(author);

		String message = "Author was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteAuthor(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		authorService.deleteAuthor(id);
		String message = "Author was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}
