package spring.boot.hero.github;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RepositoryEvent {
	private final String type;
	
	private final OffsetDateTime creationTime;
	
	private final Actor actor;
	
	private final Issue issue;

	@JsonCreator
	public RepositoryEvent(@JsonProperty("event") String type, 
			@JsonProperty("created_at") OffsetDateTime creationTime, 
			@JsonProperty("actor") Actor actor, 
			@JsonProperty("issue") Issue issue) {
		super();
		this.type = type;
		this.creationTime = creationTime;
		this.actor = actor;
		this.issue = issue;
	}

	public String getType() {
		return type;
	}

	public OffsetDateTime getCreationTime() {
		return creationTime;
	}

	public Actor getActor() {
		return actor;
	}

	public Issue getIssue() {
		return issue;
	}
	
	
	
	
	
	
	
}
