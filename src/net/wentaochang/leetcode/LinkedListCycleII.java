package net.wentaochang.leetcode;

import net.wentaochang.leetcode.LinkedListCycle.ListNode;

public class LinkedListCycleII {
	//Time limits exceed, calculate count, then move next pointer count steps.
	/*public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode node = head;
		ListNode next = head;
		int count = 0;
		while (next != null) {
			node = node.next;
			next = next.next;
			count++;
			if (next != null) {
				next = next.next;
			}
			if (next != null && node == next) {
				break;
			}
		}
		if (next == null) {
			return null;
		}
		node = head;
		next = head;
		while (next != null) {
			node = node.next;
			next = next.next;
			for (int i = count; i >= 0; i--) {
				next = next.next;
			}
			if (node == next) {
				break;
			}
		}
		return node;
	}*/
	
	// t = x + my +k  2t= x + ny + k => x + k = (n-2m)y, x,k complement
	public ListNode detectCycle(ListNode head) {
		ListNode first = head;
		ListNode second = head;

		while (first != null && second != null) {
			first = first.next;
			second = second.next;
			if (second != null)
				second = second.next;
			if (first == second)
				break;
		}

		if (second == null)
			return null;

		// 一起往下走X步，就找到节点了。
		first = head;
		while (first != second) {
			first = first.next;
			second = second.next;
		}

		return second;
	}
}
