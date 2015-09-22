package fr.esiea.main.domain.users;

import java.util.Date;

public class Credential {
	
	private long id;
	private long userId;
	private String login;
	private String password;
	private String authorisation;
	private Date lastUse;
	
	public Credential(){}

	public Credential(long id, long userId, String login, String password,
			String authorisation, Date lastUse) {
		super();
		this.id = id;
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.authorisation = authorisation;
		this.lastUse = lastUse;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthorisation() {
		return authorisation;
	}

	public void setAuthorisation(String authorisation) {
		this.authorisation = authorisation;
	}

	public Date getLastUse() {
		return lastUse;
	}

	public void setLastUse(Date lastUse) {
		this.lastUse = lastUse;
	}
	
	
	
}
