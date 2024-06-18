package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_Bfs {
	
	public static void main(String[] args) {
		
		int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
		int[][] result = updateMatrix(matrix);

		for (int[] subMatrix : result) {
			System.out.println(Arrays.toString(subMatrix));
		}
	}
	
	public static int[][] updateMatrix(int[][] matrix) {
		
		int m = matrix.length;
		int n = matrix[0].length;	
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<>();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					queue.offer(new int[] {i, j});
					visited[i][j] = true;
				}
			}
		}
		
		int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
		int[][] result = new int[m][n];
		int[] currentNode;
		int cost = 0;
		int size;
		int a;
		int b;
		int x;
		int y;
		
		while (!queue.isEmpty()) {
			size = queue.size();
			for (int s = 0; s < size; s++) {
				currentNode = queue.poll();
				a = currentNode[0];
				b = currentNode[1];
				if (matrix[a][b] == 1) {
					result[a][b] = cost;
				}
				for (int[] dir : dirs) {
					x = a + dir[0];
					y = b + dir[1];
					if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
						queue.offer(new int[] {x, y});
						visited[x][y] = true;
					}
				}
			}		
			cost++;
		}
		
		return result;
	}
}
