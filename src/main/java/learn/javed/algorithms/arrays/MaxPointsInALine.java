package learn.javed.algorithms.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

 

Example 1:


Input: points = {{1,1},{2,2},{3,3}}
Output: 3
Example 2:


Input: points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}
Output: 4
 

Constraints:

1 <= points.length <= 300
points[i].length == 2
-104 <= xi, yi <= 104
All the points are unique.
 * @author javedattar
 *
 */
public class MaxPointsInALine {


	public static void main(String[] args) {
		int[][] points = new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
		System.out.println("Expected 4 points, Actual "+ maxPoints(points));
		points = new int[][]{{1,1},{2,2},{3,3}};
		System.out.println("Expected 3 points, Actual "+ maxPoints(points));

	}

	
	public static int maxPoints(int[][] points) {
        // if slope between two points is same then they are on same line
        int maxPoints = 1;
        Map<Double, Integer> slopes = new HashMap<>();
        for(int i=0; i< points.length; i++) {
            int duplicates = 0;
            for(int j=0; j< points.length; j++) {
                if(i == j) {
                    duplicates +=1;
                    continue;
                }
                int x1 = points[i][0];
                int x2 = points[j][0];
                int y1 = points[i][1];
                int y2 = points[j][1];
                
                Double slope = Double.MAX_VALUE;
                if(x1!=x2)
                    slope = Double.valueOf((double)(y1-y2) / (double)(x1-x2));
                
                slopes.put(slope, slopes.getOrDefault(slope, 0)+1);
            // System.out.println(slopes);
            for(Map.Entry<Double, Integer> item: slopes.entrySet()) {
                maxPoints = Math.max(maxPoints, item.getValue()+duplicates);
            }
            }
            slopes.clear();
        }
        return maxPoints;
    }
}
