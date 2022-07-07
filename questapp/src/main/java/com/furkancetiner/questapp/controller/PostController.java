package com.furkancetiner.questapp.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.PostUpdate;
import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.furkancetiner.questapp.entities.Post;
import com.furkancetiner.questapp.entities.User;
import com.furkancetiner.questapp.request.PostCreateRequest;
import com.furkancetiner.questapp.request.PostUpdateRequest;
import com.furkancetiner.questapp.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	private PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	
	//"/posts"
	//"/posts?userId={userId}"
	@GetMapping
	public List<Post> getAllPost(@PathParam(value = "userId") Optional<Long> userId){
		return postService.getAllPost(userId);
	}
	
	
	// "/posts/{postId}"
	@GetMapping("/{postId}")
	public Optional<Post> getUserPost(@PathVariable Long postId){
		return postService.getByPostId(postId);
	}
	
	@PostMapping
	public Post createPost(@RequestBody PostCreateRequest newPostRequest) {
		return postService.createPost(newPostRequest);
	}
	
	@PutMapping("/{postId}")
	public Post updatePost(@PathVariable Long postId,@RequestBody PostUpdateRequest newPost) {
		return postService.updatePostById(postId, newPost);
	}
	
	@DeleteMapping("/{postId}")
	public void deletePost(@PathVariable Long postId) {
		postService.deletePostById(postId);
	}
	
}
