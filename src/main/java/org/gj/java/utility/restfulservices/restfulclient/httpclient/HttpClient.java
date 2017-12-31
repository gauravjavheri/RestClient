package org.gj.java.utility.restfulservices.restfulclient.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.gj.java.utility.restfulservices.restfulclient.factory.ParserFactory;
import org.gj.java.utility.restfulservices.restfulclient.model.Request;
import org.gj.java.utility.restfulservices.restfulclient.parser.Parser;

public abstract class HttpClient  {
	public abstract Object execute(Request request) throws Exception; 
	
	protected Parser getParser(String type){
		return ParserFactory.getParser(type);
	}
	
	protected String getResponseBody(CloseableHttpResponse httpResponse) throws IllegalStateException, IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpResponse.getEntity().getContent()));
		String temp;
		StringBuffer responseBody = new StringBuffer();
		while ((temp = reader.readLine()) != null) {
			responseBody.append(temp);
		}
		reader.close();
		httpResponse.close();
		return responseBody.toString();
	}
}
