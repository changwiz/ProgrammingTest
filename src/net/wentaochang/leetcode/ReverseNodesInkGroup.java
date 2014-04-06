package net.wentaochang.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

import net.wentaochang.leetcode.LinkedListCycle.ListNode;

public class ReverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		if (k <= 1) {
			return head;
		}
		ListNode newHead = new ListNode(-1);
		newHead.next = head;
		ListNode node1 = newHead;
		ListNode node2 = head;
		while (node2 != null) {
			ListNode temp = node2;
			boolean leftout = false;
			for (int i = 0; i < k - 1; ++i) {
				temp = temp.next;
				if (temp == null) {
					leftout = true;
					break;
				}
			}
			if (leftout) {
				break;
			}

			// Reverse the list
			Deque<ListNode> stack = new ArrayDeque<ListNode>();
			stack.push(node2);
			temp = node2;
			for (int i = 0; i < k - 1; ++i) {
				temp = temp.next;
				stack.push(temp);
			}
			node1.next = stack.pop();
			ListNode last = node1.next.next;
			temp = node1.next;
			while (temp != null) {
				if(stack.size() != 0){
					temp.next = stack.pop();
				} else {
					temp.next = null;
				}
				temp = temp.next;
			}
			node1 = node2;
			node2.next = last;
			node2 = node2.next;
		}
		return newHead.next;
    }
}
