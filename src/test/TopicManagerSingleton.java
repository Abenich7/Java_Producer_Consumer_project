package test;


import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.List;


public class TopicManagerSingleton {

	
    public TopicManagerSingleton() {}
	
	public static TopicManager get() {
		
		return TopicManager.instance;
	}
	
	public static class TopicManager {
		
		
		private static final TopicManager instance = new TopicManager();
		
		private ConcurrentHashMap<String,Topic> map=new ConcurrentHashMap<>();
		
		
		private TopicManager() {}
		
		public Topic getTopic(String topicName) {
			//TODO consider thread safety
			
			
			if(map.containsKey(topicName))
				return map.get(topicName);
			else {
				Topic t=new Topic(topicName);
				map.put(topicName, t);
				return map.get(topicName);
			}
		}
		
		public List<Topic> getTopics(){
				
			List<Topic> allTopics=Collections.synchronizedList(new ArrayList<>(map.values()));
			
			return allTopics;
		}

		
		public void clear() {
			map.clear();
		}
		
	
		
		
	}
	
	
	
	
	

}
