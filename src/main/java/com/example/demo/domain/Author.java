package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Author {
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	@OneToMany(mappedBy = "author")
	private List<Post> posts;

	public Author() {
	}

	public Author(String firstName) {
		this.firstName = firstName;
	}
	//Getters & Setters
}