package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	public Optional<Post> findByAuthor_FirstName(String firstName);
    public Post findFirstByOrderByPostedDesc();
    public List<Post> findAllByOrderByPosted();
	public Optional<Post> findByBodyContainingIgnoreCase(String string);
	public List<Post> findAllByOrderByPostedDesc();

}