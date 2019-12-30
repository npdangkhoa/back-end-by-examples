package spring.boot.hero.events;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.boot.hero.github.GithubClient;
import spring.boot.hero.github.RepositoryEvent;

@Controller
public class EventController {
	
	private GithubProjectRepository projectRepository;
	
	private GithubClient client;
	
	
	
	public EventController(GithubProjectRepository projectRepository, GithubClient client) {
		super();
		this.projectRepository = projectRepository;
		this.client = client;
	}

	@GetMapping("/hello")
	public String hello(Model model) {
		return "hello";		
	}


	@GetMapping("/events/{repoName}")
	@ResponseBody
	public RepositoryEvent[] fetchEvents(@PathVariable String repoName) {
		GithubProject gitHubEntity = projectRepository.findByRepoName(repoName);
		
		ResponseEntity<RepositoryEvent[]> fetchEvent = client.fetchEvent(gitHubEntity.getOrgName(), gitHubEntity.getRepoName());
		return fetchEvent.getBody();
	}
	
	@GetMapping("/")
	public String dashboard(Model model) {
		Iterable<GithubProject> iterable = projectRepository.findAll();
		
		List<DashboardEntry> collect = StreamSupport.stream(iterable.spliterator(), true)
		.map(x -> new DashboardEntry(x, client.fetchEventList(x.getOrgName(), x.getRepoName())))
		.collect(Collectors.toList());
		
		model.addAttribute("entries", collect);
		return "dashboard";
		
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		model.addAttribute("projects", this.projectRepository.findAll());
		return "admin";
	}
	
	

}
