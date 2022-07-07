package com.furkancetiner.questapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furkancetiner.questapp.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
	
	public List<Post> findByUserId(Long id);

}
