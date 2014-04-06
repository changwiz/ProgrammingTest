package net.wentaochang.leetcode;

import java.util.ArrayList;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;

public class PathSumII {
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		dfs(root, sum, path, res);
		return res;
	}

	private void dfs(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
		if (root.left == null && root.right == null) {
			if (sum == root.val) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.addAll(path);
				temp.add(root.val);
				res.add(temp);
				return;
			} else {
				return;
			}
		}
		path.add(root.val);
		if (root.left != null) {
			dfs(root.left, sum - root.val, path, res);
		}
		if (root.right != null) {
			dfs(root.right, sum - root.val, path, res);
		}
		path.remove(path.size() - 1);
	}
}
