package org.gj.java.utility.restfulservices.restfulclient.model;

import java.util.Map;

public class Response {
	
	private Map<String,String> headers;
	private Object body;
	
	public Map<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	
	

}
