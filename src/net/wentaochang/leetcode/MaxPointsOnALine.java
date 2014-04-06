package net.wentaochang.leetcode;

import java.util.ArrayList;
import java.util.Collections;

public class MaxPointsOnALine {
	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	//HARD question
	//for each point i in the plane:
	 //   for each point j in the plane:
	  //        if i!=j,
	  //           Compute and store the slop
	  //  Sort the slop array
	  //  Count how many slops are the same
	  //  Store the max number
	//Boundary case: (1) vertical lines (2) duplicate points
	
    public int maxPoints(Point[] points) {
        int n = points.length; //number of the points
        if (n<=2){return n;}   
        ArrayList<Double> k = new ArrayList<Double>(); //vector to store the slops for one point with all the other points
        int res = 0;
         
        for (int i=0;i<n;i++){ // for each point in the 2d plane
            k.clear();
            int dup = 1; // number of the duplicates with current point
            for (int j=0;j<n;j++){ 
                if (i!=j){ // for every other point
                    if (points[i].x-points[j].x==0){ // if the slope is a vertical line
                        if (points[i].y-points[j].y==0){ // if the point j is the same as point i
                            dup++;  //duplicates
                        }else{
                            k.add((double) 99999); //store the vertical line to a specific slope
                        }
                    }else{ // if it is the regular slop between point i and j
                        k.add((double) (10000*(points[i].y-points[j].y)/(points[i].x-points[j].x))); // store the slope
                    }
                }
            }
             
            Collections.sort(k); //sort the slopes for counting
             
            int pp = 1; //number of points in the same line of the point i
            if (k.size()==0){pp=0;} 
 
            for (int jj=1;jj<k.size();jj++){ //count pp
                if (Double.compare(k.get(jj) , k.get(jj-1)) ==0){
                    pp++;
                }else{
                    if (pp+dup>res){res=pp+dup;} // res = pp + the number of duplicates
                    pp = 1;
                }
            }
            if (pp+dup>res){res = pp+dup;} // in case the second branch is never reached
        }
 
        return res;
    }
}
