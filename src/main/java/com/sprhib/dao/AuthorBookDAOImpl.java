package com.sprhib.dao;


import com.sprhib.model.AuthorBook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AuthorBookDAOImpl implements AuthorBookDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Autowired
    private AuthorDAO author;
    @Autowired
    private BookDAO book;
    @Autowired
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addAuthorBook(AuthorBook authorBook) {
        getCurrentSession().save(authorBook);
    }

    @Override
    public void updateAuthorBook(AuthorBook authorBook) {
        AuthorBook authorBookToUpdate = getAuthorBook(authorBook.getId());
        authorBookToUpdate.setBook(book.getBook(authorBook.getId()));
        authorBookToUpdate.setAuthor(author.getAuthor(authorBook.getId()));
        getCurrentSession().update(authorBook);
    }

    @Override
    public AuthorBook getAuthorBook(int id) {
        AuthorBook authorBook = (AuthorBook) getCurrentSession().get(AuthorBook.class, id);
        return authorBook;
    }

    @Override
    public void deleteAuthorBook(int id) {
        AuthorBook authorBook = getAuthorBook(id);
        if (authorBook != null)
            getCurrentSession().delete(authorBook);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<AuthorBook> getAuthorBooks() {
        return getCurrentSession().createQuery("from AuthorBook").list();
    }
}
