package net.wentaochang.leetcode;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;

public class ConvertSortedArrayToBinaryTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num != null && num.length != 0) {
			return buildNode(num, 0, num.length - 1);
		}
		return null;
	}

	private TreeNode buildNode(int[] num, int st, int ed) {
		if (st > ed) {
			return null;
		}
		int mid = st + (ed - st) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = buildNode(num, st, mid - 1);
		root.right = buildNode(num, mid + 1, ed);
		return root;
	}
}
