package net.wentaochang.leetcode;

public class PalindromeNumber {
	//original == reverse
    public boolean isPalindrome(int x) {
        int reverse = 0;
        int original = x;
        while(x>0){
            reverse = reverse*10+x%10;
            x = x/10;
        }
        if(reverse == original){
            return true;
        }
        return false;
    }
}
