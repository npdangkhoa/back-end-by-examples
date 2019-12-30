package spring.boot.hero.github;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Issue {
	private final String HtmlUrl;
	private final int number;
	private final String title;
	
	@JsonCreator
	public Issue(@JsonProperty("html_url") String htmlUrl, 
			@JsonProperty("number") int number, @JsonProperty("title") String title) {
		super();
		HtmlUrl = htmlUrl;
		this.number = number;
		this.title = title;
	}

	public String getHtmlUrl() {
		return HtmlUrl;
	}

	public int getNumber() {
		return number;
	}

	public String getTitle() {
		return title;
	}
	
	
	
}
