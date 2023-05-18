/******************************************************************************************************************************************************
-----------------------
Level-Hard
-----------------------
Given a binary matrix mat[][] of dimensions NxM such that 1 denotes land and 0 denotes water. Find the number of closed islands in the given matrix.

Note: A closed island is a group of 1s surrounded by only 0s on all the boundaries (except diagonals).
In simple words, a closed island is an island whose none of the 1s lie on the edges of the matrix.

___________________________________________________________________________________________________

Example 1:

Input:
N = 5, M = 8
mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 0, 1}, 
           {0, 1, 0, 1, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 1, 0}, 
           {1, 0, 0, 0, 0, 1, 0, 1}}
Output:
2
Explanation:
mat[][] = {{0, 0, 0, 0, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 0, 1}, 
           {0, 1, 0, 1, 0, 0, 0, 1}, 
           {0, 1, 1, 1, 1, 0, 1, 0}, 
           {1, 0, 0, 0, 0, 1, 0, 1}} 
There are 2 closed islands. The islands in dark are closed because they are completely surrounded by 0s (water). There are two more islands in the last column of the matrix, but they are not completely surrounded by 0s. Hence they are not closed islands. 
Example 2:

Input:
N = 3, M = 3
mat[][] = {{1, 0, 0},
           {0, 1, 0},
           {0, 0, 1}}
Output: 
1
Explanation:
mat[][] = {{1, 0, 0},
          {0, 1, 0},
          {0, 0, 1}}
There is just a one closed island.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution
{
       static void help(int arr[][],int i,int j,int N,int M){
        if(i<0 || j<0 || i==N || j==M || arr[i][j]==0)return;
        arr[i][j]=0;
        help(arr,i+1,j,N,M);
        help(arr,i-1,j,N,M);
        help(arr,i,j+1,N,M);
        help(arr,i,j-1,N,M);
    }
    public int closedIslands(int[][] matrix, int N, int M)
    {
        // Code here
        int ans=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(matrix[i][j]==1){
                    if(i==0 || j==0 || i==N-1 || j==M-1){
                        help(matrix,i,j,N,M);
                    }
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(matrix[i][j]==1){
                    ans++;
                    help(matrix,i,j,N,M);
                }
            }
        }
        return ans;
    }
}
