package com.student.model;

import java.util.List;

public class student {
/* Response of the GET. We need to create variables for POST method to use them as as BODY for POST call
	{
        "id": 2,
        "firstName": "Murphy",
        "lastName": "Holmes",
        "email": "faucibus.orci.luctus@Duisac.net",
        "programme": "Financial Analysis",
        "courses": [
            "Accounting",
            "Statistics"
        ]
    }*/
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String programme;
	
	private List<String> courses;

	//create setters and getters of above 

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProgramme() {
		return programme;
	}

	public void setProgramme(String programme) {
		this.programme = programme;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	
}
