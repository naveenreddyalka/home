package ok.metaprep;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }

public class LinkedList {

  public static void main(String[] args) {
    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode four = new ListNode(4);
    one.next = two;
    two.next = three;
    three.next = four;
    four.next = one;
    System.out.println(detectCycle(one).val);
  }


  public static ListNode detectCycle(ListNode head) {

    if(head==null) return null;

    ListNode cycleHead = cutCycle(head);

    if(cycleHead==null) return null;

    Stack<ListNode> one = new Stack<ListNode>();
    Stack<ListNode> two = new Stack<ListNode>();

    while(head!=null){
      one.push(head);
      head = head.next;
    }

    while(cycleHead!=null){
      two.push(cycleHead);
      cycleHead = cycleHead.next;
    }

    ListNode cycleStart = null;
    while(!one.isEmpty() && !two.isEmpty()){
      if(one.peek() == two.peek()){
        cycleStart= one.pop();
        two.pop();

      }else{
        return cycleStart;
      }
    }

    return cycleStart;
  }

  public static ListNode userSet(ListNode head){
    Set<ListNode> store = new HashSet<ListNode>();
    while(head!=null){
      if(store.contains(head)){
        return head;
      }
      store.add(head);
      head= head.next;
    }

    return null;
  }
  public static ListNode cutCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while(true){
      if(fast.next!=null){
        fast = fast.next.next;
      }else{
        break;
      }

      if(fast==null) break;
      if(fast == slow){
        ListNode nextNode = fast.next;
        fast.next = null;
        return nextNode;
      }

      slow = slow.next;

    }

    return null;
  }

  public static boolean detectCycle2(ListNode head) {

    if(head==null) return false;

    ListNode slow = head;
    ListNode fast = head.next!=null?head.next.next:null;

    while(fast!=null){
      if(fast == slow){
        return true;
      }
      slow = slow.next;
      if(fast.next!=null){
        fast = fast.next.next;
      }

    }

    return false;
  }

}

