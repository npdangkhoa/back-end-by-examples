package org.com.spring.boot04.persistence;

import java.util.List;

import org.com.spring.boot03.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByTitle(String title);
}
