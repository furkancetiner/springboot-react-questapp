package com.furkancetiner.questapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.furkancetiner.questapp.entities.Like;
import com.furkancetiner.questapp.request.LikeCreateRequest;
import com.furkancetiner.questapp.service.LikeService;

@RestController
@RequestMapping("/likes")
public class LikeController {

	private LikeService likeService;

	public LikeController(LikeService likeService) {
		this.likeService = likeService;
	}

//	/likes
//	/likes?postId={postId}
//	/likes?user={userId}
//	/likes/{likeId}

	@GetMapping
	public List<Like> getAllLikesByWithParams(@RequestParam Optional<Long> userId,
			@RequestParam Optional<Long> postId) {
		return likeService.getAllLikesByWithParams(userId, postId);
	}

	@GetMapping("/{likeId}")
	public Like getLikeById(@PathVariable Long likeId) {
		return likeService.getLikeById(likeId);
	}
	
	@PostMapping
	public Like createLike(@RequestBody LikeCreateRequest createLikeRequest) {
		return likeService.createLike(createLikeRequest);
	}
	
	@DeleteMapping("/{likeId}")
	public void dleteLike(@PathVariable Long likeId) {
		likeService.deleteLikeById(likeId);
	}
	

}
