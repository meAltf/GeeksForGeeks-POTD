/**************************************************
-------------------
Level- Hard
--------------------
iven an incomplete Sudoku configuration in terms of a 9 x 9  2-D square matrix (grid[][]), the task is to find a solved Sudoku. For simplicity,
you may assume that there will be only one unique solution.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Zeros in the grid indicates blanks, which are to be filled with some number between 1-9. You can not replace the element in the cell which is not blank.


Sample Sudoku for you to get the logic for its solution:

_________________________________

Example 1:

Input:
grid[][] = 
[[3 0 6 5 0 8 4 0 0],
[5 2 0 0 0 0 0 0 0],
[0 8 7 0 0 0 0 3 1 ],
[0 0 3 0 1 0 0 8 0],
[9 0 0 8 6 3 0 0 5],
[0 5 0 0 9 0 6 0 0],
[1 3 0 0 0 0 2 5 0],
[0 0 0 0 0 0 0 7 4],
[0 0 5 2 0 6 3 0 0]]
Output:
True
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9
Explanation: 
There exists a valid Sudoku for the input grid, which is shown in output.

Example 2:

Input:
grid[][] = 
[[3 6 6 5 0 8 4 0 0],
[5 2 0 0 0 0 0 0 0],
[0 8 7 0 0 0 0 3 1 ],
[0 0 3 0 1 0 0 8 0],
[9 0 0 8 6 3 0 0 5],
[0 5 0 0 9 0 6 0 0],
[1 3 0 0 0 0 2 5 0],
[0 0 0 0 0 0 0 7 4],
[0 0 5 2 0 6 3 0 0]]
Output:
False
Explanation: 
There does not exists a valid Sudoku for the input grid, since there are two 6s in the first row. Which cannot replaced.

_________________________________

***************************************************/

//User function Template for Java

class Solution
{
    //function for checking safe condition
    public static boolean isSafe(int grid[][], int num, int row, int col){
        for(int i=0; i<9; i++){
            if(grid[i][col] == num){
                return false;
            }
            if(grid[row][i] == num){
                return false;
            }
        }
        
        int StartR = (row/3)*3, StartC = (col/3)*3;
        for(int i=StartR; i<=StartR+2; i++){
            for(int j=StartC; j<StartC+3; j++){
                if(grid[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
    
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        int row = 0, col = 0;
        return helper(grid, row, col);
    }
    
    static boolean helper(int grid[][], int row, int col){
        if(row == 9){
            return true;       
        }
        int NextR = row, NextC = col+1;
        if(col+1 == 9){
            NextR = row+1; NextC = 0;
        }
        
        if(grid[row][col] != 0){
            return helper(grid, NextR, NextC);
        }
        
        for(int i=1; i<=9; i++){
            if(isSafe(grid,i,row,col)){
                grid[row][col] = i;
                if(helper(grid,NextR,NextC)){
                    return true;
                }
                grid[row][col] = 0;
            }
        }
        return false;
    }
    
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}
