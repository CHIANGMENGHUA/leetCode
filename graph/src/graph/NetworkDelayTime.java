package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {

	public static void main(String[] args) {
		
		int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
		int n = 4;
		int k = 2;
		
		System.out.println(networkDelayTime(times, n, k));
	}
	
	public static int networkDelayTime(int[][] times, int n, int k) {
		
		Map<Integer, List<Cell>> map = new HashMap<>();
		Map<Integer, Integer> costs = new HashMap<>();
		PriorityQueue<Cell> heap = new PriorityQueue<>();
		
		for (int[] time : times) {
			List<Cell> edges = map.getOrDefault(time[0], new ArrayList<>());
			edges.add(new Cell(time[1], time[2]));
			map.put(time[0], edges);
		}
		
		heap.offer(new Cell(k, 0));
		Cell currentCell;
		
		while (!heap.isEmpty()) {
			currentCell = heap.poll();
			if (costs.containsKey(currentCell.node)) {
				continue;
			}
			costs.put(currentCell.node, currentCell.time);
			if (map.containsKey(currentCell.node)) {
				for (Cell neighborCell : map.get(currentCell.node)) {
					if (!costs.containsKey(neighborCell.node)) {
						heap.offer(new Cell(neighborCell.node, currentCell.time + neighborCell.time));
					}
				}
			}
		}
		
		if (costs.size() != n) {
			return -1;
		}
		
		int result = 0;
		
		for (int x : costs.values()) {
			result = Math.max(result, x);
		}
		
		return result;
	}
}

class Cell implements Comparable<Cell> {
	
	int node;
	int time;
	
	public Cell(int node, int time) {
		super();
		this.node = node;
		this.time = time;
	}
	
	@Override
	public int compareTo(Cell c2) {
		return time - c2.time;
	}
}
