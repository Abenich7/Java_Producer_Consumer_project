package configs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import test.Agent;
import test.Topic;
import test.TopicManagerSingleton;
import test.TopicManagerSingleton.TopicManager;




public class Graph {

	List<Node> nodes=new ArrayList<>();	
	
	public Graph(List<Node> nodes) { //Graph is a list of nodes, so must inherit a Nodes ArrayList
		
		// Graph must
		this.nodes=nodes;
	}
	
	public boolean hasCycles() {
		for(Node node : nodes) {
			if(node.hasCycles()==true) {
				return true;
			}
		}
		return false;
	}
	
	public void createFromTopics(TopicManager tm) { //TopicManager contains hashmap of topics (topicName mapped to topic)
	
		//Graph is initialized based on fields in TopicManager
		
		List<Topic> topics=tm.getTopics();
		
		//iterate over list of nodes in the graph
		Iterator<Node> iterator=nodes.iterator();
		
		//add a new node for each topic
		for(Topic topic: topics) {
			if(!nodes.contains(topic.name)) { //check if topic wasn't added in Agent pub loop
				//add node to graph
				nodes.add(new Node(topic.name));
			}
			
			//iterate to topic that was just added 
			Node curNode=iterator.next();
			
			//add subscribers to current topic as nodes to graph, and add them as edges to that Nodes edges list
			for (Agent sub: topic.subs) {
				if(!nodes.contains(sub.getName()))  //check that subscriber wasnt added in Agent pub
					//add node to graph
					nodes.add(new Node(sub.getName()));
				//add sub to edges list for that topic (outgoing edges in graph)
				curNode.edges.add(new Node(sub.getName()));
				
				//iterate to next node in list 
				iterator.next();
				
			}
			
			for(Agent pub: topic.pubs) {
				if(!nodes.contains(pub.getName()))
					nodes.add(new Node(pub.getName()));
				
					//iterate to pub node to add edges to it 
					curNode=iterator.next();
					curNode.edges.add(new Node(topic.name));
				
				
			}
		}
	}
		
	}

	
