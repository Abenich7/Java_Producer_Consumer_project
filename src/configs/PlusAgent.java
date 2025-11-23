package configs;

import test.Agent;
import test.AgentDecorator;
import test.BasicAgent;
import test.Message;

public class PlusAgent extends AgentDecorator{

	public PlusAgent(Agent decoratedAgent) {
		super(new BasicAgent("Aplus"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void callback(String topic, Message msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
