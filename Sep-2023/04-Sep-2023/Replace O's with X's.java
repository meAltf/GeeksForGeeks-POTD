/******************************************************************************************************************************************************
-----------------------
Level- MEdium
-----------------------
Given a matrix mat of size N x M where every element is either 'O' or 'X'. Replace all 'O' with 'X' that are surrounded by 'X'.

A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are 'X' at locations just below, just above, just left and just right of it.

___________________________________________________________________________________________________

Example 1:

Input: 
n = 5, m = 4
mat = {{'X', 'X', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Output: 
ans = {{'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Explanation: 
Following the rule the above matrix is the resultant matrix. 
Example 2:

 

Input: 
n = 5, m = 4
mat = {{'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Output: 
ans = {{'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'O', 'O', 'X'}, 
       {'X', 'O', 'X', 'X'}, 
       {'X', 'X', 'O', 'O'}}
Explanation: 
Following the rule the above matrix is the resultant matrix.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
         for(int i=0;i<n;i++){
          //1st column
          if(a[i][0] == 'O'){
              dfs(i,0,n,m,a);
          }
          //last column
          if(a[i][m-1] == 'O'){
              dfs(i,m-1,n,m,a);
          }
      }
      for(int j=0;j<m;j++){
          //1st row
          if(a[0][j] == 'O'){
              dfs(0,j,n,m,a);
          }
          //last row
          if(a[n-1][j] == 'O'){
              dfs(n-1,j,n,m,a);
          }
      }
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(a[i][j] == '0') a[i][j] = 'O';
              else if(a[i][j] == 'O') a[i][j] = 'X';
          }
      }
      return a;
    }
    static void dfs(int r, int c,int n,int m, char a[][]){
        if(r>=n || c>=m || r<0 || c<0)
        return;
        if(a[r][c] == '0' || a[r][c] == 'X')
        return;
        
        a[r][c] = '0';
        dfs(r+1,c,n,m,a);
        dfs(r-1,c,n,m,a);
        dfs(r,c+1,n,m,a);
        dfs(r,c-1,n,m,a);
    }
}
