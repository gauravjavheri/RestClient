package org.gj.java.utility.restfulservices.restfulclient.factory;

import org.gj.java.utility.restfulservices.restfulclient.common.Constant;
import org.gj.java.utility.restfulservices.restfulclient.httpclient.HttpClient;
import org.gj.java.utility.restfulservices.restfulclient.httpclient.HttpGetClient;
import org.gj.java.utility.restfulservices.restfulclient.httpclient.HttpPostClient;

public class HttpClientFactory {
	
	private static HttpGetClient httpGetClient=new HttpGetClient();
	private static HttpPostClient httppostClient=new HttpPostClient();
	
	public static HttpClient getHttpClient(String type){
		switch(type){
			case Constant.GET_METHOD:return httpGetClient;
			case Constant.POST_METHOD:return httppostClient;
			default: return httpGetClient;
		}
	}

}
