package com.websystique.springmvc.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.websystique.springmvc.service.ExecutionService;
import com.websystique.springmvc.service.InquiryService;


@RestController
public class InquiryController {
    @Autowired
    InquiryService inquiryService;  
    @Autowired
	ExecutionService executionService;  
    
    @RequestMapping(value = "/inquiries/", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public String listAllInquiris(@PathVariable String id, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception{
	   	if(id != null && !id.isEmpty()) inquiryService.getInquiry(id);
    	return  executionService.getInquiries();
    } 
    
    @RequestMapping(value = "/inquiries/{id}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public String getInquiry(@PathVariable String id, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception{
	   	if(id != null && !id.isEmpty()) inquiryService.getInquiry(id);
    	return  executionService.getInquiries();
    } 

    @RequestMapping(value = "/inquiries/", method = RequestMethod.PUT,  produces = MediaType.APPLICATION_JSON_VALUE)
    public String response(@RequestBody String requestBody, HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception{
	   	return  inquiryService.response(requestBody);
    } 
}
