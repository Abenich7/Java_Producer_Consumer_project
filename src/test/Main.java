package test;

import java.util.ArrayList;
import java.util.List;

import test.TopicManagerSingleton.TopicManager;

public class Main {

	public static void main(String[] args) {
		TopicManager topicManager=TopicManagerSingleton.get();
		
		topicManager.getTopic("History");
		
		List<Topic> topicManagerList=new ArrayList<>();
		
		topicManagerList=topicManager.getTopics();
		
		//System.out.println("Text: "+topicManagerList.toString());
		
		
		//creating an agent 
		
		Agent arielParallel=new ParallelAgent(new BasicAgent("Ariel"), 10);
		
		Topic math=new Topic("Math");
		
		Message hello=new Message("Welcome to Math thread");
		
		math.subscribe(arielParallel);
		
		math.publish(hello);
		
		// case test: multiple agents posting to multiple threads, and reading from multiple threads 
		
		//create multiple topics
		Topic t1=new Topic("T1");
		Topic t2=new Topic("T2");
		Topic t3=new Topic("T3");
		Topic t4=new Topic("T4");
		Topic t5=new Topic("T5");
		
	
		// create multiple agents 
		
		Agent a1 =new ParallelAgent(new BasicAgent("A1"),10);
		Agent a2 =new ParallelAgent(new BasicAgent("A2"),10);
		Agent a3 =new ParallelAgent(new BasicAgent("A3"),10);
		Agent a4 =new ParallelAgent(new BasicAgent("A4"),10);
		Agent a5 =new ParallelAgent(new BasicAgent("A5"),10);
		Agent a6 =new ParallelAgent(new BasicAgent("A6"),10);
		Agent a7 =new ParallelAgent(new BasicAgent("A7"),10);
		Agent a8 =new ParallelAgent(new BasicAgent("A8"),10);
		Agent a9 =new ParallelAgent(new BasicAgent("A9"),10);
		Agent a10 =new ParallelAgent(new BasicAgent("A10"),10);
		
		
		// create multiple subscribers 
		t1.subscribe(a10);
		t1.subscribe(a5);
		t1.subscribe(a6);
		t1.subscribe(a3);
		t2.subscribe(a3);
		t2.subscribe(a6);
		t3.subscribe(a9);
		t3.subscribe(a2);
		t3.subscribe(a1);
		t3.subscribe(a8);
		t3.subscribe(a7);
		t4.subscribe(a6);
		t4.subscribe(a4);
		t4.subscribe(a1);
		t4.subscribe(a7);
		t4.subscribe(a8);
		t4.subscribe(a3);
		t4.subscribe(a5);
		t4.subscribe(a2);
		t5.subscribe(a7);
		t5.subscribe(a3);
		t5.subscribe(a5);
		t5.subscribe(a9);
		t5.subscribe(a10);
		
		
		// create multiple messages
		t1.publish(new Message("Hello"));
		t2.publish(new Message("Hello"));
		t3.publish(new Message("Hello"));
		t4.publish(new Message("Hello"));
		t5.publish(new Message("Hello"));
		
		t1.publish(new Message("Welcome"));
		t2.publish(new Message("Welcome"));
		t3.publish(new Message("Welcome"));
		t4.publish(new Message("Welcome"));
		t5.publish(new Message("Welcome"));
		
		t1.publish(new Message("topic t1"));
		t2.publish(new Message("topic t2"));
		t3.publish(new Message("topic t3"));
		t4.publish(new Message("topic t4"));
		t5.publish(new Message("topic t5"));
		
		
		t1.publish(new Message("subscribe"));
		t2.publish(new Message("subscribe"));
		t3.publish(new Message("subscribe"));
		t4.publish(new Message("subscribe"));
		t5.publish(new Message("subscribe"));
		
		
	
		

		
		
		
		
		
		
	}
	
	

}
