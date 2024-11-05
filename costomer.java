package com.costomer;

public class costomer {
	private int id;//encapsulation
	private String fname;
	private String lname;
	private String username;
	private String email;
	private String address;
	private String mnumber;
	private String password;
	

	public costomer(int id, String fname, String lname, String username, String email, String address, String mnumber,String password ) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.email = email;
		this.address = address;
		this.mnumber = mnumber;
		this.password = password;
	}


	public int getId() {
		return id;
	}


	public String getFname() {
		return fname;
	}


	public String getLname() {
		return lname;
	}


	public String getUsername() {
		return username;
	}


	public String getEmail() {
		return email;
	}


	public String getAddress() {
		return address;
	}


	public String getMnumber() {
		return mnumber;
	}


	public String getPassword() {
		return password;
	}
}


