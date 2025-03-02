package ok.metaprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {

  public int val;
  public List<Node> neighbors;

  public Node() {
    val = 0;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val) {
    val = _val;
    neighbors = new ArrayList<Node>();
  }

  public Node(int _val, ArrayList<Node> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}

class Solution {

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Map<Integer, Node> store = new HashMap<Integer, Node>();
    return cloneGraph(node, store);
  }


  public Node cloneGraph(Node node, Map<Integer, Node> store) {
    if (store.containsKey(node.val)) {
      return store.get(node.val);
    }
    Node clone = new Node(node.val);
    store.put(node.val, clone);
    for (Node n : node.neighbors) {
      clone.neighbors.add(cloneGraph(n, store));
    }
    return clone;
  }
}

public class CloneGraph {

  public static void main(String[] args) {
    int[][] result = new int[2][2];
    result[0][1] = 1;
    result[0][2] = 2;
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);
    one.neighbors.add(two);
    one.neighbors.add(three);
    two.neighbors.add(three);
    three.neighbors.add(four);
    four.neighbors.add(five);

    Solution sol = new Solution();

    sol.cloneGraph(one);

  }

}
