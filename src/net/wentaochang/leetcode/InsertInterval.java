package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import net.wentaochang.leetcode.MergeIntervals.Interval;

public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    	intervals.add(newInterval);
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
		ArrayList<Interval> res = new ArrayList<Interval>();
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
