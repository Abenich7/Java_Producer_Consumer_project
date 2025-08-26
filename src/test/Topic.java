package test;

import java.util.ArrayList;
import java.util.List;


public class Topic{

	public final String name;
	public List<Agent> subs;
	public List<Agent> pubs;
	

	public Topic(String name) {
		this.name=name;
		subs=new ArrayList<>();
		pubs=new ArrayList<>();
	}
	
	public void subscribe(Agent sub) {
		this.subs.add(sub);		
	}
	
	public void unsubscribe(Agent pub) {
		this.subs.remove(pub);
	}
	
	public void publish(Message msg) {
 
		int i;
		for(i=0;i<subs.size();i++) {
			this.subs.get(i).callback(name, msg);
		}
	}
		
	public void addPublisher(Agent pub) {
		this.pubs.add(pub);
	}
	
	public void removePublisher(Agent pub) {
		this.pubs.remove(pub);
	}
	


}
