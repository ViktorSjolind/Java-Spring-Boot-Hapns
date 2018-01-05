package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Post {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;	
	private String user;
	private String text;
	/*
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime dateTime;
	*/
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private LocalTime time;
	    
	    
	private int going = 0;
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	
	public String getUser(){
		return user;
	}
	
	public void setUser(String user){
		this.user = user;
	}
	
	
	public String getText(){
		return text;
	}
	
	public void setText(String text){
		this.text = text;
	}
	
	/*
	public LocalDateTime getDateTime(){
		return dateTime;
	}
	
	public void setDateTime(LocalDateTime dateTime){
		this.dateTime = dateTime;
	}*/
	
	
	public LocalTime getTime(){
		return time;
	}
	
	public void setTime(LocalTime time){
		this.time = time;
	}
	
	
	public LocalDate getDate(){
		return date;
	}
	
	public void setDate(LocalDate date){
		this.date = date;
	}
	
	
	public int getGoing(){
		return going;
	}
	
	public void setGoing(int going){
		this.going = going;
	}
	
}