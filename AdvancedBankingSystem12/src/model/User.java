package model;

public class User {
	protected String userid;
	protected String username;
	protected String password;
	public User(String userid, String username, String password) {
		this.userid = userid;
		this.username = username;
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public boolean passwordChacker(String inputpassword) {
		return this.password.equals(inputpassword);
	}
	

}
