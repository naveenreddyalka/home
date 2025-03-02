package ok.metaprep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {

  public static void main(String[] args) {
    int[][] arr = {{0,1},{1,0}};
    System.out.println(canFinish(2, arr));
  }

  public static boolean canFinish(int numCourses, int[][] prerequisites) {

    Map<Integer, List<Integer>> adj = new HashMap<>();
    for(int i=0;i<prerequisites.length;i++){
      adj.computeIfAbsent(prerequisites[i][0], k -> new ArrayList<>()).add(prerequisites[i][1]);
    }
    boolean[] visited = new boolean[numCourses];
    boolean[] curr = new boolean[numCourses];

    for(int key: adj.keySet()){
        if(!cleanDFS(adj, key, visited, curr)) return false;
    }

    return true;
  }

  public static boolean cleanDFS(Map<Integer, List<Integer>> adj, int key, boolean[] visited, boolean[] curr) {
    if (curr[key])
      return false;
    if (visited[key])
      return true;

    List<Integer> neighbors = adj.get(key);
    curr[key] = true;
    visited[key] = true;
   if(neighbors!=null){
    for (int i = 0; i < neighbors.size(); i++) {
      if (!cleanDFS(adj, neighbors.get(i), visited, curr)) {
        return false;
      }
    }
   }
    curr[key] = false;
    return true;
  }

}
