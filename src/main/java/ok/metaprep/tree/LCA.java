package ok.metaprep.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LCATreeNode {
      int val;
      LCATreeNode left;
      LCATreeNode right;
      LCATreeNode parent;
      LCATreeNode(int x) { val = x; }
  }

public class LCA {

  public static void main(String[] args) {
    LCATreeNode zero_0 = new LCATreeNode(0);
    LCATreeNode one_1 = new LCATreeNode(1);
    LCATreeNode two_2 = new LCATreeNode(2);
    LCATreeNode three_3 = new LCATreeNode(3);
    LCATreeNode four_4 = new LCATreeNode(4);
    LCATreeNode five_5 = new LCATreeNode(5);
    LCATreeNode six_6 = new LCATreeNode(6);
    LCATreeNode seven_7 = new LCATreeNode(7);
    LCATreeNode eight_8 = new LCATreeNode(8);

    three_3.left=five_5;
    three_3.right=one_1;
    five_5.left=six_6;
    five_5.right=two_2;
    two_2.left=seven_7;
    two_2.right=four_4;
    one_1.left=zero_0;
    one_1.right=eight_8;
    eight_8.parent=one_1;
    zero_0.parent=one_1;
    one_1.parent=three_3;
    four_4.parent=two_2;
    seven_7.parent=two_2;
    two_2.parent=five_5;
    six_6.parent=five_5;
    five_5.parent=three_3;

    lowestCommonAncestorParent(five_5,four_4);

    LCATreeNode root = new LCATreeNode(1);
    LCATreeNode two = new LCATreeNode(2);
    LCATreeNode three = new LCATreeNode(3);
    LCATreeNode four = new LCATreeNode(4);
    LCATreeNode five = new LCATreeNode(5);
    root.left=two;
    root.right=three;
    two.left=four;
    three.right=five;
    LCATreeNode six = new LCATreeNode(6);
    LCATreeNode t1 = lowestCommonAncestor(root, four, six);
    LCATreeNode t2 = lcan(root, four, six);
    System.out.println(t2.val);
    System.out.println(t1.val);
  }

  static LCATreeNode result = null;

  public static LCATreeNode lowestCommonAncestor(LCATreeNode root, LCATreeNode p, LCATreeNode q) {
    lca(root, p, q);
    return result;
  }

  public static boolean lca(LCATreeNode root, LCATreeNode p, LCATreeNode q){
    if(root==null) return false;
    boolean left = lca(root.left, p, q);
    boolean right = lca(root.right, p, q);
    boolean curr = (root.val==p.val || root.val==q.val) ? true : false;
    if(left && right || (left && curr) || (right && curr))
      result = root;
    return left || right || curr;
  }

  // Works only if both or one of the node is present in the tree
  public static LCATreeNode lcan(LCATreeNode root, LCATreeNode p, LCATreeNode q ){
    if(root==null) return null;
    if(root.val==p.val || root.val==q.val) return root;
    LCATreeNode left = lcan(root.left, p, q);
    LCATreeNode right = lcan(root.right, p, q);
    if(left!=null && right!=null) return root;
    return left!=null ?left: right;
  }


  public static LCATreeNode lowestCommonAncestorParentBest(LCATreeNode p, LCATreeNode q) {
    Set<LCATreeNode> seen = new HashSet<>();
    while(p!=null){
      seen.add(p);
    }

    while(q!=null){
    if(seen.contains(q)) return q;
    seen.add(q);
    }
    return null;
  }

  public static LCATreeNode lowestCommonAncestorParent(LCATreeNode p, LCATreeNode q) {
    List<LCATreeNode> p_p =  getParents(p);
    List<LCATreeNode> q_p =  getParents(q);
    Collections.reverse(p_p);
    Collections.reverse(q_p);

    int i = 0, j = 0;

    while(i<p_p.size() && j<q_p.size()){
      if(p_p.get(i).val!=q_p.get(j).val){
        return p_p.get(i-1);
      }
      i++;j++;
    }

    return p_p.get(i-1);
  }

  public static List<LCATreeNode> getParents(LCATreeNode a){
    if(a==null) return null;

    List<LCATreeNode> nodes = new ArrayList<>();

    while(a!=null){
      nodes.add(a);
      a=a.parent;
    }

    return nodes;
  }

}
