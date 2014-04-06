package net.wentaochang.leetcode;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;

public class BinaryTreeMaximumPathSum {
	private int maxPathSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		max(root);
		return maxPathSum;

	}

	private int max(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = Math.max(max(root.left), 0);
		int right = Math.max(max(root.right), 0);
		int sum = root.val + left + right;
		if (maxPathSum < sum) {
			maxPathSum = sum;
		}
		return sum;
	}
}
