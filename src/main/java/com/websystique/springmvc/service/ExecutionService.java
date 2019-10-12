package com.websystique.springmvc.service;

public interface ExecutionService {
	public String getExecutions() throws Exception;
	public String getExecution(String id) throws Exception;
	public String executionAction(String actionName) throws Exception;
	public String getInquiries() throws Exception;
}
