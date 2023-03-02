/******************************************************************************************************************************************************

There is a row of N walls in Geeksland. The king of Geeksland ordered Alexa to color all the walls on the occasion of New Year. Alexa can color each wall with
one of the K colors. The cost associated with coloring each wall with a particular color is represented by a 2D costs array of size N * K. For example, 
costs[0][0] is the cost of coloring wall 0 with color 0; costs[1][2] is the cost of coloring wall 1 with color 2, and so on... Find the minimum cost to color 
all the walls such that no two adjacent walls have the same color.
Note: If you are not able to paint all the walls, then you should return -1.

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 4, K = 3
costs[][] = {{1, 5, 7},
             {5, 8, 4},
             {3, 2, 9},
             {1, 2, 4}}

Output:
8
Explanation:
Paint wall 0 with color 0. Cost = 1
Paint wall 1 with color 2. Cost = 4
Paint wall 2 with color 1. Cost = 2
Paint wall 3 with color 0. Cost = 1
Total Cost = 1 + 4 + 2 + 1 = 8
Example 2:

Input:
N = 5, K = 1
costs[][] = {{5},
             {4},
             {9},
             {2},
             {1}}
Output:
-1
Explanation:
It is not possible to color all the walls under the given conditions.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

Approach-2
-------------------------
  
//User function Template for Java

class Solution{
	int minCost(int [][] costs) {
		 int[][] dp = new int[costs.length][costs[0].length];

 for (int i = 0; i < costs[0].length; i++) {

 dp[0][i] = costs[0][i];

 }

 

 for (int i = 1; i < costs.length; i++) {

 for (int j = 0; j < costs[0].length; j++) {

 int paint = costs[i][j];

 int min = Integer.MAX_VALUE;

 for (int k = 0; k < costs[0].length; k++) {

 if (k != j) {

 min = Math.min(min, dp[i-1][k]);

 }

 }

 if(min == Integer.MAX_VALUE){

     return -1;

 }

 dp[i][j] = min + paint;

 }

 }

 int min_value = Integer.MAX_VALUE;

 for (int i = 0; i < costs[0].length; i++) {

 min_value = Math.min(dp[costs.length - 1][i], min_value);

 }

 return min_value;
	}
}
