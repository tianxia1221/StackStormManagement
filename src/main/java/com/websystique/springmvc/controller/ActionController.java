package com.websystique.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.ActionService;
import com.websystique.springmvc.service.StackStormToken;
import com.websystique.springmvc.service.UserService;

@RestController
public class ActionController {
    @Autowired
    ActionService actionService;  
    
    @RequestMapping(value = "/action/", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public String listAllActions(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception{
    	String id = httpRequest.getParameter("id");
    	if(id!= null && !id.isEmpty()) return actionService.getAction(id);
	   	return actionService.getActions();
    } 
    
    @RequestMapping(value = "/action/{id}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAction(@PathVariable("id") String id) throws Exception{
	   	return actionService.getAction(id);
    } 
}
