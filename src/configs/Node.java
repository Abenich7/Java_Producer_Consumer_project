package configs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import test.Message;

public class Node {

	public String name;
	public List<Node> edges=new ArrayList<>();
	public Message message;
	
	public Node(String name) {
		this.name=name;
	}
	
	public void addEdge(Node node) {
		this.edges.add(node);
	}
	

    public boolean hasCycles() {
        // Use DFS with recursion stack to detect cycles
        Set<Node> visited = new HashSet<>();
        Set<Node> recursionStack = new HashSet<>();
        
        return dfsHasCycle(this, visited, recursionStack);
    }
    
    private boolean dfsHasCycle(Node node, Set<Node> visited, Set<Node> recursionStack) {
        // Add current node to visited and recursion stack
        visited.add(node);
        recursionStack.add(node);
        
        // Visit all adjacent nodes (edges)
        for (Node neighbor : node.edges) {
            if (!visited.contains(neighbor)) {
                // If neighbor not visited, recursively check
                if (dfsHasCycle(neighbor, visited, recursionStack)) {
                    return true;
                }
            } else if (recursionStack.contains(neighbor)) {
                // If neighbor is in recursion stack, cycle found
                return true;
            }
        }
        
        // Remove from recursion stack when done processing
        recursionStack.remove(node);
        return false;
    }
	
	public String getName() {
		return name;
		
	}
	
	public List<Node> getEdges(){
		return edges;
	}
	
	public Message getMessage() {
		return message;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setEdges(List<Node> edges) {
		this.edges=edges;
	}
	
	public void setMessage(Message message) {
		this.message=message;
	}
	
	public static void main(String[] args) {
		//create a graph with a cycle 
		Node v1=new Node("v1");
		Node v2=new Node("v2");
		Node v3=new Node("v3");
		Node v4=new Node("v4");
		Node v5=new Node("v5");
		Node v6=new Node("v6");
		
		v1.edges.add(v6);
		v1.edges.add(v3);
		
		v6.edges.add(v2);
		
		v1.edges.add(v2);
		
		v1.edges.add(v5);
		v5.edges.add(v4);
		v4.edges.add(v3);
		
		//v2.edges.add(v1);
		
		boolean v1HasCycle=v1.hasCycles();
		
		System.out.println("v1 has cycles:"+v1HasCycle);
		
	}


}
