package net.wentaochang.leetcode;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;
import net.wentaochang.leetcode.LinkedListCycle.ListNode;

public class ConvertSortedListToBinarySearchTree {
	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		int length = 1;
		ListNode node = head;
		while (node.next != null) {
			length++;
			node = node.next;
		}

		return buildTree(head, length);
	}

	//Pay attention, pointer changes in each recursion
	private static TreeNode buildTree(ListNode head, int length) {
		if (length == 0 || head == null) {
			return null;
		}
		if (length == 1) {
			return new TreeNode(head.val);
		}
		ListNode node = head;
		int count = length / 2;
		while (count != 0) {
			node = node.next;
			count--;
		}
		boolean even = length % 2 == 0;
		TreeNode root = new TreeNode(node.val);
		root.left = buildTree(head, length / 2);
		root.right = buildTree(node.next, even ? (length / 2 - 1) : (length / 2));
		return root;
	}
	
	public static void main(String[] args){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(3);
		a.next = b;
		TreeNode t = sortedListToBST(a);
		System.out.println(t.val);
	}
}
