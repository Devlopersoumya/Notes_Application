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
	
	private int Id;
	
	
	private String Name;
	
	
	private int Age;
	
	
	private long Mobile;
	

	private String Email;
	
	
	private String Password;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Notes>notes;
}
