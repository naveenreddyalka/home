package ok.metaprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import javax.persistence.criteria.CriteriaBuilder.In;

public class TopKFrequent {

  public static void main(String[] args) {
    List<String> stringList = Arrays.asList("value1", "value2","value2", "value3");

    List<Integer> intList = Arrays.asList(1, 2, 3, 3, 3,5,5,6,6,6,6,6);

    int[] t = intList.stream().mapToInt(i -> i).toArray();
    int[] t1 = intList.stream().mapToInt(Integer::intValue).toArray();
    System.out.println( Arrays.toString(topKFrequent(t, 2)));
    System.out.println( topKFrequent(stringList.toArray(new String[0]),2));

  }

  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer,Integer> store = new HashMap<Integer,Integer>();
    for(int n : nums){
      store.put(n, store.getOrDefault(n,0)+1);
    }

    // Min heap has the minimum element at the top,
    // and you need to do a comparator with n1-n2 to get the min element
    Queue<Integer> minHeap = new PriorityQueue<Integer>((w1, w2) ->
        store.get(w1).equals(store.get(w2)) ? w2.compareTo(w1) : (store.get(w1) - store.get(w2)));

    for (Map.Entry<Integer,Integer> e : store.entrySet()){
      minHeap.add(e.getKey());
      if(minHeap.size()>k) minHeap.poll();
    }

    List<Integer> result = new ArrayList<>(k);
    while(!minHeap.isEmpty()){
      result.add(minHeap.poll());
    }

    return result.stream().mapToInt(i->i).toArray();
  }

  public static List<String> topKFrequent(String[] words, int k) {
    Map<String,Integer> store = new HashMap<String,Integer>();
    for(String n : words){
      store.put(n, store.getOrDefault(n,0)+1);
    }

    // Min heap has the minimum element at the top,
    // and you need to do a comparator with n1-n2 to get the min element
    Queue<String> minHeap = new PriorityQueue<String>((w1, w2) ->
        store.get(w1).equals(store.get(w2)) ? w2.compareTo(w1) : (store.get(w1) - store.get(w2)));

    for (Map.Entry<String,Integer> e : store.entrySet()){
      minHeap.add(e.getKey());
      if(minHeap.size()>k) minHeap.poll();
    }

    List<String> result = new ArrayList<>(k);
    while(!minHeap.isEmpty()){
      result.add(minHeap.poll());
    }

    // when a minHeap pops elements it will in increasing order with min as first.
    Collections.reverse(result);
    return result;
  }

}
