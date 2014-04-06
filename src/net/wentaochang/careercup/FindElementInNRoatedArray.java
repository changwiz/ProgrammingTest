package net.wentaochang.careercup;

public class FindElementInNRoatedArray {
	public static int search(int[] a, int x) {
		return search(a, 0, a.length - 1, x);
	}

	private static int search(int[] a, int l, int r, int x) {
		if (l > r) {
			return -1;
		}
		int mid = l + (r - l) / 2;
		if (x == a[mid]) {
			return mid;
		} else if (x < a[mid]) {
			if (a[mid] <= a[r] || x >= a[l]) {
				return search(a, l, mid - 1, x);
			} else {
				return search(a, mid + 1, r, x);
			}
		} else {
			if(a[l] <= a[mid] || x <= a[r]){
				return search(a, mid + 1, r, x);
			} else {
				return search(a, l, mid - 1, x);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(search(new int[]{1,2,4,5,7}, 7));
	}
}
