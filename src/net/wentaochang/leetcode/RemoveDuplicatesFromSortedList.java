package net.wentaochang.leetcode;

import net.wentaochang.leetcode.LinkedListCycle.ListNode;

public class RemoveDuplicatesFromSortedList {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode result = head;
		ListNode prev = head;
		ListNode cur = head.next;
		while (cur != null) {
			if (cur.val == prev.val) {
				cur = cur.next;
			} else {
				prev.next = cur;
				prev = cur;
				cur = cur.next;
			}
		}
		prev.next = null;
		return result;
	}
}
