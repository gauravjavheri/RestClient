package org.gj.java.utility.restfulservices.restfulclient.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.gj.java.utility.restfulservices.restfulclient.model.Request;
import org.gj.java.utility.restfulservices.restfulclient.model.Response;
import org.gj.java.utility.restfulservices.restfulclient.tasks.RequestTask;

public class RestClientManager {
	
	public int numberOfThreads=10;
	private ExecutorService executorService;
	
	public RestClientManager(int numberOfThreads){
		this.numberOfThreads=numberOfThreads;
		executorService=Executors.newFixedThreadPool(numberOfThreads);
	}
			
	public int getNumberOfThreads() {
		return numberOfThreads;
	}

	public void setNumberOfThreads(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
	}

	public Response getData(Request request) throws InterruptedException, ExecutionException{
		Future<Response> threadOutput=executorService.submit(getRequestTask(request));
	    return threadOutput.get();			
	}
	
	public List<Response> getData(List<Request> requests) throws InterruptedException, ExecutionException{
		List<Future<Response>> threadOutputs=executorService.invokeAll(getRequestTask(requests));
	/*	for(RequestTask requestTask:getRequestTask(requests)){
			Future<Object> result=executorService.submit(requestTask);
			threadOutputs.add(result);
		} */	
		System.out.println("size of requests "+threadOutputs.size());
		return extractResponse(threadOutputs);		
	}
	
   public void close(){
	   executorService.shutdown();
   }
   
   private List<Response> extractResponse(List<Future<Response>> threadOutputs) throws InterruptedException, ExecutionException{
	   List<Response> finalResponseList=new ArrayList<Response>();
	   for(Future<Response> threadOutput:threadOutputs){
		   finalResponseList.add(threadOutput.get());
	   }
	   return finalResponseList;
   }
   
   
   private RequestTask getRequestTask(Request request){
	   RequestTask requestTask=new RequestTask();
	   requestTask.setRequest(request);
	   return requestTask;
   }
   
   private List<RequestTask> getRequestTask(List<Request> requests){
	   List<RequestTask> requestTasks=new ArrayList<RequestTask>();
	   int index=0;
	   Request request=null;
	   for(;index<requests.size();index++){
		   request=requests.get(index);
		   RequestTask requestTask=new RequestTask();
		   requestTask.setRequest(request);
		   requestTasks.add(requestTask);
	   }
	   return requestTasks;
   }
   
}
