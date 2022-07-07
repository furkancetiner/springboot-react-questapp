package com.furkancetiner.questapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkancetiner.questapp.entities.Post;
import com.furkancetiner.questapp.entities.User;
import com.furkancetiner.questapp.repository.PostRepository;
import com.furkancetiner.questapp.request.PostCreateRequest;
import com.furkancetiner.questapp.request.PostUpdateRequest;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserService userService;

	public List<Post> getAllPost(Optional<Long> userId) {

		if (userId.isPresent()) {
			return postRepository.findByUserId(userId.get());
		}
		return postRepository.findAll();
	}

	public Optional<Post> getByPostId(Long postId) {
		return postRepository.findById(postId);
	}

	public Post createPost(PostCreateRequest newPostRequest) {

		Optional<User> user = userService.findByUserId(newPostRequest.getUserId());

		if (user.isPresent()) {
			Post post = Post.builder().text(newPostRequest.getText()).title(newPostRequest.getTitle()).user(user.get())
					.id(newPostRequest.getId()).build();
			return postRepository.save(post);
		}
		return null;//return an exception
	}

	public Post updatePostById(Long postId, PostUpdateRequest newPost) {

		Optional<Post> post = postRepository.findById(postId);

		if (post.isPresent()) {
			Post updatedPost = Post.builder().id(post.get().getId()).text(newPost.getText()).title(newPost.getTitle())
					.user(post.get().getUser()).build();
			return postRepository.save(updatedPost);
		}
		return null;//return an exception
	}

	public void deletePostById(Long postId) {
		postRepository.deleteById(postId);
	}
}
