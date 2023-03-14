/******************************************************************************************************************************************************
----------------
Level- Hard 
-----------------
We have been given N balloons, each with a number of coins associated with it. On bursting a balloon i,
the number of coins gained is equal to A[i-1]*A[i]*A[i+1].
Also, balloons i-1 and i+1 now become adjacent. Find the maximum possible profit earned after bursting all the balloons. Assume an extra 1 at each boundary.

---------------------------------------------------------------------------------------
Example 1:

Input: 
N=2
a[]={5, 10}
Output: 
60
Explanation: First Burst 5, Coins = 1*5*10
              Then burst 10, Coins+= 1*10*1
              Total = 60
Example 2:

Input:
N=4
a[] = {3,1,5,8}
Output:
167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167.

----------------------------------------------------------------------------------------

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution{
    int maxCoins(int N, ArrayList<Integer> arr) {
		//Write your code here
		arr.add(0, 1);
        arr.add(1);
        
        int n = arr.size();
        int[][] dp = new int[n][n];
        
        // l is the length of the subarray
        for (int l = 3; l <= n; l++) {
            // i is the starting index of the subarray
            for (int i = 0; i <= n - l; i++) {
                // j is the ending index of the subarray
                int j = i + l - 1;
                // k is the index of the last balloon to be burst
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr.get(i) * arr.get(k) * arr.get(j));
                }
            }
        }
        return dp[0][n-1];
	}
}
