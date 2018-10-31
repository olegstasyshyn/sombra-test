package com.sprhib.dao;

import com.sprhib.model.AuthorBook;

import java.util.List;

public interface AuthorBookDAO {

    public void addAuthorBook(AuthorBook authorBook);
    public void updateAuthorBook(AuthorBook authorBook);
    public AuthorBook getAuthorBook(int id);
    public void deleteAuthorBook(int id);
    public List<AuthorBook> getAuthorBooks();

}
