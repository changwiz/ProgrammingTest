package net.wentaochang.leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0 || strs[0].length()==0){
            return "";
        }
        String max = strs[0];
        for(int i=1;i<strs.length;++i){
            String s = strs[i];
            int j;
            for(j=0;j<s.length()&&j<max.length();++j){
                if(s.charAt(j) != max.charAt(j)){
                    break;
                }
            }
            max = max.substring(0,j);
        }
        return max;
        
    }
}
