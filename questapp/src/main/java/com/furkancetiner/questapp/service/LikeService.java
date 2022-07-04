package com.furkancetiner.questapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.furkancetiner.questapp.repository.LikeRepository;

@Service
public class LikeService {

	@Autowired
	private LikeRepository likeRepository;
	
	public void save() {
		
	}
}
