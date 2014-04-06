package net.wentaochang.leetcode;
public class RemoveDuplicatesFromSortedListII {
	private class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = new ListNode(-1);
		prev.next = head;
		ListNode cur = head;
		ListNode next = head.next;
		ListNode result = prev;
		boolean flag = false;
		while (next != null) {
			if (cur.val == next.val) {
				next = next.next;
				flag = true;
			} else {
				if (!flag) {
					prev = cur;
				} else {
					prev.next = next;
				}
				cur = next;
				next = next.next;
				flag = false;
			}
		}
		if (flag) {
			prev.next = null;
		}
		return result.next;
	}
}
