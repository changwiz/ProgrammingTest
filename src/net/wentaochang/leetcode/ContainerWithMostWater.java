package net.wentaochang.leetcode;

public class ContainerWithMostWater {
	//use heuristic, O(n) solution
    public int maxArea(int[] height) {
        //ai aj i<j    (j-i)*min(ai,aj)
        int max = 0;
        int length = height.length;
        int start = 0;
        int end = length -1;
        while(start<end){
            int area = (end-start)*Math.min(height[start],height[end]);
            if(area>max){
                max = area;
            }
            if(height[start]<height[end]){
                start++;
            }else {
                end--;
            }
        }
        
        return max;
    }
}
