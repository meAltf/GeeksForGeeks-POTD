/********************************************************************************************************************************

Given two strings S1 and S2 of equal length, the task is to determine if S2 is a scrambled form of S1.

Scrambled string: Given string str, we can represent it as a binary tree by partitioning it into two non-empty substrings recursively.
Below is one possible representation of str = coder:
 
To scramble the string, we may choose any non-leaf node and swap its two children. 
Suppose, we choose the node co and swap its two children, it produces a scrambled string ocder.
Similarly, if we continue to swap the children of nodes der and er, it produces a scrambled string ocred.

Note: Scrambled string is not the same as an Anagram.

Print "Yes" if S2 is a scrambled form of S1 otherwise print "No".


------------------------------------------------------------------------------------------

Example 1:

Input: S1="coder", S2="ocder"

Output: Yes

Explanation: ocder is a scrambled 
form of coder.

    ocder
   /    \
  oc    der
 / \    
o   c  

As "ocder" can represent it 
as a binary tree by partitioning 
it into two non-empty substrings.
We just have to swap 'o' and 'c' 
to get "coder".


Example 2:

Input: S1="abcde", S2="caebd" 

Output: No

Explanation: caebd is not a 
scrambled form of abcde.

-------------------------------------------------------------------------------------------------

******************************************************************************************************************************/


//User function Template for Java

class Solution{
    
    
    static boolean isScramble(String S1,String S2)
    {
        //code here
        if (S1.length() != S2.length()) return false;
        int n = S1.length();
      
        // create a 3D dp array
        boolean[][][] dp = new boolean[n][n][n + 1];
        // fill the dp array with the base cases
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = S1.charAt(i) == S2.charAt(j);
            }
        }
        // fill the dp array using dynamic programming
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for (int k = 1; k < len; k++) {
                        if (dp[i][j][k] && dp[i + k][j + k][len - k] || 
                            dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    
    }
}
