package ok.demo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CanFinish {

	public static void main(String[] args) {
		CanFinish c = new CanFinish();
		
		
		int[][] a = {{2,0},{1,0},{3,1},{3,2},{1,3}};
	
		System.out.println(c.canFinish(4, a));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		int l = prerequisites.length;
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < l; i++) {
			int p = prerequisites[i][1];
			int c = prerequisites[i][0];
			if (graph.containsKey(p)) {
				List<Integer> t = graph.get(p);
				t.add(c);
			} else {
				List<Integer> t = new ArrayList<Integer>();
				t.add(c);
				graph.put(p, t);
			}
		}
		
		int[] visited = new int[numCourses];
		Arrays.setAll(visited, (i) -> 0);
		
		for (int k : graph.keySet()) {
			Arrays.setAll(visited, (i) -> 0);
			Queue<Integer> que = new LinkedList<Integer>();
			que.addAll(graph.get(k));
			while (!que.isEmpty()) {
				int local = que.poll();
				if(visited[local]==1) continue;
				if (local == k)
					return false;
				visited[local]=1;
				if (graph.get(local) != null)
					que.addAll(graph.get(local));
			}

		}

		return true;
	}

}
