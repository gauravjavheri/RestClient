package org.gj.java.utility.restfulservices.restfulclient.httpclient;

import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.gj.java.utility.restfulservices.restfulclient.common.Constant;
import org.gj.java.utility.restfulservices.restfulclient.model.Request;
import org.gj.java.utility.restfulservices.restfulclient.model.Response;
import org.gj.java.utility.restfulservices.restfulclient.parser.Parser;

public class HttpPostClient extends HttpClient{

	@Override
	public Response execute(Request request) throws Exception {
		Response response=new Response();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost  httpPost = new HttpPost (request.getResource_uri());
		Map<String,String>header=request.getHeaders();
		for(String key:header.keySet()){
			httpPost.addHeader(key, header.get(key));
		}
		if(request.getBody()!=null){
			Parser requestParser=getParser(request.getHeaders().get(Constant.CONTENT_TYPE));
			String requestBody = requestParser.serialize(request.getBody());
	        HttpEntity entity = new ByteArrayEntity(requestBody.getBytes("UTF-8"));
	        httpPost.setEntity(entity);
			
		}
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
        Parser responseParser=getParser(request.getHeaders().get(Constant.ACCEPT));        
        response.setHeaders(getResponseHeader(httpResponse));
        response.setBody(responseParser.deserialize(getResponseBody(httpResponse), request.getResponseClass()));
		return response;

	}
}
