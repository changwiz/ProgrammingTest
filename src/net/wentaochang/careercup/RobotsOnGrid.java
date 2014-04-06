package net.wentaochang.careercup;

import java.util.ArrayList;

public class RobotsOnGrid {
	public static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static ArrayList<ArrayList<Point>> getAllPath(int m, int n) {
		ArrayList<ArrayList<Point>> result = new ArrayList<ArrayList<Point>>();
		if (m <= 0 || n <= 0) {
			return result;
		}
		ArrayList<Point> path = new ArrayList<Point>();
		hasPath(0, 0, m, n, path, result);
		return result;
	}

	private static void hasPath(int x, int y, int m, int n, ArrayList<Point> path, ArrayList<ArrayList<Point>> result) {
		if (x > m - 1 || y > n - 1) {
			return;
		}
		Point p = new Point(x, y);
		path.add(p);
		if (x == m - 1 && y == n - 1) {
			result.add((ArrayList<Point>) path.clone());
			path.remove(path.size() - 1);
			return;
		}
		if (x <= m - 1) {
			hasPath(x + 1, y, m, n, path, result);
		}
		if (y <= n - 1) {
			hasPath(x, y + 1, m, n, path, result);
		}
		path.remove(path.size() - 1);
	}

	public static void main(String[] args) {
		for (ArrayList<Point> path : getAllPath(2, 2)) {
			for (Point p : path) {
				System.out.print("(" + p.x + "," + p.y + ")");
			}
			System.out.println();
		}
	}
}
