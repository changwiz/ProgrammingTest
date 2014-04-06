package net.wentaochang.leetcode;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		return dfs(root, sum);
	}

	private boolean dfs(TreeNode root, int sum) {
		if (root.left == null && root.right == null) {
			if (sum == root.val) {
				return true;
			} else {
				return false;
			}
		}
		boolean result = false;
		if (root.left != null) {
			result = dfs(root.left, sum - root.val);
		}
		if (root.right != null) {
			result = result || dfs(root.right, sum - root.val);
		}
		return result;
	}
}
