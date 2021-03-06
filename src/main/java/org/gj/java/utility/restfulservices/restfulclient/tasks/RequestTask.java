package org.gj.java.utility.restfulservices.restfulclient.tasks;

import java.util.concurrent.Callable;

import org.gj.java.utility.restfulservices.restfulclient.factory.HttpClientFactory;
import org.gj.java.utility.restfulservices.restfulclient.httpclient.HttpClient;
import org.gj.java.utility.restfulservices.restfulclient.model.Request;
import org.gj.java.utility.restfulservices.restfulclient.model.Response;

public class RequestTask implements Callable<Response>{
	
	Request request;
		
	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Response call() throws Exception {
		HttpClient httpClient=HttpClientFactory.getHttpClient(request.getHttpMethod());		
		return httpClient.execute(request);
	}

}
