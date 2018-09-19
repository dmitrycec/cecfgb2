package ru.st.selenium.model;

public class User {

	private String org;
	private String login;
	private String password;
	private Integer choiseOrg;
	private Integer choiseLogin;
	public String getOrg() {
		return org;
	}
	public User setOrg(String org) {
		this.org = org;
		return this;
	}
	public String getLogin() {
		return login;
	}
	public User setLogin(String login) {
		this.login = login;
		return this;
	}

	public String getPassword() {
		return password;
	}
	public User setPassword(String password) {
		this.password = password;
		return this;
	}
	public Integer getChoiseOrg() {
		return choiseOrg;
	}
	public User setChoiseOrg(Integer choiseOrg) {
		this.choiseOrg = choiseOrg;
		return this;
	}
	public Integer getChoiseLogin() {
		return choiseLogin;
	}
	public User setChoiseLogin(Integer choiseLogin) {
		this.choiseLogin = choiseLogin;
		return this;
	}

	
	
}
