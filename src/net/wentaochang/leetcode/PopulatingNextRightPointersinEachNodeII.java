package net.wentaochang.leetcode;

public class PopulatingNextRightPointersinEachNodeII {
	static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
	    while (root!=null) {
	        TreeLinkNode next = null; // the first node of next level
	        TreeLinkNode prev = null; // previous node on the same level
	        for (; root!=null; root=root.next) {
	            if (next==null) next = root.left != null?root.left:root.right;

	            if (root.left!=null) {
	                if (prev!=null) prev.next = root.left;
	                prev = root.left;
	            }
	            if (root.right != null) {
	                if (prev!=null) prev.next = root.right;
	                prev = root.right;
	            }
	        }
	        root = next; // turn to next level
	    }        
}

}
