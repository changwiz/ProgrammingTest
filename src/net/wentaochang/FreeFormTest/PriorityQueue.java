package net.wentaochang.FreeFormTest;

import java.util.Comparator;

public class PriorityQueue {
	public static void main(String[] args) {
		Comparator<String> comparator = new StringLengthComparator();
		java.util.PriorityQueue<String> queue = new java.util.PriorityQueue<String>(10, comparator);
		queue.add("short");
		queue.add("very long indeed");
		queue.add("medium");
		while (queue.size() != 0) {
			System.out.println(queue.remove());
		}
	}

	public static class StringLengthComparator implements Comparator<String> {
		@Override
		public int compare(String x, String y) {
			// Assume neither string is null. Real code should
			// probably be more robust
			if (x.length() < y.length()) {
				return -1;
			}
			if (x.length() > y.length()) {
				return 1;
			}
			return 0;
		}
	}

}
