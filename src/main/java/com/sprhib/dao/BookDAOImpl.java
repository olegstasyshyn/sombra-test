package com.sprhib.dao;


import com.sprhib.model.Author;
import com.sprhib.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addBook(Book book) {
        getCurrentSession().save(book);
    }

    @Override
    public void updateBook(Book book) {
        Book bookToUpdate = getBook(book.getId());
        bookToUpdate.setName(book.getName());
        bookToUpdate.setPublished(book.getPublished());
        bookToUpdate.setGenre(book.getGenre());
        bookToUpdate.setRating(book.getRating());
        getCurrentSession().update(bookToUpdate);
    }

    @Override
    public Book getBook(int id) {
        Book book = (Book) getCurrentSession().get(Book.class, id);
        return book;
    }

    @Override
    public void deleteBook(int id) {
        Book book = getBook(id);
        if (book != null)
            getCurrentSession().delete(book);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> getBooks() {
        return getCurrentSession().createQuery("from Book").list();
    }
}
