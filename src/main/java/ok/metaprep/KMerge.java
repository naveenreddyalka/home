package ok.metaprep;

import java.util.List;

class KLinkedList {
  public LinkedListNode head;
  // LinkedList() will be used to make a LinkedList type object.
  public KLinkedList() {
    this.head = null;
  }
  // insert_node_at_head method will insert a LinkedListNode at head
  // of a linked list.
  public void insertNodeAtHead(LinkedListNode node) {
    if (this.head == null) {
      this.head = node;
    } else {
      node.next = this.head;
      this.head = node;
    }
  }
  // create_linked_list method will create the linked list using the
  // given integer array with the help of InsertAthead method.
  public void createLinkedList(List<Integer> lst) {
    for (int i = lst.size() - 1; i >= 0; i--) {
      LinkedListNode newNode = new LinkedListNode(lst.get(i));
      insertNodeAtHead(newNode);
    }
  }
}

class LinkedListNode {
  public int data;
  public LinkedListNode next;
  // LinkedListNode() will be used to make a LinkedListNode type object.
  public LinkedListNode(int data) {
    this.data = data;
    this.next = null;
  }
}

public class KMerge {

  public static LinkedListNode merge2Lists(LinkedListNode head1, LinkedListNode head2) {
    LinkedListNode dummy = new LinkedListNode(-1);
    LinkedListNode prev = dummy;

    while (head1 != null && head2 != null) {
      if (head1.data<= head2.data) {
        prev.next = head1;
        head1 = head1.next;
      } else {
        prev.next = head2;
        head2 = head2.next;
      }
      prev = prev.next;
    }

    if (head1 == null)
      prev.next = head2;
    else
      prev.next = head1;

    return dummy.next;
  }

  // Main function
  public static LinkedListNode mergeKLists(List<KLinkedList> lists) {
    if (lists.size() > 0) {
      int step = 1;
      while(step < lists.size())
      {
        for(int i = 0; i < lists.size() - step;  i += step * 2)
        {
          lists.get(i).head =  merge2Lists(lists.get(i).head, lists.get(i + step).head);
        }
        step *= 2;
      }
      return lists.get(0).head;
    }
    else
      return null;

  }

}
