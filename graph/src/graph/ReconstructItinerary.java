package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

	public static void main(String[] args) {
		
		List<List<String>> tickets = Arrays.asList(Arrays.asList("MUC", "LHR"),
	            								   Arrays.asList("JFK", "MUC"),
	            								   Arrays.asList("SFO", "SJC"),
	            								   Arrays.asList("LHR", "SFO"));
		
		System.out.println(findItinerary(tickets));
	}
	
    public static List<String> findItinerary(List<List<String>> tickets) {
        
    	Map<String, PriorityQueue<String>> map = new HashMap<>();
    	List<String> result = new LinkedList<>();
    	
    	for (List<String> edge :tickets) {
    		map.computeIfAbsent(edge.get(0), k -> new PriorityQueue<>()).offer(edge.get(1));
    	}
    	
    	dfs(result, map, "JFK");
    	
    	return result;
    }
    
    static PriorityQueue<String> neighbors;
    
    public static void dfs(List<String> result, Map<String, PriorityQueue<String>> map, String current) {
    	
    	neighbors = map.getOrDefault(current, new PriorityQueue<>());
    	
    	while (!neighbors.isEmpty()) {
    		dfs(result, map, neighbors.poll());
    	}
    	
    	result.add(0, current);
    }

}
