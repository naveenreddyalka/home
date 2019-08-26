package ok.demo.tree;

import java.util.ArrayList;

import ok.demo.linkedlist.ll;

public class mirror {
  
  public static void main(String[] args) {
    // -------7-------
    // ----3------11---
    // --1---5----9---13
    // -n-2-4-6-8-10-12-14
    int[] test = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
    node root = buildminbst.getbstNice(test, 0, test.length - 1);

   
     mirror2(root);
    
    System.out.println(root);
    
   
}

  
  private static node mirror(node head) {
    node mirror = new node();
    mirror.setValue(head.getValue());
    
    if(head.getLeft()!=null) {
      mirror.setRight(mirror(head.getLeft()));
    }
    
    if(head.getRight()!=null) {
      mirror.setLeft(mirror(head.getRight()));
    }
    
    return mirror;
  }
  
  
  private static void mirror2(node head) {
   if(head==null) return;
   
    node l = head.getLeft();
    node r = head.getRight();
    if(l!=null) {
      mirror2(l);   
    }
    if(l!=null) {
      mirror2(r);   
    }
    
    head.setLeft(r);
    head.setRight(l);
    
  }

}
