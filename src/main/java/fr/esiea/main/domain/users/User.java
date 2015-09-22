package fr.esiea.main.domain.users;

public class User {
	
	private long id;
	private String lastName;
	private String firstName;
	private String userName;
	private String email;
	private UserLevel level;

	public User(){}
	
	public User(long id, String lastName, String firstName, String userName,
			String email, String level) {
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.userName = userName;
		this.email = email;
		try{
			this.level = UserLevel.valueOf(level.toUpperCase());
		} catch (Exception e){
			System.err.println("Can't find a reliable user level to  : " + level);
			this.level = UserLevel.valueOf("BASIC");
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserLevel getLevel() {
		return level;
	}

	public void setLevel(String level) {
		try{
			this.level = UserLevel.valueOf(level.toUpperCase());
		} catch (Exception e){
			System.err.println("Can't find a reliable user level to  : " + level);
			this.level = UserLevel.valueOf("BASIC");
		}
	}

	@Override
	public String toString() {
		return "User [id="+ id + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", userName=" + userName + ", email=" + email + ", level=" + level + "]";
	}

}
