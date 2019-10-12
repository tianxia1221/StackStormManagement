package com.websystique.springmvc.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.websystique.springmvc.service.ExecutionService;

@RestController
public class ExecutionController {
    @Autowired
	ExecutionService executionService;  
    
    @RequestMapping(value = "/execution/", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
        public String listAllActions(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception{
    	String id = httpRequest.getParameter("id");
    	if(id!= null && !id.isEmpty()) return executionService.getExecution(id);
	   	return executionService.getExecutions();
    } 
}
