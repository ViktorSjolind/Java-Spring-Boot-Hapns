package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Long>{
	
	List<Post> findByUser(String user);
	
	/*
	@Query(value="SELECT * FROM hapns.post ORDER BY date DESC", nativeQuery = true)
	List<Post> findAllByDate();
	*/
				
	List<Post> findAllByOrderByDateDesc();
	
	
}