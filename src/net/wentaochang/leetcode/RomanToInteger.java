package net.wentaochang.leetcode;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<String,Integer> value = new HashMap<String,Integer>();
        value.put("I",1);
        value.put("V",5);
        value.put("X",10);
        value.put("L",50);
        value.put("C",100);
        value.put("D",500);
        value.put("M",1000);
        int length = s.length();
        int sum = value.get(s.substring(length-1,length));
        for(int i=length-2;i>=0;i--){
            int last = value.get(s.substring(i+1,i+2));
            int v = value.get(s.substring(i,i+1));
            if(v<last){
                sum -= v;
            } else {
                sum += v;
            }
        }
        return sum;
        
    }
}
