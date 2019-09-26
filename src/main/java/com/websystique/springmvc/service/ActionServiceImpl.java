package com.websystique.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.websystique.springmvc.model.User;

@Service("actionService")
public class ActionServiceImpl {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	public List<User> getActions() {
		return users;
	}

}
