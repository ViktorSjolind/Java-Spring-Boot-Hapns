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
	
	List<Post> findAllByOrderByDateDescTimeDesc();
	
	@Query(value="SELECT *, DATE_FORMAT(post.date, '%Y-%m-%d') FROM hapns.post WHERE DATE(post.date) = CURDATE() ORDER BY date DESC, time DESC;", nativeQuery = true)
	List<Post> findAllToday();
	
	@Query(value="SELECT * FROM hapns.post WHERE WEEKOFYEAR(date)=WEEKOFYEAR(NOW()) AND YEAR(date) = YEAR(now()) ORDER BY date DESC, time DESC", nativeQuery = true)
	List<Post> findAllThisWeek();
	
}