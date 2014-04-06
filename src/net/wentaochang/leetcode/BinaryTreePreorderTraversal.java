package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//Remember iterative approach, push root and all left nodes first
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = root;
		stack.push(node);
		res.add(root.val);
		while (node.left != null) {
			node = node.left;
			stack.push(node);
			res.add(node.val);
		}
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			if (temp.right != null) {
				temp = temp.right;
				stack.push(temp);
				res.add(temp.val);
				while (temp.left != null) {
					temp = temp.left;
					stack.push(temp);
					res.add(temp.val);
				}
			}

		}
		return res;
	}
}
