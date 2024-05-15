package com.org.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

	@Column(name="user_Id")
	private int Id;
	
	@Column(name="user_Name")
	private String Name;
	
	@Column(name="user_Age")
	private int Age;
	
	@Column(name="user_Mobile")
	private long Mobile;
	
	@Column(name="user_Email")
	private String Email;
	
	@Column(name="user_password")
	private String Password;
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Notes>notes;
}
