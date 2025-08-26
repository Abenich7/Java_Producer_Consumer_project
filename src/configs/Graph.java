package configs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.Agent;
import test.Topic;

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
		
		
		// First pass: create all nodes
		Map<String,Node> nodeMap = new HashMap<>();
		
	    for (Topic topic : topics) {
	        // Add topic node if not exists
	        nodeMap.putIfAbsent(topic.name, new Node(topic.name));
	        
	        // Add subscriber nodes
	        for (Agent sub : topic.subs) {
	            nodeMap.putIfAbsent(sub.getName(), new Node(sub.getName()));
	        }
	        
	        // Add publisher nodes  
	        for (Agent pub : topic.pubs) {
	            nodeMap.putIfAbsent(pub.getName(), new Node(pub.getName()));
	        }
	    }
	    
	    // Second pass: create edges
	    for (Topic topic : topics) {
	        Node topicNode = nodeMap.get(topic.name);
	        
	        // Topic -> Subscribers edges
	        for (Agent sub : topic.subs) {
	            topicNode.edges.add(nodeMap.get(sub.getName()));
	        }
	        
	        // Publishers -> Topic edges  
	        for (Agent pub : topic.pubs) {
	            Node pubNode = nodeMap.get(pub.getName());
	            pubNode.edges.add(topicNode);
	        }
	    }
	    
	    // Update the graph's node list
	    this.nodes = new ArrayList<>(nodeMap.values());
	}
	
		
	}

	
