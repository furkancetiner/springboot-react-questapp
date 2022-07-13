package com.furkancetiner.questapp.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.furkancetiner.questapp.entities.Comment;
import com.furkancetiner.questapp.request.CommentCreateRequest;
import com.furkancetiner.questapp.request.CommentUpdateRequest;
import com.furkancetiner.questapp.service.CommentService;
import com.furkancetiner.questapp.service.PostService;
import com.furkancetiner.questapp.service.UserService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	
	private CommentService commentService;

	@Autowired
	public CommentController(CommentService commentService, UserService userService, PostService postService) {	
		this.commentService = commentService;
	}

//	/comments
//	/comments?postId={postId}
//	/comments?user={userId}
//	/comments/{commentId}
	
	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Long> postId,@RequestParam Optional<Long> userId){
		return commentService.getComments(userId, postId);
	}
	
	
	@GetMapping("/{commentId}")
	public Optional<Comment> getOneComment(@PathVariable Long commentId) {
		return commentService.getOneComment(commentId);
	}
	
	
	@PostMapping
	public Comment createComment(@RequestBody CommentCreateRequest commentCreateRequest ){
		return commentService.createComment(commentCreateRequest);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest newComment){
		return commentService.updateComment(commentId, newComment);
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteComment(@PathVariable Long commentId){
		commentService.deleteCommentById(commentId);
	}
}
