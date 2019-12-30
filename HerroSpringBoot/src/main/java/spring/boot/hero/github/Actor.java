package spring.boot.hero.github;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Actor {
	private final String login;
	private final String avatarUrl;
	private final String HtmlUrl;
	
	@JsonCreator
	public Actor(@JsonProperty("login")String login, 
				@JsonProperty("avartar_url")String avatarUrl, 
				@JsonProperty("html_url")String htmlUrl) {
		super();
		this.login = login;
		this.avatarUrl = avatarUrl;
		HtmlUrl = htmlUrl;
	}

	public String getLogin() {
		return login;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public String getHtmlUrl() {
		return HtmlUrl;
	}

	
	
}
