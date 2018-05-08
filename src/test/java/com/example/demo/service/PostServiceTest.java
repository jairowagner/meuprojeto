package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Post;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    public void test_to_save(){
        // given
        Post post = new Post("title");
        // when
        Post saved = postService.save(post);
        // then
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getTitle()).isEqualTo("title");
    }

    @Test
    public void test_to_save_null_post(){
        // given

        // when
        Post saved = postService.save(null);
        // then
        assertThat(saved).isNull();
    }

    @Test
    public void test_to_find_all(){
        // given

        // when
        List<Post> retrievedPosts = postService.list();
        //then
        assertThat(retrievedPosts).size().isGreaterThanOrEqualTo(3);
    }
}