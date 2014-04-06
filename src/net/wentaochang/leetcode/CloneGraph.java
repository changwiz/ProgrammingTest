package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class CloneGraph {
	class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};

	//Use recursion to clone, check whether the node is visited or not
	private HashMap<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		UndirectedGraphNode newNode;
		if (!nodeMap.containsKey(node.label)) {
			newNode = new UndirectedGraphNode(node.label);
			nodeMap.put(node.label, newNode);
		} else {
			newNode = nodeMap.get(node.label);
			return newNode;
		}

		for (UndirectedGraphNode n : node.neighbors) {
			UndirectedGraphNode temp = cloneGraph(n);
			newNode.neighbors.add(temp);
		}
		return newNode;
	}
}
