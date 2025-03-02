package ok.metaprep.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class BuildTree {




  Map<Integer, TreeSet<Integer[]>> store = new HashMap<Integer,TreeSet<Integer[]>>();
  Integer min = 0;
  Integer max = 0;

  public List<List<Integer>> verticalOrder(TreeNode root) {
    fill(root, 0 , 0);
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    for(int i=min;i<=max;i++){
      List<Integer> col = new ArrayList<>();
      for (Integer[] in : store.get(i)){
        col.add(in[0]);
      }
      result.add(col);
    }
    return result;
  }

  public void fill(TreeNode root, int c, int r){
    if(root==null) return;

    store.computeIfAbsent(c, i -> new TreeSet<>((a,b) -> a[1]-b[1]))
        .add(new Integer[]{root.val,r});

    min = Math.min(min,c);
    max = Math.max(max,c);

    fill(root.left, c-1 , r+1);
    fill(root.right, c+1, r+1);
  }


  public static void main(String[] args) {
    int[] preorder = {1,2};
    int[] inorder = {2,1};
    TreeNode root = buildTree(preorder,inorder);
    System.out.println(root.val);
  }

  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0) return null;
    TreeNode root = new TreeNode(preorder[0]);
    for(int i=0; i<inorder.length;i++){
      if(inorder[i]==root.val){
        if(inorder.length==1){
          root.left = null;
          root.right = null;
        }else {
          int[] forLeft = removeFirst(preorder);
          TreeNode left = buildTree(forLeft, Arrays.copyOfRange(inorder, 0, i));
          TreeNode right = null;
          if (inorder.length == 1)
            right = buildTree(removeFirst(forLeft), Arrays.copyOfRange(inorder, 0, inorder.length));
          else if (i + 1 > inorder.length - 1)
            right = buildTree(removeFirst(forLeft), new int[0]);
          else
            right = buildTree(removeFirst(forLeft),
                Arrays.copyOfRange(inorder, i + 1, inorder.length));
          root.left = left;
          root.right = right;
        }
      }
    }
    return root;
  }

  public static int[] removeFirst(int[] arr) {
    if (arr == null || arr.length == 0) {
      return arr; // Return original if empty or null
    }
    return Arrays.copyOfRange(arr, 1, arr.length);
  }
}
