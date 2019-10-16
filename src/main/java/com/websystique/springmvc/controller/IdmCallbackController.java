package com.websystique.springmvc.controller;
import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IdmCallbackController {
    
    @RequestMapping(value = "/idmcallback/", method = RequestMethod.GET,  produces = MediaType.TEXT_PLAIN_VALUE)
    public String getRole(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception{
		return "getRole";

    } 
    
    @RequestMapping(value = "/idmcallback/", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
    public String setRole(HttpServletRequest httpRequest, HttpServletResponse httpResponse) throws Exception{
        BufferedReader reader = httpRequest.getReader();
        String json = reader.readLine();
        System.out.println(json);
        reader.close();
        
        StringBuilder sb = new StringBuilder();
        sb.append("{\"status_code\":200,\"description\":\"create roles successfully\", \"intput parameters\":");
        sb.append(json);
        sb.append("} \r\n");
        return sb.toString();

    } 
    
}