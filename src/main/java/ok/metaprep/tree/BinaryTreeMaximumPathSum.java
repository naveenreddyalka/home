package ok.metaprep.tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class BinaryTreeMaximumPathSum {

  List<String> paths = new ArrayList<>();
  public void path(TreeNode root, List<Integer> curr) {
    if(root==null) return;
    curr.add(root.val);

    path(root.left,curr);

  }



  static int max = Integer.MIN_VALUE;

  public static Integer maxAtNode(TreeNode root){
    if(root==null) return null;

    Integer max_left = maxAtNode(root.left);
    Integer max_right = maxAtNode(root.right);

    Integer maxHere = null;
    Integer all = null;

    if(max_left==null) {
      if(max_right==null) {
        maxHere =root.val;
      }else{
        maxHere =Math.max(root.val,root.val+max_right);
      }
    }else if(max_right==null) {
      maxHere =Math.max(root.val,root.val+max_left);
    }else{
      int a = root.val;
      int b = max_left + root.val;
      int c = max_right + root.val;
      maxHere =Math.max(a,Math.max(b, c));
      all = max_left + root.val + max_right;
    }


    max = maxHere==null? max:(all==null?Math.max(maxHere,max):Math.max(all,Math.max(maxHere,max)));

    return maxHere;
  }

  public static int maxPathSum(TreeNode root) {
    maxAtNode(root);
    return max;
  }

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(2);
    TreeNode t2 = new TreeNode(-1);
    TreeNode t3 = new TreeNode(-2);
    t1.left = t2;
    t1.right = t3;
    System.out.println(maxPathSum(t1));
  }
}
