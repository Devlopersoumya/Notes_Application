package com.org.dto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

public class Notes {

	@Column(name="note_Id")
	private int Id;
	
	@Column(name="note_Title")
	private String Title;
	
	@Column(name="note_Description")
	private String Description;
	
	@ManyToMany
	@JoinColumn
	private User user;
}
