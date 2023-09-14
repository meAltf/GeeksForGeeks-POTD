/******************************************************************************************************************************************************
--------------------
Level- MEdium
----------------------
Given an array arr[] of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.

Note: Answer can be very large, so, output answer modulo 109+7

___________________________________________________________________________________________________

Example 1:

Input: N = 6, arr[] = {2, 3, 5, 6, 8, 10}
       sum = 10
Output: 3
Explanation: {2, 3, 5}, {2, 8}, {10} are 
possible subsets.
Example 2:
Input: N = 5, arr[] = {1, 2, 3, 4, 5}
       sum = 10
Output: 3
Explanation: {1, 2, 3, 4}, {1, 4, 5}, 
{2, 3, 5} are possible subsets.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    
	   int dp[][] = new int[n+1][sum+1];
	    for(int i=0; i<=n; i++){
	        dp[i][0] = 1;
	    }
	    
	    for(int i=1; i<=n; i++){
	        for(int j=0; j<=sum; j++){
	            if(arr[i-1]<=j) dp[i][j] = (dp[i-1][j] + dp[i-1][j-arr[i-1]])%1000000007;
	            else dp[i][j] = dp[i-1][j];
	        }
	    }
	    
	    return dp[n][sum];
	} 
}
