package net.wentaochang.careercup;

import java.util.ArrayList;

public class RepresentingNCents {
	public static ArrayList<Integer[]> getRepresentingNCents(int n) {
		ArrayList<Integer[]> res = new ArrayList<Integer[]>();
		Integer[] solution = new Integer[4];
		for (int i = 0; i < 4; ++i) {
			solution[i] = new Integer(0);
		}
		if (n <= 0) {
			return res;
		}
		findSolution(n, solution, res, 3);
		return res;
	}

	//Level parameter to avoid duplicate results
	public static void findSolution(int remaining, Integer[] solution, ArrayList<Integer[]> res, int level) {
		if (remaining == 0) {
			Integer[] temp = new Integer[4];
			for (int i = 0; i < 4; ++i) {
				temp[i] = solution[i];
			}
			res.add(temp);
			return;
		}
		if (level >= 3 && remaining - 25 >= 0) {
			solution[0]++;
			findSolution(remaining - 25, solution, res, 3);
			solution[0]--;
		}
		if (level >= 2 && remaining - 10 >= 0) {
			solution[1]++;
			findSolution(remaining - 10, solution, res, 2);
			solution[1]--;
		}
		if (level >= 1 && remaining - 5 >= 0) {
			solution[2]++;
			findSolution(remaining - 5, solution, res, 1);
			solution[2]--;
		}
		if (level >= 0 && remaining - 1 >= 0) {
			solution[3]++;
			findSolution(remaining - 1, solution, res, 0);
			solution[3]--;
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer[]> res = getRepresentingNCents(35);
		for (Integer[] t : res) {
			for (Integer i : t) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
