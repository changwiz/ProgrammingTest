package net.wentaochang.careercup;

public class SwapNumberInPlace {
	public static void swap(int a, int b) {
		System.out.println(a + " " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a + " " + b);
	}

	public static void main(String[] args) {
		swap(456, 231);
	}
}
