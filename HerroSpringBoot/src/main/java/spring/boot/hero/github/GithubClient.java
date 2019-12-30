package spring.boot.hero.github;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import spring.boot.hero.properties.GithubProperties;

@Component
public class GithubClient {
	public static final String EVENT_ISSUES_URL = "https://api.github.com/repos/{owner}/{repo}/issues/events";
	
	private final RestTemplate restTemplate;

	public GithubClient(RestTemplateBuilder builder, GithubProperties properties) {
		super();
		this.restTemplate = builder
				.additionalInterceptors(new GithubAppTokenInterceptor(properties.getToken()))
				.build();
	}
	
	public ResponseEntity<RepositoryEvent[]> fetchEvent(String ownerName, String repoName) {
		return restTemplate.getForEntity(EVENT_ISSUES_URL, RepositoryEvent[].class, ownerName, repoName);
	}
	
	public List<RepositoryEvent> fetchEventList(String ownerName, String repoName){
		return Arrays.asList(this.fetchEvent(ownerName, repoName).getBody());
	}
	
	private static class GithubAppTokenInterceptor implements ClientHttpRequestInterceptor {
		
		private final String token;
		
		
		public GithubAppTokenInterceptor(String token) {
			this.token = token;
		}

		public String getToken() {
			return token;
		}


		@Override
		public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
				throws IOException {
			if(StringUtils.hasText(token)) {
				byte[] basicAuthValue = this.token.getBytes(StandardCharsets.UTF_8);
				request.getHeaders().set(HttpHeaders.AUTHORIZATION	, "Basic" + Base64Utils.encodeToString(basicAuthValue));
			}
			return execution.execute(request, body);
		}
		
	}
	
}
