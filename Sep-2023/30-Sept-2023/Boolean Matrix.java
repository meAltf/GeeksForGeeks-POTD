/******************************************************************************************************************************************************
------------------------
Level- Medium
-------------------------

Given a boolean matrix of size RxC where each cell contains either 0 or 1, modify it such that if a matrix cell matrix[i][j] is 1 then all the cells in 
its ith row and jth column will become 1.

___________________________________________________________________________________________________


Example 1:

Input:
R = 2, C = 2
matrix[][] = {{1, 0},
              {0, 0}}
Output: 
1 1
1 0 
Explanation:
Only cell that has 1 is at (0,0) so all 
cells in row 0 are modified to 1 and all 
cells in column 0 are modified to 1.

Example 2:

Input:
R = 4, C = 3
matrix[][] = {{ 1, 0, 0},
              { 1, 0, 0},
              { 1, 0, 0},
              { 0, 0, 0}}
Output: 
1 1 1
1 1 1
1 1 1
1 0 0 
Explanation:
The position of cells that have 1 in
the original matrix are (0,0), (1,0)
and (2,0). Therefore, all cells in row
0,1,2 are and column 0 are modified to 1. 
___________________________________________________________________________________________________

*******************************************************************************************************************************************************/
class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][])
    {
        // approach 1 without using extra space 
        int x =0, y =0;
        int n = matrix.length, m = matrix[0].length;
        
        for(int i=0; i<n; i++){
            if(matrix[i][0]==1) y = 1;
        }
        for(int i=0; i<m; i++){
            if(matrix[0][i]==1) x = 1;
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]==1){
                    matrix[i][0]=1; // store 1 in col 0
                    matrix[0][j]=1;// store 1 in row 0
                }
            }
        }
        
        for(int i=1; i<m; i++){
            if(matrix[0][i]==1){
                for(int j=1; j<n; j++){
                    matrix[j][i]=1;
                }
            }
        }
        for(int i=1; i<n; i++){
            if(matrix[i][0]==1){
                for(int j=1; j<m; j++){
                    matrix[i][j]=1;
                }
            }
        }
        
        if(x==1){
            for(int i=0; i<m; i++){
                matrix[0][i]=1;
            }
        }
        if(y==1){
            for(int i=0; i<n; i++){
                matrix[i][0]=1;
            }
        }
    }
}



// code using Space Complexity : O(r+c)
class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][])
    {
        // code here 
        int n = matrix.length, m = matrix[0].length;
        int row[] = new int[n];
        int col[] = new int[m];
        
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]==1){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(row[i]==1 || col[j]==1){
                    matrix[i][j]=1;
                }
            }
        }
    }
}
