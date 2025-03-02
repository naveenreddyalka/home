package ok.metaprep;


public class ReverseNodesInKGroup {

  public static void main(String[] args) {

    ListNode one = new ListNode(1);
    ListNode two = new ListNode(2);
    ListNode three = new ListNode(3);
    ListNode four = new ListNode(4);
    ListNode five = new ListNode(5);
    one.next = two;
    two.next = three;
    three.next = four;
    four.next = five;
    ListNode reversed = reverseKGroup(one,1);

    while(reversed!=null){
      System.out.print(reversed.val + " ");
      reversed = reversed.next;
    }
  }

  public static ListNode reverseKGroup(ListNode head, int k) {
    if(head==null) return head;

    ListNode ks = null;
    ListNode return_start = null;
    ListNode ktail = null;

    while(head!=null){
      ks = head;
      int count =0;
      while(count<k && head!=null){
        head = head.next;
        count++;
      }

      if(count==k){

        // from ks to k nodes , need to reverse
        //ListNode reversed_head = null;
        ListNode pre = null;
        ListNode temp = null;
        ListNode curr = ks;

        for(int i=0; i<k;i++){
          temp = curr.next;
          curr.next = pre;
          pre = curr;
          curr = temp;
        }

        //pre is the new head of the reversed list
        if(return_start==null) return_start = pre;

        if(ktail!=null) ktail.next = pre;

        ktail = ks;
      }


    }
    if(ktail!=null && ktail!=ks) ktail.next = ks;
    return return_start == null ? head : return_start;
  }
}
