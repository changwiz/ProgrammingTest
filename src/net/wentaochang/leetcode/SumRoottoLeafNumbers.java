package net.wentaochang.leetcode;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;

public class SumRoottoLeafNumbers {
	private int total;

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			total = 0;
		}
		dfs(root, 0);
		return total;
	}

	private void dfs(TreeNode root, int num) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			total += num * 10 + root.val;
			return;
		}
		dfs(root.left, num * 10 + root.val);
		dfs(root.right, num * 10 + root.val);
	}
}
