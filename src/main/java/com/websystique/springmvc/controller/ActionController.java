package com.websystique.springmvc.controller;

import java.util.List;

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
    public String listAllActions() throws Exception{
	   	return actionService.getActions();
    } 
    
    @RequestMapping(value = "/action/{id}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAction(@PathVariable("id") String id) throws Exception{
	   	return actionService.getAction(id);
    } 
}
