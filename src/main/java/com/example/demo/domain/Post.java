package com.example.demo.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Data
public class Post {
    @Id @GeneratedValue
    private Long id;
    private String title;
    @Lob
    private String body;
    @CreatedDate
    private LocalDateTime posted;
    @ManyToOne
    private Author author;

    public Post() {}

    public Post(String title) {
		this.title=title;
	}
	//Getters & Setters
}