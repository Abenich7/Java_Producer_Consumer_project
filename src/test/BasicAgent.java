package test;



public class BasicAgent implements Agent {	
	
	public String name;
	//public List<Topic> topics;
	
	
	
	public BasicAgent(String name) {
		this.name=name;	
		
	}

	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
		
	}

	@Override
	public void reset() {
		//// TODO Auto-generated method stub
		//this.topics.removeAll(topics);
	}

	@Override
	public void callback(String topic, Message msg) {
		// TODO Auto-generated method stub
		//does the agent need to identify whether the message
		//came from a topic he subscribed to?
		//int i;
		//for(i=0;i<=topics.size()-1;i++)
			//if(topic==topics.get(i).name) {
				//System.out.println("Topic: "+topic+",Message: "+msg);
			//}

		System.out.println("Message: "+msg.asText);
		
		
		//activate binary operation 
		
	}

	@Override
	public void close() {}


	
	
}

 