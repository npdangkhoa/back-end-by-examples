package spring.boot.hero.events;

import java.util.List;

import spring.boot.hero.github.RepositoryEvent;

public class DashboardEntry {
	private final GithubProject project;

	private final List<RepositoryEvent> events;
	
	
	public DashboardEntry(GithubProject project, List<RepositoryEvent> events) {
		this.project = project;
		this.events = events;
	}
	
	
	public List<RepositoryEvent> getEvents() {
		return events;
	}




	public GithubProject getProject() {
		return project;
	}
	
}
