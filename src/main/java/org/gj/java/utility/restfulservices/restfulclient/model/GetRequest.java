package org.gj.java.utility.restfulservices.restfulclient.model;

import java.util.Map;

import org.gj.java.utility.restfulservices.restfulclient.common.Constant;

public class GetRequest extends Request {
	
	public GetRequest(String resourceUrl,Map<String,String>headers,Class responseClass){
		super( resourceUrl,Constant.GET_METHOD,headers,null,responseClass);	    			
	}

}
