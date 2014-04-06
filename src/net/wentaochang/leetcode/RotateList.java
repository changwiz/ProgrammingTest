package net.wentaochang.leetcode;

import net.wentaochang.leetcode.LinkedListCycle.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
		if (n <= 0 || head == null || head.next == null) {
			return head;
		}
		ListNode p1 = new ListNode(-1);
		p1.next = head;
		ListNode p2 = p1;
		for (int i = 0; i < n; ++i) {
			if (p1.next == null) {
				p1 = head;
			} else {
				p1 = p1.next;
			}
		}
		while (p1.next != null && p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		if (p2.next == head) {//Boundary case: no move at all
			return head;
		}
		p1.next = head;
		head = p2.next;
		p2.next = null;
		return head;
	}
}
