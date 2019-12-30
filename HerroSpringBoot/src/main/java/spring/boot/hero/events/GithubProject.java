package spring.boot.hero.events;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GITHUB_PROJECT")
public class GithubProject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6864729285701407030L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String orgName;
	
	@Column(unique = true)
	private String repoName;


	public GithubProject() {
		super();
	}

	public GithubProject(String orgName, String repoName) {
		super();
		this.orgName = orgName;
		this.repoName = repoName;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getRepoName() {
		return repoName;
	}

	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}

	@Override
	public String toString() {
		return "GitHubProject [id=" + id + ", orgName=" + orgName + ", repoName=" + repoName + "]";
	}

	 
}
