package com.furkancetiner.questapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkancetiner.questapp.entities.Comment;
import com.furkancetiner.questapp.entities.Post;
import com.furkancetiner.questapp.entities.User;
import com.furkancetiner.questapp.repository.CommentRepository;
import com.furkancetiner.questapp.request.CommentCreateRequest;
import com.furkancetiner.questapp.request.CommentUpdateRequest;

@Service
public class CommentService {

	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;

	public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
		this.commentRepository = commentRepository;
		this.userService = userService;
		this.postService = postService;
	}

	public List<Comment> getComments(Optional<Long> userId, Optional<Long> postId) {
		if (userId.isPresent() && postId.isPresent()) {
			return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
		} else if (userId.isPresent()) {
			return commentRepository.findByUserId(userId.get());
		} else if (postId.isPresent()) {
			return commentRepository.findByPostId(postId.get());
		} else {
			return commentRepository.findAll();
		}
	}

	public Comment createComment(CommentCreateRequest commentCreateRequest) {

		User user = userService.getUserByUserId(commentCreateRequest.getUserId());
		Post post = postService.getByPostId(commentCreateRequest.getPostId());
		
		if (user != null && post != null) {
			Comment comment = Comment.builder().id(commentCreateRequest.getId()).user(user).post(post)
					.text(commentCreateRequest.getText()).build();
			return commentRepository.save(comment);
		}

		return null;
	}


	public void deleteCommentById(Long commentId) {
		commentRepository.deleteById(commentId);
	}

	public Comment updateComment(Long commentId, CommentUpdateRequest newComment) {
		
		Optional<Comment>  comment= commentRepository.findById(commentId);
		
		if(comment.isPresent()) {
			Comment updatedComment = comment.get();
			updatedComment.setText(newComment.getText());
			commentRepository.save(updatedComment);
		}
		
		return null;
	}

	public Optional<Comment> getOneComment(Long commentId) {
		return commentRepository.findById(commentId);
	}
}
