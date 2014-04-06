package net.wentaochang.leetcode;

import java.util.ArrayList;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;

public class UniqueBinarySearchTreeII {
	public ArrayList<TreeNode> generateTrees(int n) {
		return dfs(1, n);
	}

	public ArrayList<TreeNode> dfs(int begin, int end) {
		ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
		if (begin > end) {
			ret.add(null);
			return ret;
		}

		for (int i = begin; i <= end; i++) {
			ArrayList<TreeNode> left = dfs(begin, i - 1);
			ArrayList<TreeNode> right = dfs(i + 1, end);

			for (int j = 0; j < left.size(); j++) {
				for (int k = 0; k < right.size(); k++) {
					TreeNode root = new TreeNode(i);
					root.left = left.get(j);
					root.right = right.get(k);
					ret.add(root);
				}
			}
		}
		return ret;
	}
}
