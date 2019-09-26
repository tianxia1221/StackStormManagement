package com.websystique.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/action")
public class IndexActionController {

	  @RequestMapping(method = RequestMethod.GET)
	    public String getActionPage() {
	        return "ActionManagement";
	    }


}