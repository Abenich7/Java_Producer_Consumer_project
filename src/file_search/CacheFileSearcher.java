package file_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class CacheFileSearcher implements FileSearcher {

	//cache storage 
	//store less words 
	//right now saving a list of entire file + hashmap
	//we want to make memory access quicker. 
	//io is slow, ram is quick
	ArrayList<String> cached_lines;
	HashMap<String, Set<Integer>> map;
	int size;
	
	public CacheFileSearcher() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void loadFile(String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<String> search(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMemSize() {
		// TODO Auto-generated method stub
		return 0;
	}

}
