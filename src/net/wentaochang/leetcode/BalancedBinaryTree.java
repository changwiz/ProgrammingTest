package net.wentaochang.leetcode;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if (height(root) != -1) {
			return true;
		}
		return false;
	}

	private int height(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;

	}
}
