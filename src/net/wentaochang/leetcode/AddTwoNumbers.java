package net.wentaochang.leetcode;

public class AddTwoNumbers {
	//Don't forget carry, while(l1!=null||l2!=null||carry!=0)
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null, head = null;
		int carry = 0;
		if (l1 == null && l2 == null) {
			return new ListNode(0);
		}
		while (l1 != null || l2 != null || carry != 0) {
			ListNode newNode = new ListNode(0);
			if (result != null) {
				result.next = newNode;
			} else {
				head = newNode;
			}
			result = newNode;
			int num1 = l1 != null ? l1.val : 0;
			int num2 = l2 != null ? l2.val : 0;
			int temp = num1 + num2 + carry;
			result.val = temp % 10;
			carry = temp / 10;
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}
		return head;
	}
}
