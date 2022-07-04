package com.furkancetiner.questapp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="p_like")
@Data
@Builder
public class Like {

	@Id
	private Long id;
	private Long postId;
	private Long userId;
	
}
