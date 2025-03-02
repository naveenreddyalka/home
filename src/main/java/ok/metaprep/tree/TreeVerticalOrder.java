package ok.metaprep.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class TreeVerticalOrder {



  static Map<Integer, List<Integer[]>> store = new HashMap<Integer,List<Integer[]>>();
  static Integer min = 0;
  static Integer max = 0;

  public static List<List<Integer>> verticalOrder(TreeNode root) {
    fill(root, 0 , 0);
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    for(int i=min;i<=max;i++){
      List<Integer> col = new ArrayList<>();
      List<Integer[]> vals = store.get(i);
      Collections.sort(vals, (a,b) -> a[1]-b[1]);
      for (Integer[] in : vals){
        col.add(in[0]);
      }
      result.add(col);
    }
    return result;
  }

  public static void fill(TreeNode root, int c, int r){
    if(root==null) return;

    store.computeIfAbsent(c, i -> new ArrayList()).add(new Integer[]{root.val,r});

    min = Math.min(min,c);
    max = Math.max(max,c);

    fill(root.left, c-1 , r+1);
    fill(root.right, c+1, r+1);
  }


  public static void printList(List<List<Integer>> list) {
    for (List<Integer> innerList : list) {
      System.out.println(innerList);
    }
  }

  public static void main(String[] args) {


    TreeSet<Integer[]> t = new TreeSet<>((a,b) -> a[1] - b[1]);
    t.add(new Integer[]{1,2});
    t.add(new Integer[]{1,3});
    t.add(new Integer[]{1,4});
    t.add(new Integer[]{2,4});


    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(2);
    TreeNode t3 = new TreeNode(3);
    TreeNode t4 = new TreeNode(4);
    TreeNode t5 = new TreeNode(5);
    TreeNode t6 = new TreeNode(6);
    TreeNode t7 = new TreeNode(7);
    t1.left = t2;
    t1.right = t5;
    t2.left = t3;
    t2.right = t4;
    t5.right = t6;
    t5.left = t7;

    printList(verticalOrder(t1));
  }
}
