package net.wentaochang.careercup;

import java.util.Random;

public class Rand7 {
	public static int rand7() {
		while (true) {
			int n = 5 * (rand5() - 1) + rand5() - 1;
			if (n < 21) {
				return n % 7 + 1;
			}
		}
	}

	private static int rand5() {
		Random r = new Random();
		return 1 + r.nextInt(5);
	}
}
