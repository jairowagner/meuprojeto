

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.PostService;

@Controller
@RequestMapping("/posts")
public class PostController {

	private final PostService postService;
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("post/index");
		mav.addObject("pageTitle", "Meu Blog");
		mav.addObject("posts", postService.list());
		return mav;
	}

	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("post/view");
		mav.addObject("post", postService.get(id));
		return mav;
	}
}