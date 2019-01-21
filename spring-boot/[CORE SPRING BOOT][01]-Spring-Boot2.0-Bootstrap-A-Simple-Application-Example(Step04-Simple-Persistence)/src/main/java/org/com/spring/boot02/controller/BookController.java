package org.com.spring.boot02.controller;

import java.util.List;

import org.com.spring.boot03.entity.Book;

public interface BookController {
	
	public Iterable findAll();
	
	public List findByTitle(String bookTitle);
	
	public Book findOne(Long id);
	
	public Book create(Book book);
	
	public void delete(Long id);
	
	public Book updateBook(Book book, Long id);
	
	
}
