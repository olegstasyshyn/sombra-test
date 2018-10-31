package com.sprhib.controller;

import com.sprhib.model.AuthorBook;
import com.sprhib.service.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value="/author-book")
public class AuthorBookController {
	
	@Autowired
	private AuthorBookService authorBookService;
	
	@RequestMapping(value="/add-author-book", method=RequestMethod.GET)
	public ModelAndView addAuthorBookPage() {
		ModelAndView modelAndView = new ModelAndView("add-author-book-form");
		modelAndView.addObject("author-book", new AuthorBook());
		return modelAndView;
	}
	
	@RequestMapping(value="/add-author-book", method=RequestMethod.POST)
	public ModelAndView addingAuthorBook(@ModelAttribute AuthorBook authorBook) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		authorBookService.addAuthorBook(authorBook);
		
		String message = "Author book was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfAuthorBooks() {
		ModelAndView modelAndView = new ModelAndView("list-of-author-books");
		
		List<AuthorBook> authorBooks = authorBookService.getAuthorBooks();
		modelAndView.addObject("author-books", authorBooks);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editAuthorBookPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-author-book-form");
		AuthorBook authorBook = authorBookService.getAuthorBook(id);
		modelAndView.addObject("author-book",authorBook);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingAuthorBook(@ModelAttribute AuthorBook authorBook, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		authorBookService.updateAuthorBook(authorBook);
		
		String message = "Author book was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteTeam(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		authorBookService.deleteAuthorBook(id);
		String message = "Author book was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}
