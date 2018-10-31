package com.sprhib.dao;

import com.sprhib.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl implements AuthorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addAuthor(Author author) {
        getCurrentSession().save(author);
    }

    @Override
    public void updateAuthor(Author author) {
        Author authorToUpdate = getAuthor(author.getId());
        authorToUpdate.setName(author.getName());
        authorToUpdate.setGender(author.getGender());
        authorToUpdate.setBorn(author.getBorn());
        getCurrentSession().update(authorToUpdate);
    }

    @Override
    public Author getAuthor(int id) {
        Author author = (Author) getCurrentSession().get(Author.class, id);
        return author;
    }

    @Override
    public void deleteAuthor(int id) {
        Author author = getAuthor(id);
        if (author != null)
            getCurrentSession().delete(author);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Author> getAuthors() {
        return getCurrentSession().createQuery("from Author").list();
    }


}
