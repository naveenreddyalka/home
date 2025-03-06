package ok.metaprep;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class MinStack {

  static Map<int[], Boolean> store = new HashMap<>();

  public static void main(String[] args) {

    PriorityQueue<Integer> maxFuel = new PriorityQueue<>((a,b) -> b-a);

    store.containsKey(new int[]{1,2});
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin());
    minStack.pop();
    minStack.pop();
    System.out.println(minStack.getMin());
  }

  // push pop and peek
  private Stack<int[]> stack = new Stack<>();

  // offer, poll and peek
  private Queue<int[]> queue = new LinkedList<>();

  private Deque<Integer> deque = new ArrayDeque<>();

  public MinStack() {}

  public void push(int x) {
  if(stack.isEmpty()){
    stack.push(new int[]{x,x});
  }else{
    stack.push(new int[]{x,Math.min(stack.peek()[1],x)});
  }
  }

  public void pop() {
    stack.pop();
  }

  public int top() {
    return stack.peek()[0];
  }

  public int getMin() {
  return stack.peek()[1];
  }
}
