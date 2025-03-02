package ok.metaprep;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class FPair{
  char c;
  int freq;
  FPair(char c, int freq){
    this.c = c;
    this.freq = freq;
  }
}
public class ReorganizeString {

  public static void main(String[] args) {

    int[][] tasks = new int[10][2];
    PriorityQueue<int[]> startQueue = new PriorityQueue<>((a,b) -> a[0]-b[0]);
    for(int[] t:tasks){
      startQueue.offer(t);
    }


    System.out.println(reorganizeString("aaaaabbbbbbb"));
  }

  public static String reorganizeString(String string1) {
    // Replace this placeholder return statement with your code
    PriorityQueue<FPair> pq = new PriorityQueue<>((a,b)->b.freq-a.freq);
    Map<Character, FPair> map = new HashMap<>();
    for (int i=0; i<string1.length();i++){
      map.computeIfAbsent(string1.charAt(i),c -> new FPair(c,0)).freq++;
    }
    for(Character key : map.keySet()){
      pq.offer(map.get(key));
    }

    StringBuilder sb = new StringBuilder();
    FPair previous = null;
    while (!pq.isEmpty()){
      FPair curr = pq.poll();
      sb.append(curr.c);
      curr.freq--;

      if(previous!=null){
        pq.offer(previous);
        previous=null;
      }

      if(curr.freq>0)
        previous = curr;
    }
    String result = sb.toString();
    if(previous!=null && (previous.freq>=2 || result.endsWith(String.valueOf(previous.c)))) return "";

    if(previous!=null) result = result+previous.c;

    return result;
  }
}
