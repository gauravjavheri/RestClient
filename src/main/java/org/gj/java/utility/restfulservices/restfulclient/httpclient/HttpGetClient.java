package org.gj.java.utility.restfulservices.restfulclient.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.gj.java.utility.restfulservices.restfulclient.common.Constant;
import org.gj.java.utility.restfulservices.restfulclient.factory.ParserFactory;
import org.gj.java.utility.restfulservices.restfulclient.model.Request;
import org.gj.java.utility.restfulservices.restfulclient.model.Response;
import org.gj.java.utility.restfulservices.restfulclient.parser.Parser;

public class HttpGetClient extends HttpClient{

	@Override
	public Response execute(Request request) throws Exception {
		Response response=new Response();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(request.getResource_uri());
		Map<String,String>header=request.getHeaders();
		for(String key:header.keySet()){
			httpGet.addHeader(key, header.get(key));
		}
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        Parser parser=getParser(request.getHeaders().get(Constant.ACCEPT));    
        response.setHeaders(getResponseHeader(httpResponse));
        response.setBody(parser.deserialize(getResponseBody(httpResponse), request.getResponseClass()));
        httpClient.close();
		return response;
	}

}
