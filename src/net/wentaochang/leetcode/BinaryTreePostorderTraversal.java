package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.Stack;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;


//Time limit exceeds, use a visited map and stack to track
public class BinaryTreePostorderTraversal {
/*	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		if (root == null) {
			return res;
		}
		TreeNode node = root;
		stack.push(node);

		while (node.left != null) {
			node = node.left;
			stack.push(node);
		}

		while (!stack.isEmpty()) {
			TreeNode temp = stack.peek();
			if (temp.right == null || visited.contains(temp.right)) {
				temp = stack.pop();
				res.add(temp.val);
				visited.add(temp);
			} else {
				temp = temp.right;
				stack.push(temp);
				while (temp.left != null) {
					temp = temp.left;
					stack.push(node);
				}
			}
		}
		return res;
	}*/
	
	// Non-trivial problem
	//Use another pointer prev
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null) {
			return res;
		}
		stack.push(root);
		TreeNode prev = null;
		while (!stack.empty()) {
			TreeNode curr = stack.peek();
			// we are traversing down the tree
			if (prev == null || prev.left == curr || prev.right == curr) {
				if (curr.left != null) {
					stack.push(curr.left);
				} else if (curr.right != null) {
					stack.push(curr.right);
				} else {
					res.add(curr.val);
					stack.pop();
				}
			}
			// we are traversing up the tree from the left
			else if (curr.left == prev) {
				if (curr.right != null) {
					stack.push(curr.right);
				} else {
					res.add(curr.val);
					stack.pop();
				}
			}
			// we are traversing up the tree from the right
			else if (curr.right == prev) {
				res.add(curr.val);
				stack.pop();
			}
			prev = curr; // record previously traversed node
		}
		return res;
	}
}
