package com.sprhib.service;

import com.sprhib.model.Author;
import com.sprhib.model.Book;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface BookService  extends JpaRepository<Book,Integer>{
    public void addBook(Book book);
    public void updateBook(Book book);
    public Book getBook(int id);
    public void deleteBook(int id);
    public List<Book> getBooks();


    @Query(value = "select b.name from books b join book_author a  where a.author_id in (select a.author_id from book_author a group by a.author_id having COUNT(a.author_id) > 1) ",nativeQuery = true)
    List<String> booksWhoseAuthorHasMoreThanOneWrittenBooks();
}
