package configs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.Agent;
import test.Topic;

import test.TopicManagerSingleton.TopicManager;




public class Graph extends ArrayList<Node> {

	
	//public Graph() { //Graph is a list of nodes, so must inherit a Nodes ArrayList
		//super();
	//}
	
	 public Graph(List<Node> nodes) {
	        super(nodes);
	    }
	
	 public boolean hasCycles() {
	        for (Node node : this) {
	            if (node.hasCycles()) {
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
	    	// Add topic node with "T" prefix
            String topicNodeName = "T" + topic.name;
            nodeMap.putIfAbsent(topicNodeName, new Node(topicNodeName));
	        
            // Add subscriber nodes with "A" prefix
	        for (Agent sub : topic.subs) {
	        	String subNodeName = "A" + sub.getName();
                nodeMap.putIfAbsent(subNodeName, new Node(subNodeName));
	        }
	        
	        // Add publisher nodes  
	        for (Agent pub : topic.pubs) {
	        	String pubNodeName = "A" + pub.getName();
                nodeMap.putIfAbsent(pubNodeName, new Node(pubNodeName));
	        }
	    }
	    
	    // Second pass: create edges
	    for (Topic topic : topics) {
	    	String topicNodeName = "T" + topic.name;
            Node topicNode = nodeMap.get(topicNodeName);
	        
	        // Topic -> Subscribers edges
	        for (Agent sub : topic.subs) {
	        	String subNodeName = "A" + sub.getName();
	        	Node subNode = nodeMap.get(subNodeName);
                topicNode.addEdge(subNode);
	        }
	        
	        // Publishers -> Topic edges  
	        for (Agent pub : topic.pubs) {
	        	String pubNodeName = "A" + pub.getName();
                Node pubNode = nodeMap.get(pubNodeName);
                pubNode.addEdge(topicNode);
	        }
	    }
	    
	 // Clear current graph and add all nodes
        this.clear();
        this.addAll(nodeMap.values());
	}
	
		
	}

	
