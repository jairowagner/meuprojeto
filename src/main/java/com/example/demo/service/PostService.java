package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;

@Service
public class PostService {

	private PostRepository postRepository;
	public PostService(PostRepository postRepository){
		this.postRepository = postRepository;
	}

	public Post getLatestPost(){
		return postRepository.findFirstByOrderByPostedDesc();
	}
	public List<Post> list() {
		return postRepository.findAllByOrderByPostedDesc();
	}
	public Optional<Post> findByAuthorFirstName(String firstName) {
		return postRepository.findByAuthor_FirstName(firstName);
	}
	public Post save(Post post){
		return post!=null?postRepository.save(post):null;
	}

	public Post get(Long id) {
		return postRepository.getOne(id);
	}
}