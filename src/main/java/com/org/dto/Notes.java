package com.org.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
 @Setter
 @Getter
 @Entity
public class Notes {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int Id;
	
	
	private String Title;
	
	
	private String Description;
	
	@ManyToOne
	@JoinColumn
	private User user;
}
