package ok.demo.tree;

public class kthsmallest {

  static int count = 0;
  static int val = -1;

  public static void main(String[] args) {
    // -------7-------
    // ----3------11---
    // --1---5----9---13
    // -n-2-4-6-8-10-12-14
    int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    node root = buildminbst.getbstNice(test, 0, test.length - 1);
    print(root);
    //System.out.println(kth(root, 4));
  }

  private static void print(node root) {
      if(root==null) return;
      print(root.getLeft());
      count++;
      if(count==6) System.out.print(root.getValue()+",");
     // System.out.print(root.getValue()+",");
      print(root.getRight());
      
  }
  private static int kth(node root, int k) {
    if (val != -1) return val;

    if (root.getLeft() != null) {
      kth(root.getLeft(), k);
    } else {
      count++;
      if (count == k) {
        val = root.getValue();
      }
    }
    
    if(root.getLeft()!=null) {count++;}

    if (root.getRight() != null) {
      kth(root.getRight(), k);
    }

    return val;
  }
}
