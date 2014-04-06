package net.wentaochang.leetcode;

import net.wentaochang.leetcode.LinkedListCycle.ListNode;

public class SortList {
	public ListNode sortList(ListNode head) {
		// 链表归并排序
		if (head == null || head.next == null)
			return head;
		else {
			// 快慢指针找到中间节点
			ListNode fast = head, slow = head;
			while (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			fast = slow;
			slow = slow.next;
			fast.next = null;
			fast = sortList(head);// 前半段排序
			slow = sortList(slow);// 后半段排序
			return merge(fast, slow);
		}

	}

	// merge two sorted list to one
	ListNode merge(ListNode head1, ListNode head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		ListNode res, p;
		if (head1.val < head2.val) {
			res = head1;
			head1 = head1.next;
		} else {
			res = head2;
			head2 = head2.next;
		}
		p = res;

		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				p.next = head1;
				head1 = head1.next;
			} else {
				p.next = head2;
				head2 = head2.next;
			}
			p = p.next;
		}
		if (head1 != null)
			p.next = head1;
		else if (head2 != null)
			p.next = head2;
		return res;
	}
}
