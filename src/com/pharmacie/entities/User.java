package com.pharmacie.entities;

public class User {
	private int id;
	private String username;
	private String password;
	private Role role;
	
	
	public User() {
		super();
	}


	public User(String username, String passwd, Role role) {
		super();
		this.username = username;
		this.password = passwd; 
		this.role = role;
	}


	public User(int id, String username, String password, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPasswd(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", passwd=" + password + ", role=" + role + "]";
	}
	
	

}
