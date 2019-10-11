package com.websystique.springmvc.controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.websystique.springmvc.service.StackStormToken;
@RestController
public class ExecutionController {
    @RequestMapping(value = "/execution/", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public String listAllExecutions(){
//	   	StackStormToken conn = StackStormToken.getInstance();
//	   	String res = null;
//	   	try {
//			conn.init();
//			res = conn.getExecutions();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	   	return res;
    	return null;
    } 
}
