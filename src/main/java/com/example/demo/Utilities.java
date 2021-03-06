package com.example.demo;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;


@Service
public class Utilities {		
	/**
	 Extract element from pseudo array
	 */
	public List getListFromPseudoArray(String pseudoArray){
		List list = new ArrayList<String>();
		list = Arrays.asList(pseudoArray.split("_"));
		
		return list;		
	}
	
	
	public Date getDateFromString(String dateString){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date parsed = null;
		try {
			parsed = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date date = new Date(parsed.getTime());
		return date;
	}
	
	
	public Time getTimeFromString(String timeString){
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Time time = null;
		try {
			time = new Time(format.parse(timeString).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}
	
	
}
