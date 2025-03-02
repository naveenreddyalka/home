package ok.metaprep;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class IPO {

  public static void main(String[] args) {
    findMaximizedCapital(1,0,new int[]{1,2,3},new int[]{1,1,2});
  }

  public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {


    PriorityQueue<int[]> capitalQueue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
    for(int i=0; i<capital.length;i++){
      capitalQueue.offer(new int[]{i,capital[i]});
    }

    while(k>0){
      List<int[]> curr_capital = new ArrayList<>();
      while(!capitalQueue.isEmpty() && capitalQueue.peek()[1]<=w){
        curr_capital.add(capitalQueue.poll());
      }
      int max_profit=Integer.MIN_VALUE;
      int selected = -1;
      for(int i=0;i <curr_capital.size();i++ ){
        if(profits[curr_capital.get(i)[0]]>max_profit){
          max_profit =  profits[curr_capital.get(i)[0]];
          selected = i;
        }
      }
      if(selected==-1) return w;

      w = w +  profits[curr_capital.get(selected)[0]];
      k--;

      for(int i=0;i <curr_capital.size();i++ ){
        if(i!=selected){
          capitalQueue.offer(curr_capital.get(i));
        }
      }

    }

    return w;
  }

  public static int maximumCapital(int c, int k, int[] capitals,int[] profits) {

    PriorityQueue<int[]> capitalQueue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
    PriorityQueue<int[]> profitQueue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
    for(int i=0; i<capitals.length;i++){
      capitalQueue.offer(new int[]{i,capitals[i]});
    }

    while(k>0){
      while(!capitalQueue.isEmpty() && capitalQueue.peek()[1]<=c){
        int[] cap = capitalQueue.poll();
        profitQueue.offer(new int[]{cap[0],profits[cap[0]]});
      }

      if(profitQueue.isEmpty()) break;

      c = c + profitQueue.poll()[1];

      k--;

    }

    return c;
  }

}
