package com.sprhib.controller;

import com.sprhib.model.Book;
import com.sprhib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value="/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/add-book", method=RequestMethod.GET)
	public ModelAndView addBookPage() {
		ModelAndView modelAndView = new ModelAndView("add-book-form");
		modelAndView.addObject("book", new Book());
		return modelAndView;
	}
	
	@RequestMapping(value="/add-book", method=RequestMethod.POST)
	public ModelAndView addingBook(@ModelAttribute Book book) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		bookService.addBook(book);

		String message = "Book was successfully added.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/list")
	public ModelAndView listOfBooks() {
		ModelAndView modelAndView = new ModelAndView("list-of-books");

		List<Book> books = bookService.getBooks();
		modelAndView.addObject("books", books);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editBookPage(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit-book-form");
		Book book = bookService.getBook(id);
		modelAndView.addObject("book",book);
		return modelAndView;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView edditingBook(@ModelAttribute Book book, @PathVariable Integer id) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		bookService.updateBook(book);
		
		String message = "Book was successfully edited.";
		modelAndView.addObject("message", message);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteBook(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("home");
		bookService.deleteBook(id);
		String message = "Book was successfully deleted.";
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}
