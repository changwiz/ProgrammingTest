package net.wentaochang.leetcode;

public class ValidNumber {
	//(1) space (2) negative sign (3) . (4) e10
    public boolean isNumber(String s) {
    	return s.matches("^\\s*[+-]?(\\d+|\\d*\\.\\d+|\\d+\\.\\d*)([eE][+-]?\\d+)?\\s*$");
    }
}
