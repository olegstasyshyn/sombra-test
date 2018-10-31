package com.sprhib.dao;

import com.sprhib.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorDAO{

    public void addAuthor(Author author);
    public void updateAuthor(Author author);
    public Author getAuthor(int id);
    public void deleteAuthor(int id);
    public List<Author> getAuthors();


}
