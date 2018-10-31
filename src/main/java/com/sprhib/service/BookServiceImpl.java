package com.sprhib.service;

import com.sprhib.dao.BookDAO;
import com.sprhib.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public abstract class BookServiceImpl implements BookService {
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    private BookService bookService;

    public void addBook(Book book) {
        bookDAO.addBook(book);
    }

    public void updateBook(Book book) {
        bookDAO.updateBook(book);
    }

    public Book getBook(int id) {
        return bookDAO.getBook(id);
    }

    public void deleteBook(int id) {
        bookDAO.deleteBook(id);
    }

    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }

    @Override
    public List<String> booksWhoseAuthorHasMoreThanOneWrittenBooks() {
        return bookService.booksWhoseAuthorHasMoreThanOneWrittenBooks();
    }


}
