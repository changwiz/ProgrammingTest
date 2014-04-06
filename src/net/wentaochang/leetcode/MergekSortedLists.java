package net.wentaochang.leetcode;

import java.util.ArrayList;

import net.wentaochang.leetcode.LinkedListCycle.ListNode;

public class MergekSortedLists {
	//Time complexity O(n3), add a dummy source node
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		ListNode result = new ListNode(-1);
		result.next = lists.get(0);
		for (int i = 1; i < lists.size(); ++i) {
			ListNode source = result;
			ListNode target = lists.get(i);
			while (target != null && source.next != null) {
				if (target.val >= source.next.val) {
					source = source.next;
				} else {
					ListNode temp = target.next;
					target.next = source.next;
					source.next = target;
					target = temp;
				}
			}
			if (source.next == null) {
				source.next = target;
			}
		}
		return result.next;
	}
}
