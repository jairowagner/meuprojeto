package com.example.demo.repository;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Author;
import com.example.demo.domain.Post;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private PostRepository postRepository;

    @Test
    public void test_to_fund_user_by_authors_name() {
        // given
        Author author = new Author("Rodrigo");
        entityManager.persist(author);
        entityManager.flush();

        Post post= new Post();
        post.setAuthor(author);
        entityManager.persist(post);
        entityManager.flush();

        // when
        Optional<Post> found = postRepository.findByAuthor_FirstName("Rodrigo");

        // then
        assertEquals(found.get().getAuthor().getFirstName(),"Rodrigo");
    }

    @Test
    public void test_to_find_by_body() {
        // given
    	  Post post= new Post();
          post.setBody("Olá! Bem vindo ao meu Blog!");
          entityManager.persist(post);
          entityManager.flush();

        // when
          Optional<Post> found = postRepository.findByBodyContainingIgnoreCase("BlOg");
    	//Procura por "BlOg"


        // then
    	//Encontra o post
          assertEquals(found.get().getBody(),"Olá! Bem vindo ao meu Blog!");

    }
}