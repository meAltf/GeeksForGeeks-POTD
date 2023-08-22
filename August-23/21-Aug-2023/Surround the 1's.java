/******************************************************************************************************************************************************
----------------
Level- Easy
----------------
Given a matrix of order nxm, composed of only 0's and 1's, find the number of 1's in the matrix that are surrounded by an even number (>0) of 0's. 
The surrounding of a cell in the matrix is defined as the elements above, below, on left, on right as well as the 4 diagonal elements around the cell of the matrix. 
Hence, the surrounding of any matrix elements is composed of 8 elements. Find the number of such 1's.

___________________________________________________________________________________________________

Example 1:

Input: 
matrix = {{1, 0, 0}, 
          {1, 1, 0}, 
          {0, 1, 0}}
Output: 
1
Explanation: 
1 that occurs in the 1st row and 1st column, has 3 surrounding elements 0,1 and 1. The occurrence of zero is odd. 
1 that occurs in 2nd row and 1st column has 5 surrounding elements 1,0,1,1 and 0. The occurrence of zero is even. 
1 that occurs in 2nd row and 2nd column has 8 surrounding elements. The occurrence of 0 is odd. 
Similarly, for the 1 that occurs in 3rd row and 2nd column, the occurrence of zero in it's 5 surrounding elements is odd. 
Hence, the output is 1.
Example 2:

Input: 
matrix = {{1}}
Output: 
0
Explanation: 
There is only 1 element in the matrix. Hence, it has no surroundings, so it's count for even 0's is 0 for the whole matrix. 
0 is even but we want occurrence of a zero in the surrounding at least once. 
Hence, output is 0.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
        // code here
        int count=0;
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                
                int zero=0;
                if(matrix[i][j]==1){
                    
                    // rigth
                    if(j+1<matrix[i].length){
                        if(matrix[i][j+1] == 0){
                            zero++;
                        }
                    }
                    
                    // left
                    if(j-1>=0){
                        if(matrix[i][j-1] == 0){
                            zero++;
                        }
                    }
                    
                    // up 
                    if(i-1>=0){
                        if(matrix[i-1][j] == 0){
                            zero++;
                        }
                    }
                    
                    // down only
                    if(i+1<matrix.length){
                        if(matrix[i+1][j] == 0){
                            zero++;
                        }
                    }
                    
                    // right up
                    if(j+1<matrix[i].length && i-1>=0){
                        if(matrix[i-1][j+1] == 0){
                            zero++;
                        }
                    }
                    
                    // right down
                    if(j+1<matrix[i].length && i+1<matrix.length){
                        if(matrix[i+1][j+1] == 0){
                            zero++;
                        }
                    }
                    
                    // left up
                    if(i-1>=0 && j-1>=0){
                        if(matrix[i-1][j-1] == 0){
                            zero++;
                        }
                    }
                    
                    //left down
                    if(j-1>=0 && i+1<matrix.length){
                        if(matrix[i+1][j-1] == 0){
                            zero++;
                        }
                    }
                    
                    //count
                    if(zero!=0 && zero %2==0){
                        count ++;
                    }
                }
            }
        }
        return count;
    }
}