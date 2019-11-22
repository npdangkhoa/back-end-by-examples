package etags.for_.rest.with.spring;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assume.assumeTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.resttemplate.dto.Employee;

public class etagsJUnit {
	
	
	private static final String URI = "http://localhost:9000";
	
	private static final String URI_ALL_EMPLOYEE = URI + "/employees";

	@Test
	public void givenResourceExists_whenRetrievingResource_thenEtagIsAlsoReturned() {
		//When
		Response response = RestAssured.given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).get(URI_ALL_EMPLOYEE + "/1");
		//Then
		assertNotNull(response.getHeader(HttpHeaders.ETAG));		
	}
	
	@Test
	public void givenResourceWasRetrieved_whenRetrievingAgainWithEtag_thenNotModifiedReturned() {
		//Given
		Response response = RestAssured.given()
									   .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
									   .get(URI_ALL_EMPLOYEE + "/1");
		String etagStr = response.getHeader(HttpHeaders.ETAG);
		
		//When
		Response response2 = RestAssured.given()
										.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
										.header(HttpHeaders.IF_NONE_MATCH,etagStr)
										.get(URI_ALL_EMPLOYEE + "/1");
		
		assumeTrue(response2.getStatusCode() == 304);
		
	}
	
	@Test
	public void givenResourceWasRetrievedThenModified_whenRetrievingAgainWithEtag_thenResourceIsReturned() {
		//Given
		Response response = RestAssured.given()
				.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
				.get(URI_ALL_EMPLOYEE + "/1");
		String etag = response.getHeader(HttpHeaders.ETAG);
		Employee employee = response.as(Employee.class);
		
		employee.setFirstName(employee.getFirstName() + "_UPDATE");
		
		RestAssured.given()
					.body(employee)
					.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
					.put(URI_ALL_EMPLOYEE + "/1");
		
		//When
		Response response2 = RestAssured.given()
					.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
					.headers(HttpHeaders.IF_NONE_MATCH, etag)
					.get(URI_ALL_EMPLOYEE + "/1");
		
		assumeTrue(response2.getStatusCode() == 200);
	}
}
