package com.sprhib.dao;

import com.sprhib.model.Author;
import com.sprhib.model.Book;

import java.util.List;

public interface BookDAO {

    public void addBook(Book book);
    public void updateBook(Book book);
    public Book getBook(int id);
    public void deleteBook(int id);
    public List<Book> getBooks();

}
