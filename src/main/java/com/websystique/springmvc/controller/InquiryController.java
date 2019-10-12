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
public class InquiryController {
    @Autowired
    ExecutionService executionService;  
    
    @RequestMapping(value = "/inquires/", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public String listAllActions(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception{
	   	return  executionService.getInquiries();
    } 

    
}