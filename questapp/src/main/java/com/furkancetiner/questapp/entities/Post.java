package com.furkancetiner.questapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="post")
@Data
@Builder
public class Post {

	@Id
	private Long id;
	private Long userId;
	private String title;
	@Lob
	@Column(columnDefinition = "text")//hibernate in mysqlde varchar 255 yerine text alması için
	private String text;
}
