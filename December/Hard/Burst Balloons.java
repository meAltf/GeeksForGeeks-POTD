/******************************************************************************************************************************************************

You are given N balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array arr. You are asked to burst all the balloons.
If you burst the ith balloon, you will get arr[ i - 1 ] * arr[ i ] * arr[ i + 1] coins. If i - 1, or i + 1 goes out of the bounds of the array, consider it as if there 
is a balloon with a 1 painted on it.
Return the maximum coins you can collect by bursting the balloons wisely.

---------------------------------------------------------------------------------------

Example 1:

Input:
N = 4
arr[ ] = {3, 1, 5, 8}
Output: 167
Explanation: 
arr[ ] = {3, 1, 5, 8}  - - > {3, 5, 8} - - > {3, 8} - - > { 8} - -> { }
coins = 3 *1 *5,      +      3*5*8     +   1*3*8   +  1*8*1   = 167
 
 

Example 2:

Input:
N = 2
arr[ ] = {1, 10}
Output: 20

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution {
  public static int maxCoins(int N, int[] arr) {
    // code here
    int dp[][] = new int[N][N];
    for(int x = 0;x<N;x++){
        
        for(int i =0,j=x;j<N;i++,j++){
            
            int ans = Integer.MIN_VALUE;
            for(int k =i;k<=j;k++){
                
                int left = i==k?0:dp[i][k-1];
                int right = j==k?0:dp[k+1][j];
                int val = (i == 0 ? 1:arr[i-1])*arr[k]*(j==N-1?1:arr[j+1]);
                
                int total = left+right+val;
                ans = Math.max(total, ans);
            }
            dp[i][j] = ans;
        }
    }
    return dp[0][N-1];
  }
}
   
