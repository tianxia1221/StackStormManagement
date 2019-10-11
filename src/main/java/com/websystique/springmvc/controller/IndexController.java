package com.websystique.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class IndexController {

	  @RequestMapping(method = RequestMethod.GET)
	    public String getIndexPage() {
	        return "Home";
	    }
	  
//	  @RequestMapping(value = "/action1/", method = RequestMethod.GET)
//	    public String getActionPage() {
//	        return "ActionManagement";
//	    }
//	  
//	  @RequestMapping(value = "/execution/", method = RequestMethod.GET)
//	    public String getExecutionPage() {
//	        return "ExecutionManagement";
//	    }

}