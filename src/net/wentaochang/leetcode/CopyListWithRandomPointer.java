package net.wentaochang.leetcode;

import java.util.HashMap;

public class CopyListWithRandomPointer {
	static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		RandomListNode node = null;
		if (!map.containsKey(head.label)) {
			node = new RandomListNode(head.label);
			map.put(head.label, node);
		} else {
			node = map.get(head.label);
			return node;
		}

		if (head.next != null) {
			node.next = copyRandomList(head.next);
		}
		if (head.random != null) {
			node.random = copyRandomList(head.random);
		}
		return node;

	}
}
