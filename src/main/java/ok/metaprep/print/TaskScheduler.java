package ok.metaprep.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TPair{
  char task;
  int feq;
  Integer last;
  TPair(char task,int feq){
    this.task = task;
    this.feq = feq;
  }
}

public class TaskScheduler {

  public static void main(String[] args) {
    char[] tasks = {'B','C','D','A','A','A','A','G'};
    System.out.println(leastInterval(tasks,1));
  }

  public static int leastInterval(char[] tasks, int n) {
    List<TPair> result = new ArrayList<>();

    if(tasks==null || tasks.length==0) return 0;

    PriorityQueue<TPair> pq = new PriorityQueue<>((t1,t2) -> {
      if(t2.feq==t1.feq && t1.last!=null && t2.last!=null){
        return t1.last-t2.last;
      }else{
        return  t2.feq - t1.feq;
      }
    });

    Map<Character,TPair> store = new HashMap<>();

    for(char c : tasks){
      store.computeIfAbsent(c,c1->new TPair(c1,0)).feq++;
    }

    for(char k : store.keySet()){
      pq.offer(store.get(k));
    }

    while(!pq.isEmpty()){
      int cycle = n;
      List<TPair> curr_store = new ArrayList<>();

      // fill n times as that is gap needed
      while (cycle >= 0 && !pq.isEmpty()){
        TPair curr = pq.poll();
        result.add(curr);
        curr.last=result.size()-1;
        curr.feq--;
        if(curr.feq>0)
          curr_store.add(curr);
        }

    }

    // FIX .. DO AGAIN ?
    return result.size();

  }
}
