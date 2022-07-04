package com.furkancetiner.questapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="comment")
@Data
public class Comment {

	@Id
	private Long id;
	
	private Long postId;
	private Long userId;
	
	@Lob
	@Column(columnDefinition = "text")//hibernate in mysqlde varchar 255 yerine text alması için
	private String text;
	
}
