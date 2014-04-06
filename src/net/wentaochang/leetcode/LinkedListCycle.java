package net.wentaochang.leetcode;

public class LinkedListCycle {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if(head == null) {
			return false;
		}
		ListNode next = head;
		boolean hasCycle = false;
		while(next != null){
			head = head.next;
			next = next.next;
			if(next != null) {
				next = next.next;
			}
			if(next != null && head == next) {
				hasCycle = true;
				break;
			}
		}
		return hasCycle;
	}
}
