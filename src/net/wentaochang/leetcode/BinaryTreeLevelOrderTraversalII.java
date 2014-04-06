package net.wentaochang.leetcode;

import java.util.ArrayList;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;

public class BinaryTreeLevelOrderTraversalII {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return res;
		}
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		int currentLevel = 1;
		int nextLevel = 0;
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.remove(0);
			path.add(node.val);
			currentLevel--;

			if (node.left != null) {
				queue.add(node.left);
				nextLevel++;
			}
			if (node.right != null) {
				queue.add(node.right);
				nextLevel++;
			}
			if (currentLevel == 0) {
				res.add((ArrayList<Integer>) path.clone());
				path.clear();
				currentLevel = nextLevel;
				nextLevel = 0;
			}

		}
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		for (int i = res.size() - 1; i >= 0; i--) {
			ret.add(res.get(i));
		}
		return ret;
	}
}
