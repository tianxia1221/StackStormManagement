package com.websystique.springmvc.service;

public interface ActionService {
	public String getActions() throws Exception;
	public String getAction(String id) throws Exception;
	public String getActionEntryPoints(String id) throws Exception;
}
