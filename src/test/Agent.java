package test;

// <<Agent>> 
// reset() - unsubscribe, clear messages from all topics
// close() - close agent window 
// callback() - display message from a certain topic 


public interface Agent {
	String getName(); 
    void reset(); 
    void callback(String topic, Message msg); 
    void close(); 	
}
