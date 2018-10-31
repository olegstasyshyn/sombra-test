package com.sprhib.service;

import com.sprhib.dao.AuthorDAO;
import com.sprhib.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public abstract class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;
    @Autowired
    private AuthorService authorService;

    public void addAuthor(Author author) {
        authorDAO.addAuthor(author);
    }

    public void updateAuthor(Author author) {
        authorDAO.updateAuthor(author);
    }

    public Author getAuthor(int id) {
        return authorDAO.getAuthor(id);
    }

    public void deleteAuthor(int id) {
        authorDAO.deleteAuthor(id);
    }

    public List<Author> getAuthors() {
        return authorDAO.getAuthors();
    }

    @Override
    public List<Author> findOlderThan() {
        return authorService.findOlderThan();
    }

    @Override
    public String getAuthorWhichHasTheMostBook() {
        return authorService.getAuthorWhichHasTheMostBook();
    }

}
