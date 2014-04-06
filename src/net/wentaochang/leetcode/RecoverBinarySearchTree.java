package net.wentaochang.leetcode;


public class RecoverBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	//O(n) solution: in order traversal to get the array, find the first and second misplaced node, swap value
/*    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<TreeNode> res = inOrderTraversal(root, arr);
        Collections.sort(arr);
        for(int i=0;i<res.size();++i){
            TreeNode node = res.get(i);
            node.val = arr.get(i);
        }
    }
    
    private ArrayList<TreeNode> inOrderTraversal(TreeNode root, ArrayList<Integer> arr){
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        if(root == null){
            return res;
        }
        res.addAll(inOrderTraversal(root.left, arr));
        arr.add(root.val);
        res.add(root);
        res.addAll(inOrderTraversal(root.right, arr));
        return res;
        
    }
    */
	/*O(1)Threaded binary tree -> HARD PROBLEM
	Inorder traverse, keep the previous tree node,
	Find first misplaced node by
	if ( current.val < prev.val )
	   Node first = prev;

	Find second by
	if ( current.val < prev.val )
	   Node second = current;
	   Swap the value*/
	public void recoverTree(TreeNode root) {
		TreeNode f1 = null, f2 = null;
		TreeNode current, pre, parent = null;

		if (root == null) {
			return;
		}
		boolean found = false;
		current = root;
		while (current != null) {
			if (current.left == null) {
				if (parent != null && parent.val > current.val) {
					if (!found) {
						f1 = parent;
						found = true;
					}
					f2 = current;
				}
				parent = current;
				current = current.right;
			} else {
				/* Find the inorder predecessor of current */
				pre = current.left;
				while (pre.right != null && pre.right != current)
					pre = pre.right;

				/* Make current as right child of its inorder predecessor */
				if (pre.right == null) {
					pre.right = current;
					current = current.left;
				}

				/*
				 * Revert the changes made in if part to restore the original
				 * tree i.e., fix the right child of predecssor
				 */
				else {
					pre.right = null;
					if (parent.val > current.val) {
						if (!found) {
							f1 = parent;
							found = true;
						}
						f2 = current;
					}
					parent = current;
					current = current.right;
				} /* End of if condition pre->right == NULL */
			} /* End of if condition current->left == NULL */
		} /* End of while */

		if (f1 != null && f2 != null) {
			int temp = f1.val;
			f1.val = f2.val;
			f2.val = temp;
		}
	}
}
