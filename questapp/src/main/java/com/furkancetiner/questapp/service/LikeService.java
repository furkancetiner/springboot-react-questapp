package com.furkancetiner.questapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkancetiner.questapp.entities.Like;
import com.furkancetiner.questapp.entities.Post;
import com.furkancetiner.questapp.entities.User;
import com.furkancetiner.questapp.repository.LikeRepository;
import com.furkancetiner.questapp.request.LikeCreateRequest;

@Service
public class LikeService {

	private LikeRepository likeRepository;
	private UserService userService;
	private PostService postService;
		
	public LikeService(LikeRepository likeRepository, UserService userService, PostService postService) {
		this.likeRepository = likeRepository;
		this.userService = userService;
		this.postService = postService;
	}

	public List<Like> getAllLikesByWithParams(Optional<Long> userId, Optional<Long> postId) {
		List<Like> likeList;
		
		if(userId.isPresent()&&postId.isPresent()) {
			return likeRepository.findByUserIdAndPostId(userId.get(),postId.get());
		}else if(userId.isPresent()){
			return likeRepository.findByUserId(userId.get());
		}else if(postId.isPresent()) {
			return likeRepository.findByPostId(postId.get());
		}else {
			return likeRepository.findAll();
		}	
	}

	public Like getLikeById(Long likeId) {
		return likeRepository.findById(likeId).orElse(null);
	}

	public Like createLike(LikeCreateRequest createLikeRequest) {
		User user = userService.getUserByUserId(createLikeRequest.getUserId());
		Post post = postService.getByPostId(createLikeRequest.getPostId());
		
		if(user!=null&&post!=null) {
			Like like = Like.builder().id(createLikeRequest.getId()).user(user).post(post).build();
			return likeRepository.save(like);
		}
		return null;
	}

	public void deleteLikeById(Long likeId) {
		likeRepository.deleteById(likeId);
	}
	
	
}
