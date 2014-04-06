package net.wentaochang.leetcode;

import java.util.HashMap;

public class TwoSum {

	//Pay attention, this one needs to return original index, so we use map.
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer>map = new HashMap<Integer,Integer>();
        int []result = new int[2];
        for(int i=0;i<numbers.length;++i){
            int value = numbers[i];
            if(map.containsKey(target - value)){
                result[0] = i + 1;
                result[1] = map.get(target - value).intValue();
                if(result[0] > result[1]){
                	int temp = result[0];
                	result[0] = result[1];
                	result[1] = temp;
                }
                return result;
            } else {
                map.put(value, i+1);
            }
        }
        return result;
    }
}
