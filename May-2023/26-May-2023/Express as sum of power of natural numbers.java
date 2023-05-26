/******************************************************************************************************************************************************
----------------
Level- Medium
-----------------
Given two numbers n and x, find out the total number of ways n can be expressed as the sum of the Xth power of unique natural numbers.
As the total number of ways can be very large, so return the number of ways modulo 109 + 7. 

___________________________________________________________________________________________________

Example 1:

Input: 
n = 10, x = 2
Output: 
1 
Explanation: 
10 = 12 + 32, Hence total 1 possibility. 
Example 2:

Input: 
n = 100, x = 2
Output: 
3
Explanation: 
100 = 102 
62 + 82 and 12 + 32 + 42 + 52 + 72 
Hence total 3 possibilities. 

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/

//User function Template for Java

class Solution
{
    static int mod = 1000000007;
    static int help(int n,int x,int num,int dp[][]){
        if(n==0)return 1;
        if(num>n || n<0)return 0;
        if(dp[n][num]!=-1)return dp[n][num];
        int temp = (int)Math.pow(num,x);
        return dp[n][num]=(help(n-temp,x,num+1,dp)+help(n,x,num+1,dp))%mod;
    }
    
    static int numOfWays(int n, int x)
    {
        // code here
        int dp[][] = new int[n+1][n+1];
        for(int temp[]:dp)Arrays.fill(temp,-1);
        return help(n,x,1,dp);
    }
}
