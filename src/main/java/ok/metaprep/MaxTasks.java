package ok.metaprep;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxTasks {

  public static int getMaxTasks(List<int[]> tasks) {
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);

    for(int[] i : tasks){
      minHeap.offer(i);
    }

    int maxTasks = 0;
    int daysSoFar = 0;

    while(!minHeap.isEmpty()){
      int[] curr = minHeap.poll();

      if(daysSoFar==0){
        maxTasks++;
        daysSoFar = daysSoFar + curr[0];
      }else{
          if(daysSoFar + curr[0]<curr[1]){
            daysSoFar = daysSoFar + curr[0];
            maxTasks++;
          }
      }

    }
    return maxTasks;
  }
  public static void main(String[] args) {
    List<int[]> tasks = new ArrayList<>();
    tasks.add(new int[]{10,20});
    tasks.add(new int[]{20,130});
    tasks.add(new int[]{100,125});
    tasks.add(new int[]{200,320});

    List<int[]> tasks = new ArrayList<>();
    tasks.add(new int[]{10,20});
    tasks.add(new int[]{20,130});
    tasks.add(new int[]{100,125});
    tasks.add(new int[]{200,320});

    System.out.println(getMaxTasks(tasks));


  }
}
