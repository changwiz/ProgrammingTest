package net.wentaochang.leetcode;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1 == null || num2 == null || "0".equalsIgnoreCase(num1) || "0".equalsIgnoreCase(num2)) {
			return "0";
		}
		// convert num1 to int array
		int[] num11 = new int[num1.length()];
		for (int i = 0; i < num1.length(); ++i) {
			num11[i] = num1.charAt(num1.length() - 1 - i) - '0';
		}

		// convert num2 to int array
		int[] num22 = new int[num2.length()];
		for (int i = 0; i < num2.length(); ++i) {
			num22[i] = num2.charAt(num2.length() - 1 - i) - '0';
		}

		int[] result = new int[num1.length() + num2.length()];
		for (int i = 0; i < num11.length; ++i) {
			for (int j = 0; j < num22.length; ++j) {
				int temp = num11[i] * num22[j] + result[i + j];
				result[i + j] = temp % 10;
				result[i + j + 1] += temp / 10;
			}
		}
		boolean isLeadingZero = true;
		StringBuilder builder = new StringBuilder();
		for (int i = result.length - 1; i >= 0; i--) {
			if(result[i] != 0 || isLeadingZero == false){
				isLeadingZero = false;
				builder.append(result[i]);
			}
		}
		return builder.toString();
	}
}
