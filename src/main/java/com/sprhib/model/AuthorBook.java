package com.sprhib.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@Table(name = "author_book")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AuthorBook {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Book book;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
