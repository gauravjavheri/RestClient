# RestfulClient 
It is java library developed on top of Apache HTTP library and JDK executor framework. It has capability to execute multiple restful requests concurrently in very easy way. 

## Features

1. Supports HTTP GET and POST methods.
2. Concurrent execution of multiple requests.
3. Auto conversion request and response to JSON and XML formats.
4. Easy Request creation.

## Features in progress

1. Download executions
2. Support for HTTP PUT,DELETE, OPTIONS methods.


## How to use 

### Add Library Jar to classpath

Add target/restfulclient-1.0.0.jar to classpath of project.



### Create RestClientManager Object

Import package as shown

```java

import org.gj.java.utility.restfulservices.restfulclient.main.RestClientManager;

```

Initialize Object of RestClientManager with number of working concurrent threads. Below code will initialize restfulclient with three concurrent working threads which can accepts requests for executions.


```java

	RestClientManager restClient=new RestClientManager(3);

```

### Create Request 

Depending upon Content_type header value, library converts request java object to either json or xml.
Likewise upon Accept header value, library build response object either from json or xml response.

#### GET  

```java
    
	Map<String,String> headers=new HashMap<>();
	String requestUrl="http://localhost:8080/getTestPage";
	headers.put(Constant.CONTENT_TYPE, Constant.MEDIATYPE_JSON);
	headers.put(Constant.ACCEPT, Constant.MEDIATYPE_JSON);
	responseClass=Response.class;
	Request request=new GetRequest(requestUrl,headers, responseClass);

```

#### POST 

```java
      
	Map<String,String> headers=new HashMap<>();
	String requestUrl="http://localhost:8080/getTestPage";
	headers.put(Constant.CONTENT_TYPE, Constant.MEDIATYPE_JSON);
	headers.put(Constant.ACCEPT, Constant.MEDIATYPE_JSON);
	responseClass=Response.class;
	requestBody=new RequestBody();
	Request request=new PostRequest(requestUrl, headers, requestBody, responseClass);

```

### Make Request and Collect Response

```java

	Response response=(Response)restClient.getData(request);

```

### Make multiple concurrent requests

```java

	//  First request	with JSON format  
	requestUrl="http://localhost:8080/getPerson1";
	headers.put(Constant.CONTENT_TYPE, Constant.MEDIATYPE_JSON);
	headers.put(Constant.ACCEPT, Constant.MEDIATYPE_JSON);
	responseClass=Response1.class;
	requestBody=new RequestBody1();
	((RequestBody1)requestBody).setName("postDummyName1");
	Request request1=new PostRequest(requestUrl,headers, requestBody, responseClass);
	  
	// Second request with XML formats
	requestUrl="http://localhost:8080/getPerson2";
	headers.put(Constant.CONTENT_TYPE, Constant.MEDIATYPE_XML);
	headers.put(Constant.ACCEPT, Constant.MEDIATYPE_XML);
	responseClass=Response2.class;
	Request request2=new GetRequest(requestUrl,headers, responseClass);
	  
	// Third request with JSON format
	requestUrl="http://localhost:8080/getPerson3";
	headers.put(Constant.CONTENT_TYPE, Constant.MEDIATYPE_JSON);
	headers.put(Constant.ACCEPT, Constant.MEDIATYPE_JSON);
	responseClass=Response3.class;
	requestBody=new RequestBody3();
	((RequestBody3)requestBody).setName("postDummyName3");
	Request request3=new PostRequest(requestUrl, headers, requestBody, responseClass);
	  
	List<Request> requests=new ArrayList<Request>();
	requests.add(request1);
	requests.add(request2);
	requests.add(request3);
	  
	List<Object> responses=(List<Object>)restClient.getData(requests);
	
```
