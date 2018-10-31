package com.sprhib.service;

import com.sprhib.model.Author;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthorService extends JpaRepository<Author, Integer>{
    public void addAuthor(Author author);
    public void updateAuthor(Author author);
    public Author getAuthor(int id);
    public void deleteAuthor(int id);
    public List<Author> getAuthors();

    @Query(value = "from Authors a where year(current_date())- year(a.born)>55 order by a.born")
    List<Author> findOlderThan();

    @Query(value = "SELECT a.name FROM authors a LEFT JOIN book_author b GROUP BY a.name ORDER BY COUNT(b.book_id) DESC limit 1",nativeQuery = true)
    String getAuthorWhichHasTheMostBook();


}
