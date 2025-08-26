package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ParallelAgent extends AgentDecorator{

	BlockingQueue<Message> queue;
	boolean close; //initialized to false in constructor 
	
	
	public ParallelAgent(Agent decoratedAgent, int capacity) {
		

		super(decoratedAgent);
		queue=new ArrayBlockingQueue<>(capacity);
		close=false;

		Thread takeThread=new Thread(()->{
			
			while(!close) {
					take(); //Blocks thread
			}
				
			
		});
		takeThread.start();		}
	
	public void take() {
		//conditionals:
		//return Message or wait or exception (->wait)
		try {
			Message msg=queue.take(); //Blocks thread
			decoratedAgent.callback(msg.getTopic(),msg);
		}
		catch(InterruptedException e) {}
	
	}
	
	public void put(Message msg) {
		
		try {
			queue.put(msg);
		}
		catch(InterruptedException e) {}
		
	}

	@Override
	public void callback(String topic, Message msg) {
		//need to return topic and message
		//so will define a Pair<String,Message>
		msg.setTopic(topic);
		try {
			queue.put(msg);
		}
		catch(InterruptedException e) {}

		
	}
	
	@Override
	public void close() {
		// close the thread
		close=true;
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return decoratedAgent.getName();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		decoratedAgent.reset();  
	}


}
