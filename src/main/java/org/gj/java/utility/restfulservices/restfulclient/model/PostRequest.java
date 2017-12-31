package org.gj.java.utility.restfulservices.restfulclient.model;

import java.util.Map;

import org.gj.java.utility.restfulservices.restfulclient.common.Constant;

public class PostRequest extends Request {
	public PostRequest(String resourceUrl,Map<String,String>headers,Object requestBody,Class responseClass){
		super( resourceUrl,Constant.POST_METHOD,headers,requestBody,responseClass);	    			
	}

}
