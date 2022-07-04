package com.furkancetiner.questapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furkancetiner.questapp.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
