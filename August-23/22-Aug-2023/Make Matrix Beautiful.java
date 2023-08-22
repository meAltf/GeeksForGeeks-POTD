/******************************************************************************************************************************************************
------------------------
Level- Medium
-----------------------
A beautiful matrix is a matrix in which the sum of elements in each row and column is equal. Given a square matrix of size NxN. Find the minimum number of operation(s)
that are required to make the matrix beautiful. In one operation you can increment the value of any one cell by 1.

___________________________________________________________________________________________________

Example 1:

Input:
N = 2
matrix[][] = {{1, 2},
              {3, 4}}
Output: 
4
Explanation:
Updated matrix:
4 3
3 4
1. Increment value of cell(0, 0) by 3
2. Increment value of cell(0, 1) by 1
Hence total 4 operation are required.

Example 2:

Input:
N = 3
matrix[][] = {{1, 2, 3},
              {4, 2, 3},
              {3, 2, 1}}
Output: 
6
Explanation:
Number of operations applied on each cell are as follows:
1 2 0
0 0 0
0 1 2
Such that all rows and columns have sum of 9.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        // code here
        
        int sum=0,rowsum=0,colsum=0,finalsum=0;
        
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sum+=matrix[i][j];
            }
        }
        
        for(int i=0;i<N;i++){
            int rcurr=0,ccurr=0;
            for(int j=0;j<N;j++){
                rcurr+=matrix[i][j];
                ccurr+=matrix[j][i];
            }
    
            rowsum=Math.max(rcurr,rowsum);
            colsum=Math.max(ccurr,colsum);
        }
    
            finalsum=Math.max(rowsum,colsum);
            
            int ans=finalsum*N-sum;
            return ans;
    }
}
    
