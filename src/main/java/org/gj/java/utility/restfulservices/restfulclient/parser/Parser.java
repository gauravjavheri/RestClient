package org.gj.java.utility.restfulservices.restfulclient.parser;

public interface Parser {
	
	public String serialize(Object object) throws Exception;
	public Object deserialize(String object,Class type) throws Exception;

}
