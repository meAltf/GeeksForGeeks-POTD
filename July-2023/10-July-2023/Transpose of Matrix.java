/******************************************************************************************************************************************************
------------------------------
Level- EAsy
------------------------------
Write a program to find the transpose of a square matrix of size N*N. Transpose of a matrix is obtained by changing rows to columns and columns to rows.

___________________________________________________________________________________________________

Example 1:

Input:
N = 4
mat[][] = {{1, 1, 1, 1},
           {2, 2, 2, 2}
           {3, 3, 3, 3}
           {4, 4, 4, 4}}
Output: 
{{1, 2, 3, 4},  
 {1, 2, 3, 4}  
 {1, 2, 3, 4}
 {1, 2, 3, 4}} 
Example 2:

Input:
N = 2
mat[][] = {{1, 2},
           {-9, -2}}
Output:
{{1, -9}, 
 {2, -2}}


___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java
class Solution
{
    public void transpose(int n,int a[][])
    {
        if(a.length == 0) return;
        
        int m1 = a.length;
        
        for(int i=0; i<m1; i++){
            
            for(int j=0; j<i; j++){
                
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
        
    }
}
