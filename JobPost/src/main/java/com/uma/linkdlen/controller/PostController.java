package com.uma.linkdlen.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uma.linkdlen.model.Post;
import com.uma.linkdlen.model.PostRepository;
@RestController
@RequestMapping("/job")
public class PostController {
	@Autowired
	private PostRepository postRepository;
	
	@PostMapping("/new/post")
	public Post newJobPost(@RequestBody Post post) {
		return postRepository.save(post);
	}

	@GetMapping("/details")
	public List<Post> getAllPostDetails() {
		return postRepository.findAll();
	}

	@GetMapping("/post{id}")
	
	 public Optional<Post> getbyRole(@PathVariable Long id) {
		return postRepository.findById(id);
	}
	
	@PutMapping("/post/{id}")
	String updatePost(@RequestBody Post event, @PathVariable Long id) {
		Post post1 =postRepository.findById(id).get();
		post1.setJobTittle(post1.getJobTittle());
		post1.setCompany(post1.getCompany());
		post1.setExperience(post1.getExperience());
		post1.setWorkPlace(post1.getWorkPlace());
		post1.setJobLocation(post1.getJobLocation());
			post1.setJobType(post1.getJobType());
			post1.setSalary(post1.getSalary());
	
			 postRepository.save(post1);
		return "updated..";
	}

	@DeleteMapping("/post/delete/{id}")
	String deleteJobPost(@PathVariable Long id) {
		postRepository.deleteById(id);
		return "Post with id " + id + " has been deleted success.";
	}
	@GetMapping("/post")
public String getPage() {
		return "Welcome...";
}
}
