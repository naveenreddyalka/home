package ok.demo.linkedlist;

public class llproblems {

    
  public static void main(String[] args) {
    ll one = new ll(1, new ll(2, new ll(3, new ll(3, new ll(5, null)))));

    
    ll l7 = new ll(6,null);
    ll l6 = new ll(6,l7);
    ll l1 = new ll(1, new ll(2, new ll(3, new ll(4, new ll(5, l6)))));
    
    ll l3 = l1.getNext().getNext();
    
    l7.setNext(l3);
    
    ll start = loop(l1);
    System.out.println(start);

  }
  
  private static ll loop(ll node) {
    if(node==null || node.getNext()==null) return null;
    
    ll slow = node;
    ll fast = node;
    
    while(fast.getNext()!=null) {
      fast = fast.getNext();
      if(fast!=null) fast = fast.getNext();
      if(fast!=null) slow = slow.getNext();
      if(slow == fast) break;
    }
    
    if(slow == fast) {
      fast = node;
      while(fast!=slow) {
        fast = fast.getNext();
        slow = slow.getNext();
      }
    }
    
    return slow;
  }
  
  private static ll rev(ll node) {
   if(node==null) return null;
    
    ll head= node;
    ll pre = new ll(head.getValue(),null);
    
    while(head.getNext()!=null) {
      ll tmp = new ll(head.getNext().getValue(),pre);
      pre = tmp;
      head = head.getNext();
    }
    return pre;
  }

  private static ll merge_sorted(ll l1,ll l2) {
    ll r = null,s = null;
   
    if(l1 !=null) {
      if(l2==null) return l1;
    }else if(l2!=null) {
      return l2;
    }else {
      return r;
    }
    
    if(l1.getValue()>l2.getValue()) {
      s = r = new ll(l2.getValue(), null);
      l2 = l2.getNext();
    }else {
      s = r = new ll(l1.getValue(), null);
      l1 = l1.getNext();
    }
    
    while(l1!=null && l2!=null) {
      
     if(l1.getValue()>l2.getValue()) {
       r.setNext(new ll(l2.getValue(), null));
       l2 = l2.getNext();
     }else {
       r.setNext(new ll(l1.getValue(), null));
       l1 = l1.getNext();
     }
     r = r.getNext();
    }
    
    if(l1 ==null) {
      r.setNext(new ll(l2.getValue(), null));
    }
    
    if(l2 ==null) {
      r.setNext(new ll(l1.getValue(), null));
    }
    
    return s;
  }
  
  private static void dups(ll node) {
    if(node == null) return;
    
    ll pre = node;
    ll cur = node.getNext();
    
    while(cur!=null) {
      if(pre.getValue() == cur.getValue()) {
        cur = cur.getNext();
      }else {
        pre = pre.getNext();
        cur = cur.getNext();
      }
      pre.setNext(cur);
      
    }
    
    
  }
  private static ll half(ll node) {
    ll half = null;
    ll p1 = node;
    ll p2 = node;

    while (p2 != null) {

      if (p2.getNext() != null)
        p2 = p2.getNext().getNext();

      if (p2 != null)
        p1 = p1.getNext();

    }

    if (p1 != null) {
      half = p1.getNext();
      p1.setNext(null);
    }

    return half;
  }

  private static void delete(ll node) {
    if (node != null) {
      ll next = node.getNext();
      node.setValue(0);
      node.setNext(null);
      System.gc();
      delete(next);
    }
  }

  private static int pop(ll node) {
    int temp = node.getValue();

    if (node.getNext() == null)
      node.setValue(0);
    else {
      node.setValue(node.getNext().getValue());
      node.setNext(node.getNext().getNext());
    }


    return temp;
  }

  private static int size(ll node) {
    int count = 0;
    while (node != null) {
      node = node.getNext();
      count++;
    }
    return count;
  }

  private static ll append(ll node, int data) {
    ll temp = node;
    if (temp == null) {
      return new ll(data, null);
    }
    while (temp.getNext() != null) {
      temp = temp.getNext();
    }
    temp.setNext(new ll(data, null));
    return node;
  }

  private static ll getN(ll node, int n) {
    int count = 0;
    while (node != null) {
      if (count == n)
        return node;
      node = node.getNext();
      count++;
    }
    return null;
  }

  private static ll reverse(ll root) {
    ll pre = null;
    ll cur = root;
    ll next = null;
    while (cur != null) {
      next = cur.getNext();
      cur.setNext(pre);
      pre = cur;
      cur = next;
    }
    return pre;
  }

  private static ll reverse(ll root, int k) {

    ll pre = null;
    ll cur = root;
    ll next = null;
    int n = 0;

    while (cur != null && n < k) {
      next = cur.getNext();
      cur.setNext(pre);
      pre = cur;
      cur = next;
      n++;
    }

    if (next != null) {
      root.setNext(reverse(next, k));
    }

    return pre;
  }

}
