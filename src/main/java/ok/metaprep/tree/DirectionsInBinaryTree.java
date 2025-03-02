package ok.metaprep.tree;

public class DirectionsInBinaryTree {

  public static void main(String[] args) {
    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(2);
    TreeNode t3 = new TreeNode(3);
    TreeNode t4 = new TreeNode(4);
    TreeNode t5 = new TreeNode(5);
    TreeNode t6 = new TreeNode(6);
    t1.left = t2;
    t1.right = t5;
    t2.left = t3;
    t2.right = t4;
    t5.right = t6;


    TreeNode o3 = new TreeNode(3);
    TreeNode o1 = new TreeNode(1);
    TreeNode o2 = new TreeNode(2);
    o3.left=o1;
    o3.right=o2;

    System.out.println(getDirections(o3,2,1));
  }

  public static String getDirections(TreeNode root, int startValue, int destValue) {

    TreeNode lca =  lca(root, startValue, destValue);

    if(lca.val==startValue) return getPath(lca, destValue,"");
    if(lca.val==destValue) {
      return getPath(lca, startValue,"").replaceAll(".", "U");
    }
    String path1 = getPath(lca, startValue,"").replaceAll(".", "U");
    String path2 = getPath(lca, destValue,"");
    return path1+path2;
  }

  public static String getPath(TreeNode lca, int find, String path){
    if(lca==null) return null;
    if(lca.val==find) return path;
    if(lca.left==null && lca.right==null) return null;
    String found = null;
    if(lca.left!=null){
      found = getPath(lca.left, find, path+"L");
    }

    if(found==null && lca.right!=null){
      found = getPath(lca.right, find, path+"R");
    }
    return found;
  }

  public static TreeNode lca(TreeNode root, int startValue, int destValue){
    if(root==null) return null;
    if(root.val==startValue || root.val==destValue) return root;

    TreeNode lc1 = lca(root.left, startValue, destValue);
    TreeNode lc2 = lca(root.right, startValue, destValue);

    if(lc1!=null && lc2!=null) return root;
    else if (lc1!=null) return lc1;
    else if (lc2!=null) return lc2;
    else return null;
  }
}
