/******************************************************************************************************************************************************
--------------------------------------
Level- Medium
-------------------------------------
N horizontal line segments are arranged on the X-axis of a 2D plane. The start and end point of each line segment is given in a Nx2 matrix lines[ ][ ].
Your task is to find the maximum number of intersections possible of any vertical line with the given N line segments.

___________________________________________________________________________________________________

Example 1:

Input:
N = 4
lines[][] = {{1,3}, {2,3}, {1,2}, {4,4}}
Output:
3
Explanation:
A vertical line at X = 2 passes through 
{1,3}, {2,3}, {1,2}, ie three of the 
given horizontal lines.
Example 2:

Input: 
N = 3
lines[][] = {{1, 3}, {5, 6}, {3,4}}
Output:
2
Explanation: 
A vertical line at X = 3 passes through 
two of the given horizontal lines which 
is the maximum possible.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

// User function Template for Java

class Solution {
    public int maxIntersections(int[][] lines, int N) {
        // Code here
          Map<Integer, Integer> endpoints = new TreeMap<>();

        // Add the endpoints of each line segment to the TreeMap.
        
        for (int[] line : lines) {
            // If the start point of the line segment is already in the TreeMap,
            // increment its value by 1. Otherwise, add it to the TreeMap with a
            // value of 1.
            
            endpoints.put(line[0], endpoints.getOrDefault(line[0], 0) + 1);
    
            // If the end point of the line segment is already in the TreeMap,
            // decrement its value by 1. Otherwise, add it to the TreeMap with a
            // value of -1.
            endpoints.put(line[1] + 1, endpoints.getOrDefault(line[1] + 1, 0) - 1);
        }
    
        // Calculate the maximum number of intersections by iterating over the values
        // in the TreeMap and summing them up.
        
        int intersections = 0;
        int activeLines = 0;
        for (int count : endpoints.values()) {
            activeLines += count;
            intersections = Math.max(intersections, activeLines);
        }
    
        // Return the maximum number of intersections.
        
        return intersections;
        }
}
