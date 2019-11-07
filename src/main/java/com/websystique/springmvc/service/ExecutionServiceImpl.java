package com.websystique.springmvc.service;

import java.net.URLEncoder;

import org.springframework.stereotype.Service;

@Service("executionService")
public class ExecutionServiceImpl implements ExecutionService {
	private final String URL = "https://stackstorm/api/v1/executions";
	private final String ATTRIBUTES = "?parent=null&limit=50&offset=0&include_attributes=id,status,start_timestamp,end_timestamp,action.ref,action.name,"
			+ "action.runner_type,action.parameters,parameters,rule.ref,trigger.type,context.user";
	private final String INQUIRIES = "?runner=inquirer&limit=50&offset=0";
	public String getExecutions() throws Exception {
		return ForwardGetRequest.process(URL + ATTRIBUTES);
	}
	
	public String getExecution(String id) throws Exception {
		
		String[] item = id.split(",");
		String URLs;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<item.length;i++) {
			sb.append("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			sb.append("  搜索词：" + item[i] );
            sb.append("  &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+ "\r\n");
            
			id = URLEncoder.encode(item[i], "UTF-8");			
			URLs = "https://list.tmall.com/search_product.htm?q=" + id; 
			sb.append(ForwardGetRequest.process(URLs));
		}
		return sb.toString();
	}
	
	public String executionAction(String actionName) throws Exception {
		//String bodyFormat = "{\"action\": \"%s\",\"parameters\": {\"user\": \"%s\"}}";
		String bodyFormat = "{\"action\": \"%s\"}";
		String body = String.format(bodyFormat, actionName, "FanBingbing");
		return ForwardPostRequest.process(URL, body);
	}
	
	public String getInquiries() throws Exception {
		return ForwardGetRequest.process(URL + INQUIRIES);
	}
	
	public String getInquiry(String id) throws Exception {
		return ForwardGetRequest.process(URL + "/" + id );
	}

}
