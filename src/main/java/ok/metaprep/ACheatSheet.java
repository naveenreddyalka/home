package ok.metaprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class ACheatSheet {

  public static void main(String[] args) {

    // Stack: push and pop
    Stack<int[]> stack = new Stack<>();
    stack.push(new int[]{1,2,3});
    stack.peek();
    stack.pop();
    // Queue: offer and poll
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{1,2,3});
    queue.peek();
    queue.poll();

    Deque<int[]> deque = new LinkedList<>();
    deque.addLast(new int[]{1,2,3});
    deque.addFirst(new int[]{4,5,6});
    deque.removeFirst();
    deque.removeLast();

    // Max heap, b - a
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
    maxHeap.offer(1);
    maxHeap.peek();
    maxHeap.poll();
    maxHeap.remove(1);

    // Min heap, a - b
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a-b);

    // 0 in inclusive
    Random random = new Random();
    int randomNumber = random.nextInt(100) + 1;

    //int[] sorting
    int[] nums = new int[randomNumber];
    Arrays.sort(nums);

    //sort Object Array
    Integer[] nums2 = new Integer[randomNumber];
    Arrays.sort(nums2, (a,b) -> a-b);

    List<Integer> list1 = new ArrayList<>();
    Collections.reverse(list1);
    Collections.sort(list1, (a,b) -> b-a);

    // List inline
    List<Integer> list2=Arrays.asList(1, 2, 3);
    List<Integer> list3=Arrays.asList(nums2);
    Integer[] intArrayFromList= list3.toArray(new Integer[0]); // it will resize

    list2.addAll(Arrays.asList(intArrayFromList));
    list2.addAll(list3);

    // String and StringBuilder
    String s1 = "stirng";
    s1 = s1.substring(0,1); // 0 inclusive and 1 exclusive
    char[] chars = s1.toCharArray();
    String s2 = new String(chars);
    s2.charAt(0);

    int zero = '0';
    int one = '1' - zero;

    Character.isDigit(one);
    Character.isAlphabetic(zero);

    Map<Integer, List<Integer>> map = new HashMap<>();
    map.computeIfAbsent(zero, key_zero -> new ArrayList<>()).add(one);

    Map<Integer, Integer> map2 = new HashMap<>();
    map2.put(zero, map2.getOrDefault(zero,0)+1);


  }
}
