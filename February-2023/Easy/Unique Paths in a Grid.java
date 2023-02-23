/******************************************************************************************************************************************************

You are given a matrix grid of n x  m size consisting of values 0 and 1. A value of 1 means that you can enter that cell and 0 implies that entry to that cell is
not allowed.

You start at the upper-left corner of the grid (1, 1) and you have to reach the bottom-right corner (n, m) such that you can only move in the right or down direction
from every cell.

Your task is to calculate the total number of ways of reaching the target modulo (109+7).
Note: The first (1, 1) and last cell (n, m) of the grid can also be 0

---------------------------------------------------------------------------------------

Example 1:

Input:
n = 3, m = 3
grid[][] = {{1, 1, 1};
            {1, 0, 1};
            {1, 1, 1}}
Output:
2
Explanation:
1 1 1
1 0 1
1 1 1
This is one possible path.
1 1 1
1 0 1
1 1 1
This is another possible path.
Example 2:

Input:
n = 1, m = 3
grid = {{1, 0, 1}}
Output :
0
Explanation:
There is no possible path to reach the end.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution {
    static final int mod=1000000007;
    
    static int recurse(int i,int j,int n,int m,int[][]arr,int[][]dp)
    {
        //Base Cases
        
        // If We Get Out Of The Array, We Return 0
        if(i>n || j>m || arr[i][j]==0)
            return 0;
        
        // If We Reach The Last Cell, We Return 1 As In 1 Way To Reach Last Cell Found
        if(i==n && j==m)
            return 1;
            
        // If DP Array At Current Cell Doesn't Have A Default Value, It Means We Can Use The Previous Result
        if(dp[i][j]!=-1)
            return (dp[i][j])%mod;
        
        // If Not, We Store The Current Result In The DP Array
        dp[i][j] = (recurse(i,j+1,n,m,arr,dp)+recurse(i+1,j,n,m,arr,dp))%mod;
        
        return (dp[i][j])%mod;
    }
    
    static int uniquePaths(int n, int m, int[][] grid) {
        
        // If First Or Last Cell Is 0, Meaning We Can't Reach The Last Cell, So Return 0 Ways
        if(grid[0][0]==0 || grid[n-1][m-1]==0)
            return 0;
        
        // Initializing 2D DP Array
        int dp[][]=new int[n+1][m+1];
        
        // Filling DP Array With -1 Default Value 
        for(int[]temp:dp)
            Arrays.fill(temp,-1);
        
        // Returning The Answer From Recurse Function
        return (recurse(0,0,n-1,m-1,grid,dp))%mod;
        
    }
};
