package com.websystique.springmvc.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("inquiryService")
public class InquiryServiceImpl implements InquiryService {
	private final String URL = "https://stackstorm/api/v1/inquiries";
	public String response(String body) throws Exception {
    	JSONObject obj = new JSONObject(body);
    	String id = obj.getString("id");
		return ForwardPutRequest.process(URL+ "/" + id, body);
	}
	
	public String getInquiry(String id) throws Exception {
    	return ForwardGetRequest.process(URL + "/" + id);
	}
}
