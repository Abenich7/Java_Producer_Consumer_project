package test;



//decorator of Agent
public abstract class AgentDecorator implements Agent{

	
	Agent decoratedAgent;
	//BlockingQueue<Message> queue;
	//boolean close; //initialized to false in constructor 
	
	
	public AgentDecorator(Agent decoratedAgent) {
		//initialize queue
		this.decoratedAgent=decoratedAgent;
	}
	
	
	
	

}
