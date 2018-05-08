package com.example.demo.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.domain.Author;
import com.example.demo.domain.Post;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.PostRepository;

@Component
public class DataLoader {

	private final PostRepository postRepository;
	private final AuthorRepository authorRepository;

	@Autowired
	public DataLoader(PostRepository postRepository,AuthorRepository authorRepository){
		this.postRepository = postRepository;
		this.authorRepository = authorRepository;
	}

	@PostConstruct
	private void loadData(){
		// create an author
		Author rodrigo = new Author("Rodrigo");
		authorRepository.save(rodrigo);

		// create a post
		Post post = new Post("Spring Data Rocks!");
		post.setBody("Post Body here...");
		post.setAuthor(rodrigo);
		postRepository.save(post);
	}
}