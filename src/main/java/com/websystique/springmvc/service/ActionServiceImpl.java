package com.websystique.springmvc.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.websystique.springmvc.model.User;

@Service("actionService")
public class ActionServiceImpl  implements ActionService{
	
	
	private final String URL = "https://stackstorm/api/v1/actions";
	private final String ATTRIBUTES = "?include_attributes=id,ref,pack,name,description,runner_type&pack=examples";
	
	public String getActions() throws Exception {
		return ForwardGetRequest.process(URL + ATTRIBUTES);
	}
	
	public String getAction(String id) throws Exception {
		return ForwardGetRequest.process(URL + "?id=" + id);
	}
}
