package org.com.spring.boot1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.com.spring.boot01.config.Application;
import org.com.spring.boot03.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment=WebEnvironment.DEFINED_PORT)
public class LiveTest {
	private static final String API_ROOT = "http://localhost:9091/api/books";
	
	Response response = null;
	
	private Book createRamdomBook() {
		Book book = new Book();
		book.setTitle(RandomStringUtils.randomAlphabetic(10));
		book.setAuthor(RandomStringUtils.randomAlphabetic(15));
		return book;
	}
	
	private String createBookAsUri(Book book) {
		response = RestAssured.given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(book)
				.post(API_ROOT);
		return API_ROOT + "/" + response.jsonPath().get("id");
	}
	
	@Test
	public void whenGetAllBooks_thenOK() {
		response = RestAssured.get(API_ROOT);		
		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	}
	
	@Test
	public void whenGetBooksByTitle_thenOK() {
		Book book = createRamdomBook();
		createBookAsUri(book);
		response = RestAssured.get(API_ROOT + "/title/"+ book.getTitle());
		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
		assertTrue(response.as(List.class).size() > 0);
	}
	
	@Test
	public void whenGetCreatedBookById_thenOK() {
		Book book = createRamdomBook();
		String location = createBookAsUri(book);
		
		response = RestAssured.get(location);
		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
		assertEquals(book.getTitle(), response.jsonPath().get("title"));
	}
	
	@Test
	public void whenGetNotExistBookById_thenNotFound() {
		response = RestAssured.get(API_ROOT +"/"+ RandomStringUtils.randomNumeric(4));		
		assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
	}
	
	@Test
	public void whenCreateNewBook_thenCreated() {
		Book book = createRamdomBook();
		response = RestAssured.given()
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.body(book)
				.post(API_ROOT);
		
		assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
	}

	@Test
	public void whenInvalidBook_thenError() {
		Book book = createRamdomBook();
		book.setAuthor(null);
		response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(book).post(API_ROOT);

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
	}
	
	@Test
	public void whenUpdateCreatedBook_thenUpdated() {
		Book book = createRamdomBook();
		String location = createBookAsUri(book);
		book.setId(Long.parseLong(location.split("api/books/")[1]));
		book.setAuthor("newAuthor");
		response = RestAssured.given().contentType(MediaType.APPLICATION_JSON_VALUE).body(book).put(location);

		assertEquals(HttpStatus.OK.value(), response.getStatusCode());

		response = RestAssured.get(location);

		assertEquals(HttpStatus.OK.value(), response.getStatusCode());
		assertEquals("newAuthor", response.jsonPath().get("author"));
	}

	
	@Test
	public void whenDeleteCreatedBook_thenOk() {
	    Book book = createRamdomBook();
	    String location = createBookAsUri(book);
	    Response response = RestAssured.delete(location);
	     
	    assertEquals(HttpStatus.OK.value(), response.getStatusCode());
	 
	    response = RestAssured.get(location);
	    assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
	}
}
