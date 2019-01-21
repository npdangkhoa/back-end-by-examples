package org.com.spring.boot02.controller;

import java.util.List;

import org.com.spring.boot03.entity.Book;
import org.com.spring.boot04.persistence.BookRepository;
import org.com.spring.boot05.exception.BookIdMismatchException;
import org.com.spring.boot05.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookControllerImpl implements BookController {
	
		@Autowired
		private BookRepository repositoty;

		@Override
		@GetMapping
		public Iterable findAll() {
			return repositoty.findAll();
		}

		@Override
		@GetMapping("/title/{bookTitle}")
		public List findByTitle(@PathVariable String bookTitle) {
			return repositoty.findByTitle(bookTitle);
		}

		@Override
		@GetMapping("/{id}")
		public Book findOne(@PathVariable Long id) {
			return repositoty.findById(id)
					.orElseThrow(BookNotFoundException::new);
		}

		@Override
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public Book create(@RequestBody Book book) {
			return repositoty.save(book);
		}

		@Override
		@DeleteMapping("/{id}")
		public void delete(@PathVariable Long id) {
			repositoty.findById(id).orElseThrow(BookNotFoundException::new);
			repositoty.deleteById(id);
		}

		@Override
		@PutMapping("/{id}")
		public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
			if(book.getId() != id) {
				throw new BookIdMismatchException();
			}
			
			repositoty.findById(id).orElseThrow(BookNotFoundException::new);
			
			return repositoty.save(book);
		}

		
		
}
