package com.gem.models;

public class Dwarf {
	private int id;
	private String email;
	private String password;
	private String username;
	private String firstName;
	private String lastName;
	private String role;
	private int roleId;
	
	// Explicit NoArg Constructor
	public Dwarf() {
		
	}
	
	// What findAll() returns
	public Dwarf(int id, String email, String password, String username, String firstName, String lastName, String role) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	
	// what create() gets
	public Dwarf(String email, String username, String password) {
		this.email = email;
		this.username = username;
		this.password = password;
	}
	// updating
	public Dwarf(String email, String username, String password, String firstName, String lastName) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	// for logging in 
	public Dwarf(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

	@Override
	public String toString() {
		return "Dwarf [id=" + id + ", email=" + email + ", password=" + password + ", username=" + username
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + "]";
	}
	
	
}
