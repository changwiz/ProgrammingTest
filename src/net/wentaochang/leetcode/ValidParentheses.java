package net.wentaochang.leetcode;

import java.util.Stack;

public class ValidParentheses {
	//Use stack
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            if(isLeftP(c)){
                stack.add(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                Character t = stack.pop();
                if(!isMatch(t,c)){
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    private boolean isLeftP(Character c){
        if(c =='{' || c== '[' || c=='('){
            return true;
        }
        return false;
    }
    
    private boolean isMatch(Character l1, Character l2){
        if(l1 == '(' && l2 ==')' || l1 == '[' && l2 ==']' || l1 == '{' && l2 =='}'){
            return true;
        }
        return false;
    }
}
