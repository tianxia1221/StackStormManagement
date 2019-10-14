package com.websystique.springmvc.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
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
    	String pid = httpRequest.getParameter("pid");
    	if(pid!= null && !pid.isEmpty()) return executionService.getExecution(pid);
    	
    	String id = httpRequest.getParameter("id");
    	if(id!= null && !id.isEmpty()) return executionService.getInquiry(id);
    	
    	String inquires = httpRequest.getParameter("inquiries");

		//boolean isInquiries = Boolean.getBoolean(inquires);  
    	if(inquires!= null && !inquires.isEmpty()) {
	    	boolean isInquiries = Boolean.valueOf(inquires);   	
			if(isInquiries) return executionService.getInquiries();
    	}
	   	return executionService.getExecutions();
    } 
    
    @RequestMapping(value = "/execution/", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public String executionAction(@RequestBody String actionName, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception{
    	JSONObject obj = new JSONObject(actionName);
    	actionName = obj.getString("actionName");
    	return executionService.executionAction(actionName);
    } 
    
}
