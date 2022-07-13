package com.furkancetiner.questapp.request;

import lombok.Data;

@Data
public class CommentCreateRequest {

	private Long id;
	private Long postId;
	private Long userId;
	private String text;
	
}
