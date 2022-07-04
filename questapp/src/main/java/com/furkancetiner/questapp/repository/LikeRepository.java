package com.furkancetiner.questapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.furkancetiner.questapp.entities.Like;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long>{

}
