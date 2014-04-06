package net.wentaochang.leetcode;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
	//O(n*n)
	/*public int largestRectangleArea(int[] height) {
		int maxV = 0;
		for (int i = 0; i < height.length; i++) {
			int minV = height[i];
			for (int j = i; j >= 0; j--) {
				minV = Math.min(minV, height[j]);
				int area = minV * (i - j + 1);
				if (area > maxV)
					maxV = area;
			}
		}
		return maxV;
	}*/
	
	//O(n*n)
   /* public int largestRectangleArea(int[] height) {
        int maxArea = 0;
        int []min = new int[height.length];
        for(int i=0;i<height.length;++i){
            if(height[i] ==0 || maxArea/height[i] > height.length-i){
                continue;
            }
            for(int j=i;j<height.length;++j){
                if(j==i){
                    min[j] = height[j];
                }else {
                    if(height[j]<min[j-1]){
                        min[j] = height[j];
                    } else {
                        min[j] = min[j-1];
                    }
                }
                int area = min[j] *(j-i+1);
                if(area>maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }*/
    
	//O(n) http://www.cnblogs.com/lichen782/p/leetcode_Largest_Rectangle_in_Histogram.html
	public int largestRectangleArea(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		int[] h = new int[height.length + 1];
		h = Arrays.copyOf(height, height.length + 1);
		while (i < h.length) {
			if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i++);
			} else {
				int t = stack.pop();
				maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		return maxArea;
	}
}
