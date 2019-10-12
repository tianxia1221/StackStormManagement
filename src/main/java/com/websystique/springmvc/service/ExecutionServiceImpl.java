package com.websystique.springmvc.service;

import org.springframework.stereotype.Service;

@Service("executionService")
public class ExecutionServiceImpl implements ExecutionService {
	private final String URL = "https://stackstorm/api/v1/executions";
	private final String ATTRIBUTES = "?parent=null&limit=50&offset=0&include_attributes=id,status,start_timestamp,end_timestamp,action.ref,action.name,"
			+ "action.runner_type,action.parameters,parameters,rule.ref,trigger.type,context.user";

	public String getExecutions() throws Exception {
		return ForwardGetRequest.process(URL + ATTRIBUTES);
	}
	
	public String getExecution(String id) throws Exception {
		return ForwardGetRequest.process(URL + "?id=" + id);
	}
}
