package net.wentaochang.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return result;
		}
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		Deque<TreeNode> q = new ArrayDeque<TreeNode>();
		queue.add(root);
		boolean reverse = false;
		int curLevel = 1, nextLevel = 0;
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove(0);
			curLevel--;
			q.add(node);
			if (node.left != null) {
				queue.add(node.left);
				nextLevel++;
			}
			if (node.right != null) {
				queue.add(node.right);
				nextLevel++;
			}
			if (curLevel == 0) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				if (reverse) {
					while (!q.isEmpty()) {
						temp.add(q.removeLast().val);
					}
				} else {
					while (!q.isEmpty()) {
						temp.add(q.remove().val);
					}
				}
				result.add(temp);
				reverse = !reverse;
				curLevel = nextLevel;
				nextLevel = 0;
			}
		}
		return result;
	}
}
