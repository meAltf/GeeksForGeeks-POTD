/******************************************************************************************************************************************************
-----------------------
Level- Medium
----------------------
Given a rod of length N inches and an array of prices, price[]. price[i] denotes the value of a piece of length i. 
Determine the maximum value obtainable by cutting up the rod and selling the pieces.

Note: Consider 1-based indexing.

___________________________________________________________________________________________________

Example 1:

Input:
N = 8
Price[] = {1, 5, 8, 9, 10, 17, 17, 20}
Output:
22
Explanation:
The maximum obtainable value is 22 by 
cutting in two pieces of lengths 2 and 
6, i.e., 5+17=22.
Example 2:

Input:
N=8
Price[] = {3, 5, 8, 9, 10, 17, 17, 20}
Output: 
24
Explanation: 
The maximum obtainable value is 
24 by cutting the rod into 8 pieces 
of length 1, i.e, 8*3=24. 

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


    class Solution{
    int dp[];
    public int cutRod(int price[], int n) {
        //code here
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, price);
    }
    int solve(int n, int[] price) {
        if(dp[n] != -1)
            return dp[n];
        if(n == 0)
            return 0;
        int ans = 0;
        for(int i=0; i<n; i++) {
            ans = Math.max(ans, price[i] + solve(n-i-1, price));
        }
        dp[n] = ans;
        return dp[n];
    }
}
    
