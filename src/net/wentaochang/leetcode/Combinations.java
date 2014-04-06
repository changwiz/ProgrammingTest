package net.wentaochang.leetcode;

import java.util.ArrayList;

public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		if (n < k)
			return null;
		ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
		if (k == 1) {
			for (int i = 1; i <= n; i++) {
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(i);
				all.add(al);
			}
			return all;
		}
		for (int i = n; i >= k; i--) {
			for (ArrayList<Integer> al : combine(i - 1, k - 1)) {
				al.add(i);
				all.add(al);
			}
		}
		return all;
	}
	
    public ArrayList<ArrayList<Integer>> combine2(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(k==0) return res;
        res.add(new ArrayList<Integer>());
        for(int i=0;i<k;i++){
             ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
             for(ArrayList<Integer> temp:res){
                int a=0;
                if(temp.size()>0)
                    a=temp.get(temp.size()-1);
                for(int j=a+1;j<=n-k+1+i;j++){
                    ArrayList<Integer> b= new ArrayList<Integer>(temp);
                    b.add(j);
                    prev.add(b);
                }
             }
            res = new ArrayList<ArrayList<Integer>>(prev);
        }
        return res;
    }
}
