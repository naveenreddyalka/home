package ok.metaprep.tree;

public class FlattenBinaryTreeToLinkedList  {

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

    flatten(t1);
  }


  public static void flatten(TreeNode root) {
    dfs(root);
  }

  public static TreeNode dfs(TreeNode root){
    if(root==null) return null;

    TreeNode leftHead = dfs(root.left);
    TreeNode rightHead = dfs(root.right);

    TreeNode leftTail = null;
    if(leftHead!=null){
      root.right = leftHead;
      root.left = null;
      while(leftHead!=null){
        leftTail = leftHead;
        leftHead = leftHead.right;
      }
    }

    if(leftTail!=null){
      leftTail.right = rightHead;
    }else{
      root.right = rightHead;
    }

    return root;
  }

}
