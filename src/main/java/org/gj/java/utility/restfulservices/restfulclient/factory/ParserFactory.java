package org.gj.java.utility.restfulservices.restfulclient.factory;

import java.util.Map;

import org.gj.java.utility.restfulservices.restfulclient.common.Constant;
import org.gj.java.utility.restfulservices.restfulclient.parser.JsonParser;
import org.gj.java.utility.restfulservices.restfulclient.parser.Parser;
import org.gj.java.utility.restfulservices.restfulclient.parser.XmlParser;

public class ParserFactory {
	
	private static JsonParser jsonParser=new JsonParser();
	private static XmlParser xmlParser=new XmlParser();
	
	public static Parser getParser(String type){
		switch(type){
			case Constant.MEDIATYPE_JSON:return jsonParser;
			case Constant.MEDIATYPE_XML:return xmlParser;
		    default: return jsonParser;
		}
	}

}
