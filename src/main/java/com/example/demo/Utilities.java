package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

public class Utilities {
	
	/**
	 Extract element from pseudo array
	 */
	public List getList(String pseudoArray){
		List list = new ArrayList<String>();
		list = Arrays.asList(pseudoArray.split("_"));
		
		return list;		
	}
	
	/*
	public String setPseudoArray(List list){
		
		return list.tos
	}
	*/
	
	
	
}
