/******************************************************************************************************************************************************
---------------------
Level- Medium
Question No- **
-----------------
You are given an n x m binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Find the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

___________________________________________________________________________________________________

Example 1:

Input:
grid[][] = {{0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}}
Output:
3
Explanation:
0 0 0 0
1 0 1 0
0 1 1 0
0 0 0 0
The highlighted cells represents the land cells.
Example 2:

Input:
grid[][] = {{0, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 1},
            {0, 1, 1, 0}}
Output:
4
Explanation:
0 0 0 1
0 1 1 0
0 1 1 0
0 0 0 1
0 1 1 0
The highlighted cells represents the land cells.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

// User function Template for Java

class Solution {

    static int row [] = {-1,0,1,0};
    static int col[] = {0,1,0,-1};
    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length, m = grid[0].length, count = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if((i==0 || j==0 || i==n-1 || j==m-1) && grid[i][j]==1){
                    makeZero(i,j,n,m,grid);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1) count++;
            }
        }
        
        return count;
    }
    
    static void makeZero(int i, int j, int n, int m, int[][] grid){
        grid[i][j]=0;
        
        for(int k=0; k<4; k++){
            int r = i+row[k];
            int c = j+col[k];
            
            if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1){
                makeZero(r,c,n,m,grid);
            }
        }
        
    }
}
