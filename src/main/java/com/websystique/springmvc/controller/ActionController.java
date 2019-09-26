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
import com.websystique.springmvc.service.StackStormHttpsURLConnection;
import com.websystique.springmvc.service.UserService;

@RestController
public class ActionController {
   
	
	 
//    @Autowired
//    UserService userService;  //Service which will do all data retrieval/manipulation work
// 
//    
//    //-------------------Retrieve All Users--------------------------------------------------------
//     
//    @RequestMapping(value = "/action/", method = RequestMethod.GET)
//    public ResponseEntity<List<User>> listAllUsers() {
//        List<User> users = userService.findAllUsers();
//        if(users.isEmpty()){
//            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//    }
	
    //-------------------Retrieve All Users--------------------------------------------------------
     
    @RequestMapping(value = "/action/", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
    public String listAllActions(){
	   	StackStormHttpsURLConnection conn = new StackStormHttpsURLConnection();
	   	String res = null;
	   	try {
			conn.init();
			res = conn.getWorkflows();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	return res;
    } 
}
