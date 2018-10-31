package com.sprhib.service;

import com.sprhib.dao.AuthorBookDAO;
import com.sprhib.model.AuthorBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorBookServiceImpl implements AuthorBookService{


    private AuthorBookDAO authorBookDAO;

    public void addAuthorBook(AuthorBook authorBook) {
        authorBookDAO.addAuthorBook(authorBook);
    }

    public void updateAuthorBook(AuthorBook authorBook) {
        authorBookDAO.updateAuthorBook(authorBook);
    }

    public AuthorBook getAuthorBook(int id) {
        return authorBookDAO.getAuthorBook(id);
    }

    public void deleteAuthorBook(int id) {
        authorBookDAO.deleteAuthorBook(id);
    }

    public List<AuthorBook> getAuthorBooks() {
        return authorBookDAO.getAuthorBooks();
    }

}
