package ok.demo.array;

public class AddTwoNumbers {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(4);
		l2.next = new ListNode(5);
		l2.next.next = new ListNode(6);

		ListNode l3 = addTwoNumbers(l1, l2);
		
		System.out.println(l3);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int carry = 0;
		ListNode root = new ListNode(0);
		
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;
		
		ListNode pre = root;
		
		while (l1 != null || l2 != null) {
			
			ListNode l3 = new ListNode(0);
			
			int cur = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
			
			if (cur >= 10) {
				l3.val = cur % 10;
				carry = 1;
			} else {
				l3.val = cur;
				carry = 0;
			}
			
			pre.next = l3;
			pre = pre.next;
			
			l1 = (l1==null)?null:l1.next;
			l2 = (l2==null)?null:l2.next;
		}
		
		if(carry>0) {
			pre.next = new ListNode(1);
		}
		
		return root.next;
	}
}
