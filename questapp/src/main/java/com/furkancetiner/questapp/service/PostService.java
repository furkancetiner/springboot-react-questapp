package com.furkancetiner.questapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkancetiner.questapp.entities.Post;
import com.furkancetiner.questapp.entities.User;
import com.furkancetiner.questapp.repository.PostRepository;
import com.furkancetiner.questapp.request.PostCreateRequest;
import com.furkancetiner.questapp.request.PostUpdateRequest;
import com.furkancetiner.questapp.response.PostResponse;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserService userService;

	public List<PostResponse> getAllPost(Optional<Long> userId) {
		List<Post> postList;
		if (userId.isPresent()) {
			postList = postRepository.findByUserId(userId.get());
		}else {
			postList = postRepository.findAll();
		}
		return postList.stream().map(p-> new PostResponse(p)).collect(Collectors.toList());
	}

	public Post getByPostId(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createPost(PostCreateRequest newPostRequest) {

		User user = userService.getUserByUserId(newPostRequest.getUserId());

		if (user!=null) {
			Post post = Post.builder().text(newPostRequest.getText()).title(newPostRequest.getTitle()).user(user)
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
