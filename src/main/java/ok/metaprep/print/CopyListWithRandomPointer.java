package ok.metaprep.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ok.demo.tree.result;

class CNode {
  int val;
  CNode next;
  CNode random;

  public CNode(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

public class CopyListWithRandomPointer {

  public static void main(String[] args) {
    CNode head = new CNode(1);
    CNode two = new CNode(2);
    CNode three = new CNode(3);
    head.random= three;
    head.next = two;
    two.next = three;
    two.random = head;
    three.random = two;
    CNode val =  copyRandomList(head);
    System.out.println(val.val);
  }


  static Map<CNode,CNode> store = new HashMap<>();

  public static CNode copyRandomList(CNode head) {

    if(head==null) return head;

    CNode new_head = new CNode(head.val);
    CNode ptr = null;

    while(head!=null){

      if(ptr==null){
         ptr = new_head;
         store.put(head,new_head);
       }

       if(head.random!=null){
         CNode random = store.computeIfAbsent(head.random, n -> new CNode(n.val));
         ptr.random = random;
       }

       if(head.next!=null){
         CNode next = store.computeIfAbsent(head.next, n -> new CNode(n.val));
         ptr.next = next;
       }

        ptr = ptr.next;
       head = head.next;

    }

    return new_head;

  }
}
