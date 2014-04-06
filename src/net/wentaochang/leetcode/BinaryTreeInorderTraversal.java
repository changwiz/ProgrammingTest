package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//very basic one
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null){
			return result;
		}
		inorder(root.left, result);
		result.add(root.val);
		inorder(root.right, result);
		return result;
	}
	
	private void inorder(TreeNode root, ArrayList<Integer> result) {
		if(root != null){
			inorder(root.left, result);
			result.add(root.val);
			inorder(root.right, result);
		}
	}
	
    public ArrayList<Integer> inorderTraversalIterative(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashSet<TreeNode> visited = new HashSet<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode tn = stack.peek();
            if(tn.left == null || visited.contains(tn)){
                res.add(tn.val);
                stack.pop();
                if(tn.right != null){
                    stack.push(tn.right);
                }
            } else {
                visited.add(tn);
                stack.push(tn.left);
            }
        }
        return res;
    }
}
