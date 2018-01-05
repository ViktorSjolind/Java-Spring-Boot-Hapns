package com.example.demo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private String datestring;	
	private Date date;  
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
	
	
	
	public String getDatestring(){
		return datestring;
	}
	
	public void setDatestring(String datestring){
		this.datestring = datestring;
	}
	
	
	
	
	public Date getDate(){
		return date;
	}
	
	public void setDate(Date date){
		this.date = date;
	}
	
	public int getGoing(){
		return going;
	}
	
	public void setGoing(int going){
		this.going = going;
	}
	
}