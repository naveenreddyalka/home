package ok.metaprep.tree;

import java.util.ArrayList;
import java.util.List;


class Pair{
  int height;
  int val;
  Pair(int height,int val) { this.val = val; this.height = height;}
}

public class FindLeavesOfBinaryTree {
  static int max_height = 0;

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(2);
    TreeNode t3 = new TreeNode(3);
    TreeNode t4 = new TreeNode(4);
    TreeNode t5 = new TreeNode(5);
    t1.left = t2;
    t1.right = t3;
    t2.left = t4;
    t2.right = t5;

    List<List<Integer>> result = findLeaves(t1);
    printResult(result);

  }

  public static void printResult(List<List<Integer>> result) {
    for (List<Integer> sublist : result) {
      System.out.println(sublist);
    }
  }

  public static List<List<Integer>> findLeaves(TreeNode root) {
    List<Pair> pairs = new ArrayList<>();
    dfsHeight(root,pairs);
    List<List<Integer>> result = new ArrayList<>();
    for(int i=0;i<max_height;i++){
      result.add(new ArrayList<>());
    }

    for(Pair p : pairs){
      List<Integer> hlist = result.get(p.height-1);
      hlist.add(p.val);
    }

    return result;
  }


  public static int dfsHeight(TreeNode root, List<Pair> pairs){
    if(root==null) return 0;

    int left_height = dfsHeight(root.left,pairs);
    int right_height = dfsHeight(root.right,pairs);
    int curr_height = Math.max(right_height,left_height)+1;
    pairs.add(new Pair(curr_height,root.val));
    max_height = Math.max(max_height,curr_height);
    return curr_height;
  }
}
