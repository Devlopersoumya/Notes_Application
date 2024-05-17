package com.org.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User {
     
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="user_Id")
	private int Id;
	
	@Column(name="user_name")
	private String Name;
	
	@Column(name="user_age")
	private int Age;
	
	@Column(name="user_mobile")
	private long Mobile;
	
	@Column(name="user_email")
	private String Email;
	
	@Column(name="user_password")
	private String Password;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Notes>notes;
}
