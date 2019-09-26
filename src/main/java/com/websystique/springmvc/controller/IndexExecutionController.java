package com.websystique.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/execution")
public class IndexExecutionController {
	@RequestMapping(method = RequestMethod.GET)
    public String getExecutionPage() {
        return "ExecutionManagement";
    }


}