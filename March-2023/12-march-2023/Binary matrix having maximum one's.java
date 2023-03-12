/******************************************************************************************************************************************************
------------------
level- Easy
-------------------
Given a binary matrix (containing only 0 and 1) of order NxN. All rows are sorted already, We need to find the row number with the maximum number of 1s. 
Also, find the number of 1s in that row.
Note:

1. In case of a tie, print the smaller row number.
2. Row number should start from 0th index.

---------------------------------------------------------------------------------------

Example 1

Input:
N=3
mat[3][3] = {0, 0, 1, 
              0, 1, 1, 
              0, 0, 0}
Output:
Row number = 1
MaxCount = 2
Explanation:
Here, max number of 1s is in row number 1
and its count is 2.
Example 2

Input:
N=3
mat[3][3] = {1, 1, 1, 
              1, 1, 1, 
              0, 0, 0}
Output:
Row number = 0
MaxCount = 3

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution {
    public int[] findMaxRow(int mat[][], int N) {
        // code here
        
        int[] res = new int[2];
         int max = 0;
         int row = 0;
         
         for(int i = 0; i<N; i++){
             int count = 0;
             for(int j = 0; j<N; j ++){
                 if(mat[i][j] == 1){
                     count++;
                 }
             }
             
             if(count>max){
                 max = count;
                 row = i;
             }
             
         }
         res[0] = row;
         res[1] = max;
         
         return res;
         
    }
};
