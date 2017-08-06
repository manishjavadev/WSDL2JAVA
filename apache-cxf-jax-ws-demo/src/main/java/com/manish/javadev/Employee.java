package com.manish.javadev;

public class Employee {
	private String fname;
	private String lastName;

	public Employee() {
		super();
	}

	public Employee(String fname, String lastName) {
		super();
		this.fname = fname;
		this.lastName = lastName;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
