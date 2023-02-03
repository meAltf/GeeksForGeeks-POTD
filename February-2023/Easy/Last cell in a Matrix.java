/*****************************************************************************************************************************************

Given a binary matrix of dimensions  with R rows and C columns. Start from cell(0, 0), moving in the right direction. Perform the following operations: 

If the value of matrix[i][j] is 0, then traverse in the same direction and check the next value.
If the value of matrix[i][j] is 1, then update matrix[i][j] to 0 and change the current direction clockwise. ie - up, right, down, or left directions change to right, 
down, left, and up respectively.
Find the index of the cell where you will be forced to exit the matrix while performing the given traversal. 

----------------------------------------------------------------------------------------------------------

Example 1:

Input:
matrix[][] = {{0,1},
              {1,0}}
R=2
C=2

Output: (1,1)
Explanation:




Example 2:

Input: 
matrix[][] = {{0, 1, 1, 1, 0},
                   {1, 0, 1, 0, 1},
              {1, 1, 1, 0, 0}}
R=3
C=5

Output: (2,0)
Explanation: We will leave the grid after visiting the index (2,0).

----------------------------------------------------------------------------------------------------------


*****************************************************************************************************************************************/

//User function Template for Java

class Solution{
    static int [] endPoints(int [][]matrix, int R, int C){
        //code 
        
        
        int i = 0;
        int j = 0;
        int ans []= new int[2];
        
        //0->left, 1->up, 2-> right, 3->down
        int direction = 2;
        
        while(i<R && j<C && i>=0 && j>=0){
            
            ans[0]=i;
            ans[1]=j;
            
            if(matrix[i][j]==0){
                
                if(direction == 0)      j--;
                else if(direction == 1) i--;
                else if(direction == 2) j++;
                else if(direction == 3) i++;
            }
            else if(matrix[i][j]==1){
                
                matrix[i][j]=0;
                
                if(direction == 0) direction =      1;
                else if(direction == 1) direction = 2;
                else if(direction == 2) direction = 3;
                else if(direction == 3) direction = 0;
            }
        }
        return ans;
    }
}
