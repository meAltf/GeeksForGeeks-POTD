/******************************************************************************************************************************************************
-------------------------
Level- Hard
Question No-1970
--------------------------
There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.

Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).

You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).

Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.
 
___________________________________________________________________________________________________

Example 1:


Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
Output: 2
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 2.
Example 2:


Input: row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]
Output: 1
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 1.
Example 3:


Input: row = 3, col = 3, cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]
Output: 3
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 3.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution {

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean cancross(int row, int col, int[][] cells, int index){
        int[][] grid = new int[row][col];

        for (int i = 0; i < index; ++i) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        for(int i = 0;i < col;i++){
            if(dfs(grid,0,i)){
                return true;
            }
        }

        return false;
    }

    private boolean dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 1){
            return false;
        }

        if(i == grid.length-1){
            return true;
        }

        grid[i][j] = 1;

        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];

            if(dfs(grid,x,y)){
                return true;
            }
        }

        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int lo = 1, hi = cells.length;

        while(lo < hi){

            int mid = hi - (hi-lo) / 2;

            if(cancross(row,col,cells,mid)){
                lo = mid;
            }
            else{
                hi = mid-1;
            }
        }

        return lo;
    }
}
