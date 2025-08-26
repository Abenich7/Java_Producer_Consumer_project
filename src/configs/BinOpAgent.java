package configs;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import test.Agent;
import test.AgentDecorator;
import test.BasicAgent;
import test.Message;
import test.ParallelAgent;
import test.Topic;

public class BinOpAgent extends AgentDecorator  {
	

	
	public Topic T1;
	public Topic T2;
	public Topic T0;
	
	public Double inputT1;
	public Double inputT2;
	public Double outputT0;
	
	public boolean isInitializedT1=false;
	public boolean isInitializedT2=false;
	
	public BinaryOperator<Double> operator;
	private String agentName;
	
	public BinOpAgent(String agent,String firstTopic,String secondTopic, String outputTopic, BinaryOperator<Double> operator) {
		
		super(new BasicAgent(agent));
		
		
		this.T1=new Topic(firstTopic);
		this.T2=new Topic(secondTopic);
		
		this.T0=new Topic(outputTopic);
		
		this.operator=operator;
		
		
		T1.subscribe(this);
		T2.subscribe(this);
		
		T0.addPublisher(this);
		
		
	//	Message m1=new Message(1);
	//	Message m2=new Message(3);
		
		
		
	//	T1.publish(m1);
	//	T2.publish(m2);
		
		
		
	}
	
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.agentName;
	}

	@Override
	public void reset() {
		// Reset inputs to 0 and flags to false
        this.inputT1 = 0.0;
        this.inputT2 = 0.0;
        this.isInitializedT1 = false;
        this.isInitializedT2 = false;
	}

	@Override
	public void callback(String topic, Message msg) {
		// TODO Auto-generated method stub
		
		if (topic.equals(T1.name)) {
			this.inputT1=msg.asDouble;
			this.isInitializedT1=true;
		}
		else if (topic.equals(T2.name)) {
			this.inputT2=msg.asDouble;
			this.isInitializedT2=true;
		}
		
	//	Double result=(double) 0;
		
		if(this.isInitializedT1 && this.isInitializedT2) {
			Double result=this.operator.apply(inputT1, inputT2);
			System.out.println("Agent "+agentName + "result:"+result);
			
			T0.publish(new Message(result));
		}
		
			
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		
		BinOpAgent adder=new BinOpAgent("add","T1","T2","T0",(a,b)->a-b);
		
		
		
	}
	
	



}
