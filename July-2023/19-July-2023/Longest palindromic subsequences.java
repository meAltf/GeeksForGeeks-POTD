/******************************************************************************************************************************************************
--------------------
Level- Medium
---------------------
Given a String, find the longest palindromic subsequence.

___________________________________________________________________________________________________

Example 1:

Input:
S = "bbabcbcab"
Output: 7
Explanation: Subsequence "babcbab" is the
longest subsequence which is also a palindrome.

Example 2:

Input: 
S = "abcd"
Output: 1
Explanation: "a", "b", "c" and "d" are
palindromic and all have a length 1.

___________________________________________________________________________________________________

*******************************************************************************************************************************************************/



//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        //code here
        String rev = helper(S);
        int m = rev.length();
        int dp[][] = new int[m+1][m+1];
        
        for(int i = 0; i<=m; i++)
            for(int j = 0; j<=m; j++){
                if(i == 0)
                    dp[i][j] = 0;
                else if(j == 0)
                    dp[i][j] = 0;
                else if(S.charAt(i-1) == rev.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]); 
            }
        
        return dp[rev.length()][rev.length()];
    }
    
    public static String helper(String s){
        String rev = "";
        
        for(int i = s.length()-1; i>=0; i--)
            rev += s.charAt(i);
            
        return rev;
    }
}
