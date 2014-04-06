package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {
	class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		if(intervals == null || intervals.size() ==0){
			return res;
		}
		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start < o2.start) {
					return -1;
				} else if (o1.start > o2.start) {
					return 1;
				} else {
					if (o1.end < o2.end) {
						return -1;
					} else if (o1.end > o2.end) {
						return 1;
					} else {
						return 0;
					}
				}
			}

		});

		for (int i = 0; i < intervals.size(); i++) {
			Interval cur = intervals.get(i);
			if (res.isEmpty()) {
				res.add(cur);
			} else {
				Interval last = res.get(res.size() - 1);
				if (last.end >= cur.start) {
					last.end = Math.max(last.end, cur.end);
				} else {
					res.add(cur);
				}
			}
		}
		return res;
	}
}
