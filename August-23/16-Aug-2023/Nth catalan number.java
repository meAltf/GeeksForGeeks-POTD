/******************************************************************************************************************************************************
---------------------------
Level- Medium
---------------------------
Given a number N. The task is to find the Nth catalan number.
The first few Catalan numbers for N = 0, 1, 2, 3, … are 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …

Catalan Number for N is equal to the number of expressions containing N pairs of paranthesis that are correct matched, i.e., for each of the N '(' there exist N ')' on there right 
and vice versa.

Since answer can be huge return answer modulo 1e9+7.

Note: Positions start from 0 as shown above.

___________________________________________________________________________________________________

Example 1:

Input:
N = 5
Output: 42
Example 2:

Input:
N = 4
Output: 14

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/


class Solution {
    
    
    public static int findCatalan(int n) {
        // code here
        
       int mod=(int)1e9+7;
        if(n<=1){
             return 1;
         }
      
         
        int []dp=new int[n+2];
        dp[0]=1;
        dp[1]=1;
        
        for(int i=2;i<=n;i++){
            // dp[i]=0;
             for(int j=0;j<i;j++){
                   dp[i]=  (dp[i] + (int)((long)dp[j] * dp[i - j - 1] % mod)) % mod;
             }
        }
        
        return dp[n];
    }
}
     
